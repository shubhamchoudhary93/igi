package com.shubham.igi.client.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.shubham.igi.client.data.model.Client
import com.shubham.igi.client.data.model.ClientWithReceipts

@Dao
interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClient(client: Client): Long

    @Update
    suspend fun updateClient(client: Client)

    @Delete
    suspend fun deleteClient(client: Client)

    @Query("SELECT * FROM Client")
    suspend fun getAllClients(): List<Client>

    @Transaction
    @Query("SELECT * FROM Client WHERE clientId = :id")
    suspend fun getClientWithReceipts(id: Long): ClientWithReceipts?
}