package com.shubham.igi.inventory.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.inventory.data.model.InventoryItem
import com.shubham.igi.inventory.data.model.InventoryUpdate
import com.shubham.igi.util.formatDateToReadable
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(
    modifier: Modifier = Modifier,
    items: List<InventoryItem>,
    tempUpdates: List<InventoryUpdate>,
    onAddUpdate: (Int, String, String, Int, String) -> Unit,
    onCommit: () -> Unit,
    onDiscard: () -> Unit
) {
    val categories = items.map { it.category }.distinct()
    var selectedCategory by remember { mutableStateOf(categories.firstOrNull() ?: "") }

    val filteredItems = items.filter { it.category == selectedCategory }
    var selectedItem by remember { mutableStateOf(filteredItems.firstOrNull()) }

    var change by remember { mutableStateOf(selectedItem?.defaultChange?.toString() ?: "") }

    val dateFormatter = remember { SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()) }
    val defaultDate = remember { dateFormatter.format(Calendar.getInstance().time) }
    var selectedDate by remember { mutableStateOf(defaultDate) }

    var showCommitSheet by remember { mutableStateOf(false) }
    var showDiscardSheet by remember { mutableStateOf(false) }

    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    LaunchedEffect(selectedCategory) {
        selectedItem = filteredItems.firstOrNull()
        change = selectedItem?.defaultChange?.toString() ?: ""
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            item {
                InventoryInputSection(
                    categories = categories,
                    selectedCategory = selectedCategory,
                    onCategoryChange = { selectedCategory = it },
                    items = filteredItems,
                    selectedItem = selectedItem,
                    onItemChange = {
                        selectedItem = it
                        change = it?.defaultChange?.toString() ?: ""
                    },
                    change = change,
                    onChangeChange = { change = it },
                    selectedDate = selectedDate,
                    onDateChange = { selectedDate = it }
                )

                Spacer(Modifier.height(16.dp))

                selectedItem?.let {
                    InventoryActionButtons(
                        item = it,
                        change = change,
                        date = selectedDate,
                        onAdd = onAddUpdate,
                        onCommitClick = { showCommitSheet = true },
                        onDiscardClick = { showDiscardSheet = true }
                    )
                }

                Spacer(Modifier.height(16.dp))
            }

            if (tempUpdates.isNotEmpty()) {
                val grouped =
                    tempUpdates.groupBy { it.date }.toSortedMap(compareByDescending { it })

                grouped.forEach { (date, updates) ->
                    item {
                        Text(
                            text = formatDateToReadable(date),
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                    }
                    items(updates) {
                        val color =
                            if (it.change >= 0) androidx.compose.ui.graphics.Color(0xFF4CAF50)
                            else androidx.compose.ui.graphics.Color(0xFFF44336)

                        Text("${it.category} ${it.itemName}: ${it.change}", color = color)
                    }
                }
            }
        }

        if (showCommitSheet) {
            ConfirmationBottomSheet(
                title = "Are you sure you want to commit all changes?",
                onDismiss = { showCommitSheet = false },
                onConfirm = {
                    showCommitSheet = false
                    onCommit()
                },
                bottomSheetState = bottomSheetState
            )
        }

        if (showDiscardSheet) {
            ConfirmationBottomSheet(
                title = "Discard all changes? This cannot be undone.",
                onDismiss = { showDiscardSheet = false },
                onConfirm = {
                    showDiscardSheet = false
                    onDiscard()
                },
                bottomSheetState = bottomSheetState
            )
        }
    }
}