package com.shubham.igi.data.repository

import com.shubham.igi.data.dao.InventoryDao
import com.shubham.igi.data.dao.UpdateDao
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import kotlinx.coroutines.flow.Flow

class InventoryRepository(
    private val inventoryDao: InventoryDao,
    private val updateDao: UpdateDao
) {

    fun getAllItems(): Flow<List<InventoryItem>> {
        return inventoryDao.getAllItems()
    }

    fun getAllUpdates(): Flow<List<InventoryUpdate>> {
        return updateDao.getAllUpdates()
    }

    suspend fun insertItem(item: InventoryItem) {
        inventoryDao.insertItem(item)
    }

    suspend fun updateItem(item: InventoryItem) {
        inventoryDao.updateItem(item)
    }

    suspend fun applyUpdate(update: InventoryUpdate) {
        // First, record the update in the update history
        updateDao.insertUpdate(update)

        // Then, apply the change to the inventory item
        val item = inventoryDao.getItemById(update.itemId)
        val updatedItem = item.copy(amount = item.amount + update.change)
        inventoryDao.updateItem(updatedItem)
    }
}