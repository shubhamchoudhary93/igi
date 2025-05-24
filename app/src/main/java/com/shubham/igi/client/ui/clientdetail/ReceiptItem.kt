package com.shubham.igi.client.ui.clientdetail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.shubham.igi.client.data.model.Receipt

@Composable
fun ReceiptItem(
    receipt: Receipt,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Date: ${receipt.date}")
            Text("Amount: ₹%.2f".format(receipt.amount))
            Text("Paid: ₹%.2f".format(receipt.paidAmount))
            val remaining = receipt.amount - receipt.paidAmount
            Text(
                text = if (remaining <= 0) "Status: Paid" else "Status: Due ₹%.2f".format(remaining),
                color = if (remaining <= 0) Color.Green else Color.Red
            )
        }
    }
}