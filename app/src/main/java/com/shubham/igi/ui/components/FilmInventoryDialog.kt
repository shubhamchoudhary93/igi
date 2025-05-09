package com.shubham.igi.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.shubham.igi.data.model.FilmInventoryItem

@Composable
fun FilmInventoryDialog(
    item: FilmInventoryItem,
    onClose: () -> Unit,
    onEdit: () -> Unit
) {
    Dialog(onDismissRequest = onClose) {
        Surface(shape = MaterialTheme.shapes.medium) {
            Column(modifier = androidx.compose.ui.Modifier.padding(16.dp)) {
                Text(text = item.name, style = MaterialTheme.typography.titleLarge)
                Text("Size: ${item.size}")
                Text("Weight: ${item.weight}")
                Text("Add Date: ${item.addDate}")
                Text("Remove Date: ${item.removeDate}")
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