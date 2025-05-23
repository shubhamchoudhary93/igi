package com.shubham.igi.inventory.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InventoryItem(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val category: String,
    val amount: Int,
    val defaultChange: Int = 1,
    val minQ: Int = 1
)