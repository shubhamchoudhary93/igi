package com.shubham.igi.client.data.model

import androidx.room.Embedded
import androidx.room.Relation

data class ClientWithReceipts(
    @Embedded val client: Client,
    @Relation(
        parentColumn = "clientId",
        entityColumn = "clientOwnerId"
    )
    val receipts: List<Receipt>
)