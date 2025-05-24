package com.shubham.igi.inventory.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shubham.igi.inventory.data.model.InventoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface InventoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: InventoryItem)

    @Update
    suspend fun updateItem(item: InventoryItem)

    @Query("SELECT * FROM InventoryItem")
    fun getAllItems(): Flow<List<InventoryItem>>

    @Query("SELECT * FROM InventoryItem WHERE id = :id")
    suspend fun getItem(id: Int): InventoryItem

    @Query("SELECT * FROM InventoryItem WHERE id = :id LIMIT 1")
    suspend fun getItemById(id: Int): InventoryItem

    @Delete
    suspend fun delete(item: InventoryItem)
}