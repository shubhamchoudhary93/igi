package com.shubham.igi.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Dialog
import com.shubham.igi.data.model.InventoryItem
import androidx.compose.foundation.layout.*
import androidx.compose.ui.unit.dp

@Composable
fun InventoryDialog(
    item: InventoryItem,
    onClose: () -> Unit,
    onEdit: () -> Unit
) {
    Dialog(onDismissRequest = onClose) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {
                Text(text = item.name, style = MaterialTheme.typography.titleLarge)
                Text("Category: ${item.category}")
                Text("Amount: ${item.amount}")
                Text("Description: ${item.description}")
                Spacer(modifier = androidx.compose.ui.Modifier.height(16.dp))
                Row {
                    Button(onClick = onEdit) {
                        Text("Edit")
                    }
                    Spacer(modifier = androidx.compose.ui.Modifier.width(8.dp))
                    OutlinedButton(onClick = onClose) {
                        Text("Close")
                    }
                }
            }
        }
    }
}