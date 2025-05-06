package com.shubham.igi.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.shubham.igi.data.model.FilmInventoryItem
import kotlinx.coroutines.flow.Flow

@Dao
interface FilmInventoryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: FilmInventoryItem)

    @Update
    suspend fun updateItem(item: FilmInventoryItem)

    @Query("SELECT * FROM FilmInventoryItem")
    fun getAllItems(): Flow<List<FilmInventoryItem>>

    @Query("SELECT * FROM FilmInventoryItem WHERE id = :id")
    suspend fun getItem(id: Int): FilmInventoryItem

    @Query("SELECT * FROM FilmInventoryItem WHERE id = :id LIMIT 1")
    suspend fun getItemById(id: Int): FilmInventoryItem
}