package com.shubham.igi.client.ui.clientlist


import androidx.compose.foundation.layout.Row
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
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientListScreen(
    viewModel: ClientListViewModel,
    onClientClick: (Long) -> Unit,
    onAddClientClick: () -> Unit
) {
    val clientsWithDue = viewModel.filteredClients
    val showOnlyDue = viewModel.showOnlyDue

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Clients") },
                actions = {
                    Row {
                        Text("Dues only", style = MaterialTheme.typography.labelLarge)
                        Switch(
                            checked = showOnlyDue,
                            onCheckedChange = { viewModel.showOnlyDue = it }
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClientClick) {
                Icon(Icons.Default.Add, contentDescription = "Add Client")
            }
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(clientsWithDue) { item ->
                ClientItem(
                    client = item.client,
                    dueAmount = item.dueAmount,
                    onClick = { onClientClick(item.client.clientId) }
                )
            }
        }
    }
}