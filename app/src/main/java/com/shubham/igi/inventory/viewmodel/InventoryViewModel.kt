package com.shubham.igi.inventory.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.shubham.igi.inventory.data.model.InventoryItem
import com.shubham.igi.inventory.data.model.InventoryUpdate
import com.shubham.igi.inventory.data.repository.InventoryRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class InventoryViewModel(private val repository: InventoryRepository) : ViewModel() {

    private val _inventoryItems = MutableStateFlow<List<InventoryItem>>(emptyList())
    val inventoryItems: StateFlow<List<InventoryItem>> = _inventoryItems.asStateFlow()

    private val _tempUpdates = MutableStateFlow<List<InventoryUpdate>>(emptyList())
    val tempUpdates: StateFlow<List<InventoryUpdate>> = _tempUpdates.asStateFlow()

    private val _allUpdates = MutableStateFlow<List<InventoryUpdate>>(emptyList())
    val allUpdates: StateFlow<List<InventoryUpdate>> = _allUpdates.asStateFlow()

    // ✅ New: State for selected item
    private val _selectedItem = MutableStateFlow<InventoryItem?>(null)
    val selectedItem: StateFlow<InventoryItem?> = _selectedItem.asStateFlow()

    init {
        loadItems()
        loadAllUpdates()
    }

    private fun loadItems() {
        viewModelScope.launch {
            repository.getAllItems().collect {
                _inventoryItems.value = it
            }
        }
    }

    private fun loadAllUpdates() {
        viewModelScope.launch {
            repository.getAllUpdates().collect {
                _allUpdates.value = it
            }
        }
    }

    fun insertItem(item: InventoryItem) = viewModelScope.launch {
        repository.insertItem(item)
    }

    fun updateItem(item: InventoryItem) = viewModelScope.launch {
        repository.updateItem(item)
    }

    fun addTempUpdate(
        itemId: Int,
        itemName: String,
        category: String = "",
        change: Int,
        date: String
    ) {
        val update = InventoryUpdate(
            itemId = itemId,
            itemName = itemName,
            category = category,
            change = change,
            date = date
        )
        _tempUpdates.value += update
    }

    fun commitUpdates() {
        viewModelScope.launch {
            _tempUpdates.value.forEach { update ->
                repository.applyUpdate(update)
            }
            _tempUpdates.value = emptyList()
        }
    }

    fun clearTempUpdates() {
        _tempUpdates.value = emptyList()
    }

    // ✅ Set the selected item for editing
    fun setSelectedItem(item: InventoryItem) {
        _selectedItem.value = item
    }

    // ✅ Clear the selected item after save
    fun clearSelectedItem() {
        _selectedItem.value = null
    }

    class Factory(private val repository: InventoryRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
                @Suppress("UNCHECKED_CAST")
                return InventoryViewModel(repository) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    fun deleteItem(item: InventoryItem) = viewModelScope.launch {
        repository.deleteItem(item)
        refresh()
    }

    fun refresh() {
        loadItems()
        loadAllUpdates()
    }
}