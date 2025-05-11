package com.shubham.igi.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.components.HomeScreenContent
import com.shubham.igi.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsInventory
import com.shubham.igi.utils.backupDatabase
import com.shubham.igi.utils.restoreDatabase

@Composable
fun HomeScreen(
    items: List<InventoryItem>,
    tempUpdates: List<InventoryUpdate>,
    onAddUpdate: (Int, String, String, Int, String) -> Unit,
    onCommit: () -> Unit,
    onDiscard: () -> Unit,
    navTo: (String) -> Unit
) {
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = "Inventory",
                onHome = { navTo("start") },
                onBackup = {
                    backupDatabase(
                        context = context,
                        onSuccess = { Log.d("Sync", "Backup uploaded successfully") },
                        onFailure = { e -> Log.e("Sync", "Backup upload failed", e) }
                    )
                },
                onRestore = {
                    restoreDatabase(
                        context = context,
                        onSuccess = { Log.d("Restore", "Database restored successfully") },
                        onFailure = { e -> Log.e("Restore", "Restore failed", e) }
                    )
                }
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