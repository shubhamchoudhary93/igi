package com.shubham.igi.ui.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.FilmInventoryItem
import com.shubham.igi.util.formatDateToReadable

@Composable
fun FilmHistoryList(updates: List<FilmInventoryItem>, modifier: Modifier = Modifier) {
    // Group by removeDate and sort
    val grouped = updates
        .filter { it.removeDate.isNotEmpty() }
        .groupBy { it.removeDate }
        .toSortedMap(compareByDescending { it })

    // State to track expanded/collapsed state for each date
    val expandedDates = remember { mutableStateMapOf<String, Boolean>() }

    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
    ) {
        grouped.forEach { (date, list) ->
            // Set initial state for each date (collapsed by default)
            val isExpanded = expandedDates.getOrElse(date) { false }

            item {
                // Date header with Expand/Collapse icon
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            // Toggle the expanded state for this date
                            expandedDates[date] = !isExpanded
                        }
                        .padding(vertical = 8.dp, horizontal = 16.dp)
                ) {
                    Text(
                        text = formatDateToReadable(date),
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

            // Show or hide the list of updates under this date with animation
            if (isExpanded) {
                items(list, key = { it.id }) { update ->
                    Text(
                        text = "${update.name} ${update.size} : ${update.weight}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier
                            .padding(start = 16.dp, bottom = 4.dp)
                            .animateContentSize(animationSpec = tween(durationMillis = 300))  // Smooth animation
                    )
                }
            }
        }
    }
}