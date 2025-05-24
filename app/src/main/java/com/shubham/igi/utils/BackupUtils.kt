package com.shubham.igi.utils

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import java.io.BufferedInputStream
import java.io.BufferedOutputStream
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.util.zip.ZipEntry
import java.util.zip.ZipInputStream
import java.util.zip.ZipOutputStream

private fun zipDatabaseFiles(databaseFiles: List<File>, outputZip: File) {
    ZipOutputStream(BufferedOutputStream(FileOutputStream(outputZip))).use { zipOut ->
        databaseFiles.forEach { file ->
            FileInputStream(file).use { input ->
                val entry = ZipEntry(file.name)
                zipOut.putNextEntry(entry)
                input.copyTo(zipOut)
                zipOut.closeEntry()
            }
        }
    }
}

private fun uploadZipToFirebase(
    zipFile: File,
    onSuccess: () -> Unit,
    onFailure: (Exception) -> Unit
) {
    val storage = Firebase.storage
    val storageRef = storage.reference
    val backupsRef = storageRef.child("backups")
    val newFileRef = backupsRef.child(zipFile.name)
    val uri = Uri.fromFile(zipFile)

    newFileRef.putFile(uri)
        .addOnSuccessListener {
            // Clean up old backups: keep only the latest 10
            backupsRef.listAll()
                .addOnSuccessListener { listResult ->
                    val sorted = listResult.items.sortedByDescending {
                        it.name.substringAfter("backup_").substringBefore(".zip").toLongOrNull()
                            ?: 0L
                    }
                    val filesToDelete = sorted.drop(10)

                    filesToDelete.forEach { fileRef ->
                        fileRef.delete().addOnSuccessListener {
                            Log.d("Backup", "Deleted old backup: ${fileRef.name}")
                        }.addOnFailureListener {
                            Log.w("Backup", "Failed to delete old backup: ${fileRef.name}", it)
                        }
                    }

                    onSuccess()
                }
                .addOnFailureListener { listErr ->
                    Log.e("Backup", "Failed to list backups for cleanup", listErr)
                    onSuccess() // Still consider the upload successful
                }

        }
        .addOnFailureListener { exception -> onFailure(exception) }
}

fun backupDatabase(
    context: Context,
    onSuccess: () -> Unit = {},
    onFailure: (Exception) -> Unit = {}
) {
    val dbPath = context.getDatabasePath("inventory_database")
    if (dbPath.exists()) {
        val dbShm = File(dbPath.parent, "inventory_database-shm")
        val dbWal = File(dbPath.parent, "inventory_database-wal")
        val timestamp = System.currentTimeMillis()
        val zipFile = File(context.cacheDir, "backup_$timestamp.zip")

        zipDatabaseFiles(listOf(dbPath, dbShm, dbWal), zipFile)

        uploadZipToFirebase(
            zipFile,
            onSuccess,
            onFailure
        )
    } else {
        Log.e("Backup", "Database file does not exist yet")
    }
}

fun restoreDatabase(
    context: Context,
    onSuccess: () -> Unit = {},
    onFailure: (Exception) -> Unit = {}
) {
    val storage = Firebase.storage
    val storageRef = storage.reference.child("backups")

    storageRef.listAll()
        .addOnSuccessListener { listResult ->
            val latestFileRef = listResult.items.maxByOrNull {
                it.name.substringAfter("backup_").substringBefore(".zip").toLongOrNull() ?: 0L
            }

            if (latestFileRef != null) {
                val localZip = File(context.cacheDir, "restore_backup.zip")
                latestFileRef.getFile(localZip)
                    .addOnSuccessListener {
                        unzipDatabaseFiles(localZip, context)
                        onSuccess()
                    }
                    .addOnFailureListener { e ->
                        Log.e("Restore", "Download failed", e)
                        onFailure(e)
                    }
            } else {
                val ex = Exception("No backup files found")
                Log.e("Restore", ex.message ?: "")
                onFailure(ex)
            }
        }
        .addOnFailureListener { e ->
            Log.e("Restore", "Failed to list backup files", e)
            onFailure(e)
        }
}

private fun unzipDatabaseFiles(zipFile: File, context: Context) {
    val dbDir = context.getDatabasePath("inventory_database").parentFile

    ZipInputStream(BufferedInputStream(FileInputStream(zipFile))).use { zipIn ->
        var entry: ZipEntry? = zipIn.nextEntry
        while (entry != null) {
            val outFile = File(dbDir, entry.name)
            FileOutputStream(outFile).use { output ->
                zipIn.copyTo(output)
            }
            zipIn.closeEntry()
            entry = zipIn.nextEntry
        }
    }
    Log.d("Restore", "Database files restored")
}