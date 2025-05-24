package com.shubham.igi.client.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Client(
    @PrimaryKey(autoGenerate = true) val clientId: Long = 0,
    val name: String,
    val address: String? = null,
    val phone: String? = null
)