package com.shubham.igi.client.data.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(
    foreignKeys = [ForeignKey(
        entity = Client::class,
        parentColumns = ["clientId"],
        childColumns = ["clientOwnerId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("clientOwnerId")]
)
data class Receipt(
    @PrimaryKey(autoGenerate = true) val receiptId: Long = 0,
    val clientOwnerId: Long,
    val date: LocalDate,
    val amount: Double,
    val paidAmount: Double = 0.0,
    val imageUri: String
)