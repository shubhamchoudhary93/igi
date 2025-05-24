package com.shubham.igi.inventory.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shubham.igi.inventory.data.model.FilmInventoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmInventoryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: FilmInventoryItem)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItems(items: List<FilmInventoryItem>)

    @Update
    suspend fun updateItem(item: FilmInventoryItem)

    @Delete
    suspend fun deleteItem(item: FilmInventoryItem)

    @Query("DELETE FROM FilmInventoryItem")
    suspend fun clearAll()

    @Query("SELECT * FROM FilmInventoryItem")
    fun getAllItems(): Flow<List<FilmInventoryItem>>

    @Query("SELECT * FROM FilmInventoryItem WHERE id = :id LIMIT 1")
    suspend fun getItemById(id: Int): FilmInventoryItem
}