package com.shubham.igi.inventory.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.shubham.igi.inventory.data.model.InventoryUpdate
import kotlinx.coroutines.flow.Flow

@Dao
interface UpdateDao {
    @Insert
    suspend fun insertUpdate(update: InventoryUpdate)

    @Query("SELECT * FROM InventoryUpdate ORDER BY date DESC")
    fun getAllUpdates(): Flow<List<InventoryUpdate>>
}