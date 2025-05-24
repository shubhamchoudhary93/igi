package com.shubham.igi.client.ui.clientdetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientDetailScreen(
    viewModel: ClientDetailViewModel,
    onAddReceipt: () -> Unit,
    onReceiptClick: (Long) -> Unit
) {
    val client = viewModel.client
    val receipts = viewModel.receipts
    val dueAmount = viewModel.dueAmount
    val navController = rememberNavController() // or get passed navController
    val refreshTrigger = navController.currentBackStackEntry
        ?.savedStateHandle
        ?.getLiveData<Boolean>("refresh")
        ?.observeAsState()

    LaunchedEffect(refreshTrigger?.value) {
        if (refreshTrigger?.value == true) {
            viewModel.refresh()
            navController.currentBackStackEntry
                ?.savedStateHandle?.set("refresh", false)
        }
    }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(client?.name ?: "Client") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddReceipt) {
                Icon(Icons.Default.Add, contentDescription = "Add Receipt")
            }
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding)) {
            Text(
                text = "Total Due: ₹%.2f".format(dueAmount),
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.titleLarge,
                color = if (dueAmount > 0) Color.Red else Color.Green
            )

            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(receipts) { receipt ->
                    ReceiptItem(receipt = receipt) {
                        onReceiptClick(receipt.receiptId)
                    }
                }
            }
        }
    }
}