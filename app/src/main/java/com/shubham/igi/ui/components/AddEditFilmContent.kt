package com.shubham.igi.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.FilmInventoryItem
import com.shubham.igi.viewmodel.FilmInventoryViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditFilmContent(
    modifier: Modifier = Modifier,
    viewModel: FilmInventoryViewModel,
    onSave: (FilmInventoryItem) -> Unit
) {
    val selectedItem by viewModel.selectedItem.collectAsState()

    var name by rememberSaveable { mutableStateOf("") }
    var size by rememberSaveable { mutableStateOf("") }
    var weight by rememberSaveable { mutableStateOf("") }
    var addDate by rememberSaveable { mutableStateOf("") }
    var removeDate by rememberSaveable { mutableStateOf("") }
    var errorMessage by rememberSaveable { mutableStateOf("") }

    // Populate fields when editing
    LaunchedEffect(selectedItem) {
        selectedItem?.let {
            name = it.name
            size = it.size.toString()
            weight = it.weight.toString()
            addDate = it.addDate
            removeDate = it.removeDate
        }
    }

    fun validateInputs() =
        name.isNotBlank() && size.isNotBlank() && weight.isNotBlank() && addDate.isNotBlank()

    fun clearFields() {
        name = ""
        size = ""
        weight = ""
        addDate = ""
        removeDate = ""
        errorMessage = ""
    }

    val nameOptions = listOf("Garware", "Jindle", "Local")
    var expanded by remember { mutableStateOf(false) }

    Column(modifier = modifier.padding(16.dp)) {
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedTextField(
                value = name,
                onValueChange = {},
                readOnly = true,
                label = { Text("Name") },
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
                modifier = Modifier
                    .fillMaxWidth()
                    .menuAnchor()
            )
            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                nameOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            name = option
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = size,
            onValueChange = { size = it },
            label = { Text("Size") },
            modifier = Modifier.fillMaxWidth(),
            isError = size.toIntOrNull() == null
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = weight,
            onValueChange = { weight = it },
            label = { Text("Weight") },
            modifier = Modifier.fillMaxWidth(),
            isError = weight.toFloatOrNull() == null
        )

        Spacer(modifier = Modifier.height(8.dp))

        DatePickerTextField("Add Date", addDate) { addDate = it }
        Spacer(modifier = Modifier.height(8.dp))
        DatePickerTextField("Remove Date", removeDate) { removeDate = it }

        Spacer(modifier = Modifier.weight(1f))

        if (errorMessage.isNotBlank()) {
            Text(errorMessage, color = MaterialTheme.colorScheme.error)
            Spacer(modifier = Modifier.height(8.dp))
        }

        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(
                onClick = {
                    val sizeValue = size.toIntOrNull()
                    val weightValue = weight.toFloatOrNull()

                    if (validateInputs() && sizeValue != null && weightValue != null) {
                        if (removeDate.isNotBlank() && removeDate < addDate) {
                            errorMessage = "Remove date cannot be before add date."
                            return@Button
                        }

                        onSave(
                            FilmInventoryItem(
                                id = selectedItem?.id ?: 0,
                                name = name,
                                size = sizeValue,
                                weight = weightValue,
                                addDate = addDate,
                                removeDate = removeDate
                            )
                        )
                        viewModel.clearSelectedItem()
                        errorMessage = ""
                    } else {
                        errorMessage = "Please enter valid values for all required fields."
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

        Spacer(modifier = Modifier.height(16.dp))
    }
}