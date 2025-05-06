package com.shubham.igi.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.ui.components.InventoryDialog
import com.shubham.igi.ui.navigation.NavigationButtons

@Composable
fun InventoryListScreen(
    items: List<InventoryItem>,
    onItemClick: (InventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    var selectedItem by remember { mutableStateOf<InventoryItem?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        val groupedByCategory = items.groupBy { it.category }

        LazyColumn(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) {
            groupedByCategory.forEach { (category, itemList) ->
                item {
                    Text(
                        text = category,
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                }
                items(itemList) { item ->
                    val isBelowMin = item.amount < item.minQ
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedItem = item }
                            .padding(start = 16.dp, bottom = 4.dp)
                    ) {
                        Text(
                            text = "${item.name} (${item.amount})",
                            color = if (isBelowMin) Color.Red else Color.Unspecified
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        NavigationButtons(navTo = navTo)

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