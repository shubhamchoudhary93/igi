package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.components.HomeScreenContent
import com.shubham.igi.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsInventory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    items: List<InventoryItem>,
    tempUpdates: List<InventoryUpdate>,
    onAddUpdate: (Int, String, String, Int, String) -> Unit,
    onCommit: () -> Unit,
    onDiscard: () -> Unit,
    navTo: (String) -> Unit,
    snackbarHostState: SnackbarHostState,
    onBackup: () -> Unit,
    onRestore: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = "Inventory",
                onHome = { navTo("start") },
                onBackup = onBackup,
                onRestore = onRestore
            )
        },
        bottomBar = {
            NavigationButtonsInventory(navTo = navTo)
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                Snackbar(snackbarData = data)
            }
        }
    ) { innerPadding ->
        HomeScreenContent(
            modifier = Modifier.padding(innerPadding),
            items = items,
            tempUpdates = tempUpdates,
            onAddUpdate = onAddUpdate,
            onCommit = onCommit,
            onDiscard = onDiscard
        )
    }
}