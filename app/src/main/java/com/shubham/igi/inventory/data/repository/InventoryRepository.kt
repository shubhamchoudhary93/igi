package com.shubham.igi.inventory.data.repository

import android.content.Context
import com.shubham.igi.inventory.data.dao.InventoryDao
import com.shubham.igi.inventory.data.dao.UpdateDao
import com.shubham.igi.inventory.data.model.InventoryItem
import com.shubham.igi.inventory.data.model.InventoryUpdate
import com.shubham.igi.utils.backupDatabase
import kotlinx.coroutines.flow.Flow

class InventoryRepository(
    private val inventoryDao: InventoryDao,
    private val updateDao: UpdateDao,
    private val context: Context
) {

    fun getAllItems(): Flow<List<InventoryItem>> {
        return inventoryDao.getAllItems()
    }

    fun getAllUpdates(): Flow<List<InventoryUpdate>> {
        return updateDao.getAllUpdates()
    }

    suspend fun insertItem(item: InventoryItem) {
        inventoryDao.insertItem(item)
        backupDatabase(context)
    }

    suspend fun updateItem(item: InventoryItem) {
        inventoryDao.updateItem(item)
        backupDatabase(context)
    }

    suspend fun applyUpdate(update: InventoryUpdate) {
        // Record the update in the update history
        updateDao.insertUpdate(update)

        // Apply the change to the inventory item
        val item = inventoryDao.getItemById(update.itemId)
        val updatedItem = item.copy(amount = item.amount + update.change)
        inventoryDao.updateItem(updatedItem)

        backupDatabase(context)
    }

    suspend fun deleteItem(item: InventoryItem) {
        inventoryDao.delete(item)
        backupDatabase(context)
    }
}