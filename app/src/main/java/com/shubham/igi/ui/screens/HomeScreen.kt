package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.toSize
import com.shubham.igi.ui.navigation.NavigationButtons
import android.util.Log

@Composable
fun HomeScreen(
    items: List<InventoryItem>,
    tempUpdates: List<InventoryUpdate>,
    onAddUpdate: (Int,String,  Int) -> Unit,
    onCommit: () -> Unit,
    navTo: (String) -> Unit
) {
    val categories = items.map { it.category }.distinct()
    Log.d("HomeScreen", "Categories: $categories")

    var selectedCategory by remember { mutableStateOf(categories.firstOrNull() ?: "") }

    val filteredItems = items.filter { it.category == selectedCategory }
    Log.d("HomeScreen", "Filtered Items for '$selectedCategory': ${filteredItems.map { it.name }}")
    var selectedItem by remember { mutableStateOf(filteredItems.firstOrNull()) }
    var change by remember { mutableStateOf("") }

    LaunchedEffect(selectedCategory) {
        selectedItem = filteredItems.firstOrNull()
    }

    val changeInt = change.toIntOrNull()
    val isValidChange = changeInt != null

    Column(modifier = Modifier.padding(16.dp)) {
        DropdownMenuBox("Category", categories, selectedCategory) { selectedCategory = it }
        Spacer(Modifier.height(8.dp))
        DropdownMenuBox("Item", filteredItems.map { it.name }, selectedItem?.name ?: "") {
            selectedItem = filteredItems.find { item -> item.name == it }
        }
        Spacer(Modifier.height(8.dp))
        selectedItem?.let {
            Text("Current Amount: ${it.amount}")
            TextField(value = change, onValueChange = { change = it }, label = { Text("Change") })
            Row {
                Button(
                    onClick = {
                        selectedItem?.let {
                            changeInt?.let { validChange ->
                                onAddUpdate(it.id, it.name, validChange)
                            }
                        }
                    },
                    enabled = isValidChange
                ) {
                    Text("Add")
                }

                Spacer(Modifier.width(8.dp))

                Button(
                    onClick = {
                        selectedItem?.let {
                            changeInt?.let { validChange ->
                                onAddUpdate(it.id,it.name, -validChange)
                            }
                        }
                    },
                    enabled = isValidChange
                ) {
                    Text("Minus")
                }
            }
        }
        Spacer(Modifier.height(16.dp))
        Button(onClick = onCommit) {
            Text("Commit")
        }

        Spacer(Modifier.height(16.dp))
        Text("Today's Updates:")
        LazyColumn {
            items(tempUpdates) {
                Text("${it.itemName}: ${it.change}")
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        NavigationButtons(navTo = navTo)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DropdownMenuBox(
    label: String,
    options: List<String>,
    selected: String,
    onSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    ExposedDropdownMenuBox(
        expanded = expanded,
        onExpandedChange = { expanded = !expanded },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            value = selected,
            onValueChange = {},
            label = { Text(label) },
            readOnly = true,
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
            },
            modifier = Modifier
                .menuAnchor() // anchor the dropdown correctly
                .fillMaxWidth()
        )

        ExposedDropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            options.forEach { selectionOption ->
                DropdownMenuItem(
                    text = { Text(selectionOption) },
                    onClick = {
                        onSelected(selectionOption)
                        expanded = false
                    }
                )
            }
        }
    }
}