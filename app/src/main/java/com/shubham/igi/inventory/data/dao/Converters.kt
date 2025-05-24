package com.shubham.igi.inventory.data.dao

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.room.TypeConverter
import java.time.LocalDate

class Converters {
    @TypeConverter
    fun fromDate(value: LocalDate): String = value.toString()

    @RequiresApi(Build.VERSION_CODES.O)
    @TypeConverter
    fun toDate(value: String): LocalDate = LocalDate.parse(value)
}