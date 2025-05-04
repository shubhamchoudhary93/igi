package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.navigation.NavigationButtons

@Composable
fun HistoryScreen(
    updates: List<InventoryUpdate>,
    navTo: (String) -> Unit
) {
    val grouped = updates.groupBy { it.date }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        LazyColumn(
            modifier = Modifier
                .weight(1f) // This makes the list take all available vertical space except what's needed for the buttons
                .fillMaxWidth()
        ) {
            grouped.forEach { (date, list) ->
                item {
                    Text(
                        text = date,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                items(list) { update ->
                    Text(
                        text = "Item: ${update.itemName}, Change: ${update.change}",
                        style = MaterialTheme.typography.bodyMedium,
                        modifier = Modifier.padding(start = 16.dp, bottom = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        NavigationButtons(navTo = navTo)
    }
}

