package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.ui.navigation.NavigationButtons

@Composable
fun AddEditScreen(
    item: InventoryItem? = null,
    onSave: (InventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    var name by remember { mutableStateOf(item?.name ?: "") }
    var category by remember { mutableStateOf(item?.category ?: "") }
    var amount by remember { mutableStateOf(item?.amount?.toString() ?: "") }
    var description by remember { mutableStateOf(item?.description ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = category, onValueChange = { category = it }, label = { Text("Category") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = amount, onValueChange = { amount = it }, label = { Text("Amount") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = description, onValueChange = { description = it }, label = { Text("Description") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onSave(InventoryItem(id = item?.id ?: 0, name = name, category = category, amount = amount.toIntOrNull() ?: 0, description = description))
        }) {
            Text("Save")
        }
        Spacer(modifier = Modifier.height(24.dp))
        NavigationButtons(navTo = navTo)
    }
}

