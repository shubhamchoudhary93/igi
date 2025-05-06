package com.shubham.igi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shubham.igi.data.dao.InventoryDao
import com.shubham.igi.data.dao.UpdateDao
import com.shubham.igi.data.model.InventoryUpdate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class UpdateViewModel(
    private val updateDao: UpdateDao,
    private val inventoryDao: InventoryDao
) : ViewModel() {
    val tempUpdates = MutableStateFlow<List<InventoryUpdate>>(emptyList())

    fun addTempUpdate(itemId: Int, itemName: String, category: String, change: Int) {
        val update = InventoryUpdate(
            itemId = itemId,
            itemName = itemName,
            category = category,
            change = change,
            date = LocalDate.now().toString()
        )
        tempUpdates.value += update
    }

    fun commitUpdates() {
        viewModelScope.launch {
            tempUpdates.value.forEach {
                updateDao.insertUpdate(it)
                val item = inventoryDao.getItem(it.itemId)
                inventoryDao.updateItem(item.copy(amount = item.amount + it.change))
            }
            tempUpdates.value = emptyList()
        }
    }
}