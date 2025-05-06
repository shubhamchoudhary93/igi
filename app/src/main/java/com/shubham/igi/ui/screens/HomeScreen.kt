package com.shubham.igi.ui.screens

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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.components.DropdownMenuBox
import com.shubham.igi.ui.navigation.NavigationButtons

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    items: List<InventoryItem>,
    tempUpdates: List<InventoryUpdate>,
    onAddUpdate: (Int, String, String, Int) -> Unit,
    onCommit: () -> Unit,
    onDiscard: () -> Unit,
    navTo: (String) -> Unit
) {
    val categories = items.map { it.category }.distinct()
    var selectedCategory by remember { mutableStateOf(categories.firstOrNull() ?: "") }

    val filteredItems = items.filter { it.category == selectedCategory }
    var selectedItem by remember { mutableStateOf(filteredItems.firstOrNull()) }
    var change by remember { mutableStateOf(selectedItem?.defaultChange?.toString() ?: "") }

    LaunchedEffect(selectedCategory) {
        selectedItem = filteredItems.firstOrNull()
        change = selectedItem?.defaultChange?.toString() ?: ""
    }

    rememberCoroutineScope()
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var showCommitSheet by remember { mutableStateOf(false) }
    var showDiscardSheet by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // Scrollable content
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            DropdownMenuBox("Category", categories, selectedCategory) {
                selectedCategory = it
            }

            Spacer(Modifier.height(8.dp))

            DropdownMenuBox("Item", filteredItems.map { it.name }, selectedItem?.name ?: "") {
                selectedItem = filteredItems.find { item -> item.name == it }
                change = selectedItem?.defaultChange?.toString() ?: ""
            }

            Spacer(Modifier.height(12.dp))

            selectedItem?.let { it ->
                Text("Current Amount: ${it.amount}", fontSize = 12.sp)

                TextField(
                    value = change,
                    onValueChange = { change = it },
                    label = { Text("Change") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(Modifier.height(16.dp))

                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = {
                            change.toIntOrNull()?.let { validChange ->
                                onAddUpdate(it.id, it.name, it.category, validChange)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Add")
                    }

                    Spacer(Modifier.width(8.dp))

                    Button(
                        onClick = {
                            change.toIntOrNull()?.let { validChange ->
                                onAddUpdate(it.id, it.name, it.category, -validChange)
                            }
                        },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Minus")
                    }
                }

                Row(modifier = Modifier.fillMaxWidth()) {
                    Button(
                        onClick = { showCommitSheet = true },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF388E3C)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Commit")
                    }

                    Spacer(modifier = Modifier.width(8.dp))

                    Button(
                        onClick = { showDiscardSheet = true },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
                        modifier = Modifier.weight(1f)
                    ) {
                        Text("Discard")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            if (tempUpdates.isNotEmpty()) {
                Text("Today's Updates:")
                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                ) {
                    items(tempUpdates) {
                        val changeColor =
                            if (it.change >= 0) Color(0xFF4CAF50) else Color(0xFFF44336) // Green or Red
                        Text(
                            text = "${it.category} ${it.itemName}: ${it.change}",
                            color = changeColor
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }


        }

        // Fixed bottom navigation
        Spacer(modifier = Modifier.height(16.dp))
        NavigationButtons(navTo = navTo)
    }

    // ✅ Bottom sheet for commit
    if (showCommitSheet) {
        ModalBottomSheet(
            onDismissRequest = { showCommitSheet = false },
            sheetState = bottomSheetState
        ) {
            Text(
                "Are you sure you want to commit all changes?",
                modifier = Modifier.padding(16.dp)
            )
            Row(Modifier.padding(16.dp)) {
                Button(
                    onClick = {
                        showCommitSheet = false
                        onCommit()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Yes")
                }

                Spacer(Modifier.width(8.dp))

                Button(
                    onClick = { showCommitSheet = false },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("No")
                }
            }
        }
    }

    // ✅ Bottom sheet for discard
    if (showDiscardSheet) {
        ModalBottomSheet(
            onDismissRequest = { showDiscardSheet = false },
            sheetState = bottomSheetState
        ) {
            Text(
                "Discard all changes? This cannot be undone.",
                modifier = Modifier.padding(16.dp)
            )
            Row(Modifier.padding(16.dp)) {
                Button(
                    onClick = {
                        showDiscardSheet = false
                        onDiscard()
                    },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Yes")
                }

                Spacer(Modifier.width(8.dp))

                Button(
                    onClick = { showDiscardSheet = false },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("No")
                }
            }
        }
    }
}