package com.shubham.igi.data.repository

import com.shubham.igi.data.dao.FilmInventoryDao
import com.shubham.igi.data.model.FilmInventoryItem
import kotlinx.coroutines.flow.Flow

class FilmInventoryRepository(
    private val filmInventoryDao: FilmInventoryDao
) {

    fun getAllItems(): Flow<List<FilmInventoryItem>> {
        return filmInventoryDao.getAllItems()
    }


    suspend fun insertItem(item: FilmInventoryItem) {
        filmInventoryDao.insertItem(item)
    }

    suspend fun updateItem(item: FilmInventoryItem) {
        filmInventoryDao.updateItem(item)
    }
}