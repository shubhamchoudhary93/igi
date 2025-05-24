package com.shubham.igi.inventory.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
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
import androidx.compose.ui.unit.dp
import com.shubham.igi.inventory.data.model.FilmInventoryItem

@Composable
fun FilmStockContent(
    modifier: Modifier = Modifier,
    items: List<FilmInventoryItem>,
    onItemClick: (FilmInventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    var selectedItem by remember { mutableStateOf<FilmInventoryItem?>(null) }

    // Filter and group by name
    val groupedByName = items
        .filter { it.removeDate.isBlank() }
        .groupBy { it.name }

    // Track expanded state per name and per name+size combo
    val expandedNames = remember { mutableStateMapOf<String, Boolean>() }
    val expandedSizes = remember { mutableStateMapOf<Pair<String, String>, Boolean>() }

    Column(modifier = modifier.padding(16.dp)) {
        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            groupedByName.forEach { (name, itemList) ->
                val isNameExpanded = expandedNames.getOrElse(name) { false }

                // Header for name
                item(key = "name_$name") {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { expandedNames[name] = !isNameExpanded }
                            .padding(vertical = 8.dp)
                            .animateContentSize(tween(300))
                    ) {
                        Text(
                            text = name,
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Icon(
                            imageVector = if (isNameExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                            contentDescription = if (isNameExpanded) "Collapse" else "Expand",
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

                if (isNameExpanded) {
                    // Sub-group by size
                    val groupedBySize = itemList.groupBy { it.size }

                    groupedBySize.forEach { (size, sizeList) ->
                        val key = name to size.toString()
                        val isSizeExpanded = expandedSizes.getOrElse(key) { false }

                        // Size Header
                        item(key = "size_${name}_$size") {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .clickable { expandedSizes[key] = !isSizeExpanded }
                                    .padding(start = 16.dp, top = 4.dp, bottom = 4.dp)
                                    .animateContentSize(tween(300))
                            ) {
                                Text(
                                    text = "Size: $size (${sizeList.size})",
                                    style = MaterialTheme.typography.bodyMedium,
                                    modifier = Modifier.weight(1f)
                                )
                                Icon(
                                    imageVector = if (isSizeExpanded) Icons.Filled.KeyboardArrowUp else Icons.Filled.KeyboardArrowDown,
                                    contentDescription = if (isSizeExpanded) "Collapse" else "Expand",
                                    tint = MaterialTheme.colorScheme.primary
                                )
                            }
                        }

                        if (isSizeExpanded) {
                            // Sort by weight and show items
                            val sortedList = sizeList.sortedByDescending { it.weight }
                            // Group items into rows of 2
                            items(sortedList.chunked(2)) { rowItems ->
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 32.dp, bottom = 4.dp)
                                ) {
                                    rowItems.forEach { item ->
                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .clickable { selectedItem = item }
                                                .padding(end = 8.dp)
                                                .animateContentSize(tween(300))
                                        ) {
                                            Text(text = "${item.weight}")
                                        }
                                    }

                                    // If the row has only 1 item, add an empty spacer to balance layout
                                    if (rowItems.size == 1) {
                                        Spacer(modifier = Modifier.weight(1f))
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        selectedItem?.let { item ->
            FilmInventoryDialog(
                item = item,
                onClose = { selectedItem = null },
                onEdit = {
                    onItemClick(item)
                    navTo("add_edit_film")
                    selectedItem = null
                }
            )
        }
    }
}