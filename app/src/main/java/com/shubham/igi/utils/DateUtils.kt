package com.shubham.igi.util

import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Converts a date string from "yyyy-MM-dd" format to a more readable format like "9 May 2025".
 */
fun formatDateToReadable(dateStr: String): String {
    return try {
        val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val outputFormat = SimpleDateFormat("d MMM yyyy", Locale.getDefault())
        val date = inputFormat.parse(dateStr)
        if (date != null) outputFormat.format(date) else dateStr
    } catch (e: Exception) {
        dateStr // fallback if parsing fails
    }
}
