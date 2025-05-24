package com.shubham.igi.inventory.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubham.igi.inventory.data.model.InventoryItem

// ✅ 1. Define filter options
enum class StockFilter(val label: String) {
    ALL("All"),
    NON_ZERO("In Stock"),
    LOW("Low")
}

@Composable
fun InventoryListContent(
    modifier: Modifier = Modifier,
    items: List<InventoryItem>,
    onItemClick: (InventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    var selectedItem by remember { mutableStateOf<InventoryItem?>(null) }

    // ✅ 2. State for selected filter
    var selectedFilter by remember { mutableStateOf(StockFilter.ALL) }

    // ✅ 3. Apply filter
    val filteredItems = when (selectedFilter) {
        StockFilter.ALL -> items
        StockFilter.NON_ZERO -> items.filter { it.amount > 0 }
        StockFilter.LOW -> items.filter { it.amount < it.minQ }
    }

    val expandedCategories = remember { mutableStateMapOf<String, Boolean>() }

    val groupedByCategory = filteredItems.groupBy { it.category }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // ✅ 4. Toggle Buttons
        FlowRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            StockFilter.entries.forEach { filter ->
                val isSelected = filter == selectedFilter
                FilterChip(
                    selected = isSelected,
                    onClick = { selectedFilter = filter },
                    label = { Text(filter.label) }
                )
            }
        }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            groupedByCategory.forEach { (category, itemList) ->
                val isExpanded = expandedCategories.getOrElse(category) { false }

                item(key = "category_$category") {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expandedCategories[category] = !isExpanded }
                            .padding(vertical = 8.dp)
                            .animateContentSize(tween(300))
                    ) {
                        Text(
                            text = category,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = if (isExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                            contentDescription = if (isExpanded) "Collapse" else "Expand",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                if (isExpanded) {
                    val rows = itemList.chunked(2)
                    items(rows) { rowItems ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(start = 16.dp, bottom = 4.dp)
                        ) {
                            rowItems.forEach { item ->
                                val isBelowMin = item.amount < item.minQ
                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .clickable { selectedItem = item }
                                        .padding(end = 8.dp)
                                ) {
                                    Text(
                                        text = "${item.name} (${item.amount})",
                                        color = if (isBelowMin) Color.Red else Color.Unspecified
                                    )
                                }
                            }
                            if (rowItems.size == 1) {
                                Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    }
                }
            }
        }

        selectedItem?.let { item ->
            InventoryDialog(
                item = item,
                onClose = { selectedItem = null },
                onEdit = {
                    onItemClick(item)
                    navTo("add_edit")
                    selectedItem = null
                }
            )
        }
    }
}