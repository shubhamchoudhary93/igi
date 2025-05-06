package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.navigation.NavigationButtons

@Composable
fun HistoryScreen(
    updates: List<InventoryUpdate>,
    navTo: (String) -> Unit
) {
    val grouped = updates.groupBy { it.date }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
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
                    val changeColor =
                        if (update.change >= 0) Color(0xFF4CAF50) else Color(0xFFF44336)

                    Text(
                        text = "${update.category} ${update.itemName} : ${update.change}",
                        style = MaterialTheme.typography.bodyMedium,
                        color = changeColor,
                        modifier = Modifier.padding(start = 16.dp, bottom = 4.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        NavigationButtons(navTo = navTo)
    }
}

