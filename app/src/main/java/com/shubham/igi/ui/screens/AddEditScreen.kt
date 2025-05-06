package com.shubham.igi.ui.screens

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.ui.navigation.NavigationButtons
import com.shubham.igi.viewmodel.InventoryViewModel

@Composable
fun AddEditScreen(
    viewModel: InventoryViewModel,
    onSave: (InventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    val selectedItem by viewModel.selectedItem.collectAsState()

    var name by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var defaultChange by remember { mutableStateOf("") }
    var minQ by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    // Populate fields when selectedItem is available
    LaunchedEffect(selectedItem) {
        selectedItem?.let {
            name = it.name
            category = it.category
            amount = it.amount.toString()
            defaultChange = it.defaultChange.toString()
            minQ = it.minQ.toString()
        }
    }

    // Validate inputs before saving
    fun validateInputs(): Boolean {
        return name.isNotBlank() && category.isNotBlank() && amount.isNotBlank() && defaultChange.isNotBlank() && minQ.isNotBlank()
    }

    // Function to clear the fields
    fun clearFields() {
        name = ""
        category = ""
        amount = ""
        defaultChange = ""
        minQ = ""
        errorMessage = ""
    }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth() // Make it take full width
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = category,
            onValueChange = { category = it },
            label = { Text("Category") },
            modifier = Modifier.fillMaxWidth() // Make it take full width
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = amount,
            onValueChange = { amount = it },
            label = { Text("Amount") },
            modifier = Modifier.fillMaxWidth() // Make it take full width
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = defaultChange,
            onValueChange = { defaultChange = it },
            label = { Text("Default Change") },
            modifier = Modifier.fillMaxWidth() // Make it take full width
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = minQ,
            onValueChange = { minQ = it },
            label = { Text("Min Quantity") },
            modifier = Modifier.fillMaxWidth() // Make it take full width
        )
        Spacer(modifier = Modifier
            .height(16.dp)
            .weight(1f))

        // Error message if validation fails
        if (errorMessage.isNotBlank()) {
            Text(text = errorMessage, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                onClick = {
                    if (validateInputs()) {
                        val itemToSave = InventoryItem(
                            id = selectedItem?.id ?: 0, // 0 for new item
                            name = name,
                            category = category,
                            amount = amount.toIntOrNull() ?: 0,
                            defaultChange = defaultChange.toIntOrNull() ?: 1,
                            minQ = minQ.toIntOrNull() ?: 0
                        )
                        onSave(itemToSave)
                        viewModel.clearSelectedItem() // ✅ clear after saving
                        errorMessage = "" // Clear error message if save is successful
                    } else {
                        errorMessage = "Please fill all fields correctly."
                    }
                },
                enabled = validateInputs()
            ) {
                Text("Save")
            }

            // Clear Button
            Button(
                onClick = {
                    clearFields()
                }
            ) {
                Text("Clear")
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        NavigationButtons(navTo = navTo)
    }
}