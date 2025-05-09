package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.components.HomeScreenContent
import com.shubham.igi.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsInventory

@Composable
fun HomeScreen(
    items: List<InventoryItem>,
    tempUpdates: List<InventoryUpdate>,
    onAddUpdate: (Int, String, String, Int, String) -> Unit,
    onCommit: () -> Unit,
    onDiscard: () -> Unit,
    navTo: (String) -> Unit,
    onSync: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = "Inventory",
                onHome = { navTo("start") },
                onSync = onSync
            )
        },
        bottomBar = {
            NavigationButtonsInventory(navTo = navTo)
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