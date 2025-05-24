package com.shubham.igi.client.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shubham.igi.client.data.model.Receipt

@Dao
interface ReceiptDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertReceipt(receipt: Receipt): Long

    @Query("SELECT * FROM Receipt WHERE clientOwnerId = :clientId")
    suspend fun getReceiptsForClient(clientId: Long): List<Receipt>

    @Query("SELECT * FROM Receipt WHERE receiptId = :receiptId")
    suspend fun getReceipt(receiptId: Long): Receipt?

    @Update
    suspend fun updateReceipt(receipt: Receipt)
}