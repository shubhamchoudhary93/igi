package com.shubham.igi.client.ui.clientlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubham.igi.client.data.model.Client

@Composable
fun ClientItem(
    client: Client,
    dueAmount: Double,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(client.name, style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(4.dp))
            if (dueAmount > 0.0) {
                Text("Due: ₹%.2f".format(dueAmount), color = Color.Red)
            } else {
                Text("All Paid", color = Color.Green)
            }
        }
    }
}