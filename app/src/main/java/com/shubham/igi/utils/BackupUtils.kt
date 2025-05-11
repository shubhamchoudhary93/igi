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
    val fileRef = storageRef.child("backups/${zipFile.name}") // Customize path

    val uri = Uri.fromFile(zipFile)
    fileRef.putFile(uri)
        .addOnSuccessListener { onSuccess() }
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
        val zipFile = File(context.cacheDir, "backup.zip")

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
    val storageRef = storage.reference.child("backups")  // folder containing zip files

    // Get the list of backup files and download the latest one
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