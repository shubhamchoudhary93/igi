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
import com.shubham.igi.data.model.FilmInventoryItem
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.ui.navigation.NavigationButtonsFilm
import com.shubham.igi.ui.navigation.NavigationButtonsInventory
import com.shubham.igi.viewmodel.FilmInventoryViewModel
import com.shubham.igi.viewmodel.InventoryViewModel

@Composable
fun AddEditFilmScreen(
    viewModel: FilmInventoryViewModel,
    onSave: (FilmInventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    val selectedItem by viewModel.selectedItem.collectAsState()

    var name by remember { mutableStateOf("") }
    var size by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var addDate by remember { mutableStateOf("") }
    var removeDate by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    // Populate fields when selectedItem is available
    LaunchedEffect(selectedItem) {
        selectedItem?.let {
            name = it.name
            size = it.size.toString()
            weight = it.weight.toString()
            addDate = it.addDate
            removeDate = it.removeDate
        }
    }

    // Validate inputs before saving
    fun validateInputs(): Boolean {
        return name.isNotBlank() && size.isNotBlank() && weight.isNotBlank() && addDate.isNotBlank()
    }

    // Function to clear the fields
    fun clearFields() {
        name = ""
        size = ""
        weight = ""
        addDate = ""
        removeDate = ""
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
            value = size,
            onValueChange = { size = it },
            label = { Text("Size") },
            modifier = Modifier.fillMaxWidth() // Make it take full width
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight") },
            modifier = Modifier.fillMaxWidth() // Make it take full width
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = addDate,
            onValueChange = { addDate = it },
            label = { Text("Add Date") },
            modifier = Modifier.fillMaxWidth() // Make it take full width
        )
        Spacer(modifier = Modifier.height(8.dp))
        TextField(
            value = removeDate,
            onValueChange = { removeDate = it },
            label = { Text("Remove Date") },
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
                        val itemToSave = FilmInventoryItem(
                            id = selectedItem?.id ?: 0, // 0 for new item
                            name = name,
                            size = size.toIntOrNull() ?: 0,
                            weight = weight.toFloatOrNull() ?: 0F,
                            addDate = addDate,
                            removeDate = removeDate
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
        NavigationButtonsFilm(navTo = navTo)
    }
}