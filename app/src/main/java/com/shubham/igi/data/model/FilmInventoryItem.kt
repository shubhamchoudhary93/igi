package com.shubham.igi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FilmInventoryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val size: Int,
    val weight: Float,
    val addDate: String,
    val removeData: String = "",
)