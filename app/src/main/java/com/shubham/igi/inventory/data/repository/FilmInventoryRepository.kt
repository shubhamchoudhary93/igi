package com.shubham.igi.inventory.data.repository

import android.content.Context
import com.shubham.igi.inventory.data.dao.FilmInventoryDao
import com.shubham.igi.inventory.data.model.FilmInventoryItem
import com.shubham.igi.utils.backupDatabase
import kotlinx.coroutines.flow.Flow

class FilmInventoryRepository(
    private val filmInventoryDao: FilmInventoryDao,
    private val context: Context
) {

    fun getAllItems(): Flow<List<FilmInventoryItem>> {
        return filmInventoryDao.getAllItems()
    }

    suspend fun insertItem(item: FilmInventoryItem) {
        filmInventoryDao.insertItem(item)
        backupDatabase(context)
    }

    suspend fun insertItems(items: List<FilmInventoryItem>) {
        filmInventoryDao.insertItems(items)
        backupDatabase(context)
    }

    suspend fun updateItem(item: FilmInventoryItem) {
        filmInventoryDao.updateItem(item)
        backupDatabase(context)
    }

    suspend fun deleteItem(item: FilmInventoryItem) {
        filmInventoryDao.deleteItem(item)
        backupDatabase(context)
    }

    suspend fun clearAll() {
        filmInventoryDao.clearAll()
        backupDatabase(context)
    }
}