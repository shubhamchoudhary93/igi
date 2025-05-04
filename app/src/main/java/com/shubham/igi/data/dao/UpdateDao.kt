package com.shubham.igi.data.dao

import androidx.room.*
import com.shubham.igi.data.model.InventoryUpdate
import kotlinx.coroutines.flow.Flow

@Dao
interface UpdateDao {
    @Insert
    suspend fun insertUpdate(update: InventoryUpdate)

    @Query("SELECT * FROM InventoryUpdate ORDER BY date DESC")
    fun getAllUpdates(): Flow<List<InventoryUpdate>>
}