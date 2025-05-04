package com.shubham.igi.data.dao

import androidx.room.*
import com.shubham.igi.data.model.InventoryItem
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
}