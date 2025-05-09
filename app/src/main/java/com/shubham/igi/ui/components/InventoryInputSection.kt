package com.shubham.igi.ui.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubham.igi.data.model.InventoryItem

@Composable
fun InventoryInputSection(
    categories: List<String>,
    selectedCategory: String,
    onCategoryChange: (String) -> Unit,
    items: List<InventoryItem>,
    selectedItem: InventoryItem?,
    onItemChange: (InventoryItem?) -> Unit,
    change: String,
    onChangeChange: (String) -> Unit,
    selectedDate: String,
    onDateChange: (String) -> Unit
) {
    DropdownMenuBox("Category", categories, selectedCategory, onCategoryChange)
    Spacer(Modifier.height(8.dp))
    DropdownMenuBox("Item", items.map { it.name }, selectedItem?.name ?: "") {
        onItemChange(items.find { item -> item.name == it })
    }
    Spacer(Modifier.height(12.dp))

    selectedItem?.let {
        Text("Current Amount: ${it.amount}", fontSize = 12.sp)
        TextField(
            value = change,
            onValueChange = onChangeChange,
            label = { Text("Change") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(16.dp))
        DatePickerTextField("Date", selectedDate, onDateChange)
    }
}