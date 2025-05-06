package com.shubham.igi.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InventoryUpdate(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val itemId: Int,
    val itemName: String,
    val category: String,
    val date: String,
    val change: Int
)