package com.shubham.igi.inventory.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubham.igi.inventory.data.model.InventoryItem

@Composable
fun InventoryActionButtons(
    item: InventoryItem,
    change: String,
    date: String,
    onAdd: (Int, String, String, Int, String) -> Unit,
    onCommitClick: () -> Unit,
    onDiscardClick: () -> Unit
) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = {
                change.toIntOrNull()?.let {
                    onAdd(item.id, item.name, item.category, it, date)
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
                change.toIntOrNull()?.let {
                    onAdd(item.id, item.name, item.category, -it, date)
                }
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFF44336)),
            modifier = Modifier.weight(1f)
        ) {
            Text("Minus")
        }
    }
    Spacer(Modifier.height(8.dp))
    Row(modifier = Modifier.fillMaxWidth()) {
        Button(
            onClick = onCommitClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF388E3C)),
            modifier = Modifier.weight(1f)
        ) {
            Text("Commit")
        }
        Spacer(Modifier.width(8.dp))
        Button(
            onClick = onDiscardClick,
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFD32F2F)),
            modifier = Modifier.weight(1f)
        ) {
            Text("Discard")
        }
    }
}