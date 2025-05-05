package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var defaultChange by remember { mutableStateOf(item?.defaultChange?.toString() ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Name") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = category, onValueChange = { category = it }, label = { Text("Category") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = amount, onValueChange = { amount = it }, label = { Text("Amount") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = defaultChange,
            onValueChange = { defaultChange = it },
            label = { Text("Default Change") })
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            onSave(
                InventoryItem(
                    id = item?.id ?: 0,
                    name = name,
                    category = category,
                    amount = amount.toIntOrNull() ?: 0,
                    defaultChange = defaultChange.toIntOrNull() ?: 1
                )
            )
        }) {
            Text("Save")
        }
        Spacer(modifier = Modifier.height(24.dp))
        NavigationButtons(navTo = navTo)
    }
}

