package com.shubham.igi.inventory.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.shubham.igi.inventory.data.model.FilmInventoryItem
import com.shubham.igi.inventory.data.repository.FilmInventoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class FilmInventoryViewModel(private val repository: FilmInventoryRepository) : ViewModel() {

    private val _filmInventoryItems = MutableStateFlow<List<FilmInventoryItem>>(emptyList())
    val filmInventoryItems: StateFlow<List<FilmInventoryItem>> = _filmInventoryItems.asStateFlow()

    // ✅ New: State for selected item
    private val _selectedItem = MutableStateFlow<FilmInventoryItem?>(null)
    val selectedItem: StateFlow<FilmInventoryItem?> = _selectedItem.asStateFlow()

    init {
        loadItems()
    }

    private fun loadItems() {
        viewModelScope.launch {
            repository.getAllItems().collect {
                _filmInventoryItems.value = it
            }
        }
    }

    fun insertItem(item: FilmInventoryItem) = viewModelScope.launch {
        repository.insertItem(item)
    }

    fun updateItem(item: FilmInventoryItem) = viewModelScope.launch {
        repository.updateItem(item)
    }

    // ✅ Set the selected item for editing
    fun setSelectedItem(item: FilmInventoryItem) {
        _selectedItem.value = item
    }

    // ✅ Clear the selected item after save
    fun clearSelectedItem() {
        _selectedItem.value = null
    }

    private fun currentDateString(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }

    fun deleteItem(item: FilmInventoryItem) = viewModelScope.launch {
        repository.deleteItem(item)
    }


    class Factory(private val repository: FilmInventoryRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(FilmInventoryViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return FilmInventoryViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }
}