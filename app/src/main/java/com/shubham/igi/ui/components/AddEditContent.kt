package com.shubham.igi.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.InventoryItem

@Composable
fun AddEditContent(
    modifier: Modifier = Modifier,
    selectedItem: InventoryItem?,
    onSave: (InventoryItem) -> Unit
) {
    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var defaultChange by remember { mutableStateOf("") }
    var minQ by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    LaunchedEffect(selectedItem) {
        selectedItem?.let {
            name = it.name
            category = it.category
            amount = it.amount.toString()
            defaultChange = it.defaultChange.toString()
            minQ = it.minQ.toString()
        }
    }

    fun validateInputs(): Boolean {
        return name.isNotBlank() && category.isNotBlank() && amount.isNotBlank() &&
                defaultChange.isNotBlank() && minQ.isNotBlank()
    }

    fun clearFields() {
        name = ""
        category = ""
        amount = ""
        defaultChange = ""
        minQ = ""
        errorMessage = ""
    }

    Column(modifier = modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = defaultChange,
            onValueChange = { defaultChange = it },
            label = { Text("Default Change") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(8.dp))
        TextField(
            value = minQ,
            onValueChange = { minQ = it },
            label = { Text("Min Quantity") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(
            Modifier
                .height(16.dp)
                .weight(1f)
        )

        if (errorMessage.isNotBlank()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            Spacer(Modifier.height(8.dp))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                onClick = {
                    if (validateInputs()) {
                        val item = InventoryItem(
                            id = selectedItem?.id ?: 0,
                            name = name,
                            category = category,
                            amount = amount.toIntOrNull() ?: 0,
                            defaultChange = defaultChange.toIntOrNull() ?: 1,
                            minQ = minQ.toIntOrNull() ?: 0
                        )
                        onSave(item)
                        errorMessage = ""
                    } else {
                        errorMessage = "Please fill all fields correctly."
                    }
                },
                enabled = validateInputs()
            ) {
                Text("Save")
            }

            Button(onClick = { clearFields() }) {
                Text("Clear")
            }
        }
    }
}