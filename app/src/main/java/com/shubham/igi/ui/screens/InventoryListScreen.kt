package com.shubham.igi.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
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

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable { selectedItem = item }
                            .padding(start = 16.dp, bottom = 4.dp)
                    ) {
                        Text("${item.name} (${item.amount})")
                    }
                }
            }
        }
        Spacer(modifier = Modifier.height(24.dp))
        NavigationButtons(navTo = navTo)

        selectedItem?.let {
            InventoryDialog(
                item = it,
                onClose = { selectedItem = null },
                onEdit = { onItemClick(it) })
        }
    }
}