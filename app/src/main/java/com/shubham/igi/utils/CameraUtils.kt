package com.shubham.igi.utils

import android.content.Context
import android.net.Uri
import android.os.Environment
import androidx.core.content.FileProvider
import java.io.File
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

fun createImageFile(context: Context): Pair<File, Uri> {
    val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss", Locale.US).format(Date())
    val storageDir: File = context.getExternalFilesDir(Environment.DIRECTORY_PICTURES)!!
    val file = File.createTempFile("RECEIPT_${timeStamp}_", ".jpg", storageDir)
    val uri = FileProvider.getUriForFile(context, "${context.packageName}.provider", file)
    return Pair(file, uri)
}