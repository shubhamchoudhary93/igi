package com.shubham.igi.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
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
import androidx.compose.ui.unit.sp
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.navigation.NavigationButtons

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
    var selectedItem by remember { mutableStateOf(filteredItems.firstOrNull()) }
    var change by remember { mutableStateOf(selectedItem?.defaultChange) }

    LaunchedEffect(selectedCategory) {
        selectedItem = filteredItems.firstOrNull()
    }

    val changeInt = change
    val isValidChange = changeInt != null

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        DropdownMenuBox("Category", categories, selectedCategory) { selectedCategory = it }
        Spacer(Modifier.height(8.dp))
        DropdownMenuBox("Item", filteredItems.map { it.name }, selectedItem?.name ?: "") {
            selectedItem = filteredItems.find { item -> item.name == it }
        }
        Spacer(Modifier.height(8.dp))
        selectedItem?.let {
            Text("Current Amount: ${it.amount}", fontSize = 10.sp)
            TextField(
                value = it.defaultChange.toString(),
                onValueChange = { change = it.toInt() },
                label = { Text("Change") },
                modifier = Modifier.fillMaxWidth()
            )
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
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {

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