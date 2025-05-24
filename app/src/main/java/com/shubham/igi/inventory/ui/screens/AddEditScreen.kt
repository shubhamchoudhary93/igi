package com.shubham.igi.inventory.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.shubham.igi.inventory.data.model.InventoryItem
import com.shubham.igi.inventory.ui.components.AddEditContent
import com.shubham.igi.inventory.ui.components.ConfirmationBottomSheet
import com.shubham.igi.inventory.ui.components.TopAppBar
import com.shubham.igi.inventory.viewmodel.InventoryViewModel
import com.shubham.igi.ui.navigation.NavigationButtonsInventory
import com.shubham.igi.utils.backupDatabase
import com.shubham.igi.utils.restoreDatabase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEditScreen(
    navController: NavController,
    viewModel: InventoryViewModel,
    onSave: (InventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    val selectedItem by viewModel.selectedItem.collectAsState()
    val context = LocalContext.current

    val snackbarHostState = remember { SnackbarHostState() }
    var snackbarMessage by remember { mutableStateOf<String?>(null) }

    // Snackbar launcher
    LaunchedEffect(snackbarMessage) {
        snackbarMessage?.let {
            snackbarHostState.showSnackbar(it)
            snackbarMessage = null
        }
    }

    // Bottom sheet logic
    var showBackupSheet by remember { mutableStateOf(false) }
    var showRestoreSheet by remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Scaffold(
        topBar = {
            TopAppBar(
                title = if (selectedItem == null) "Add Item" else "Edit Item",
                onHome = { navTo("start") },
                onBackup = { showBackupSheet = true },
                onRestore = { showRestoreSheet = true }
            )
        },
        bottomBar = {
            NavigationButtonsInventory(navTo = navTo)
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        AddEditContent(
            modifier = Modifier.padding(innerPadding),
            selectedItem = selectedItem,
            onSave = {
                onSave(it)
                viewModel.clearSelectedItem()
                navController.navigate("list")
            },
            onDelete = { item ->
                viewModel.deleteItem(item)
                navController.navigate("list")
            }
        )
    }

    // Backup confirmation sheet
    if (showBackupSheet) {
        ConfirmationBottomSheet(
            title = "Create a backup of your data?",
            onDismiss = { showBackupSheet = false },
            onConfirm = {
                showBackupSheet = false
                backupDatabase(
                    context = context,
                    onSuccess = {
                        Log.d("Sync", "Backup uploaded successfully")
                        snackbarMessage = "Backup uploaded successfully"
                    },
                    onFailure = {
                        Log.e("Sync", "Backup upload failed", it)
                        snackbarMessage = "Backup upload failed"
                    }
                )
            },
            bottomSheetState = bottomSheetState
        )
    }

    // Restore confirmation sheet
    if (showRestoreSheet) {
        ConfirmationBottomSheet(
            title = "Restore data from backup? This will overwrite existing data.",
            onDismiss = { showRestoreSheet = false },
            onConfirm = {
                showRestoreSheet = false
                restoreDatabase(
                    context = context,
                    onSuccess = {
                        Log.d("Restore", "Database restored successfully")
                        snackbarMessage = "Database restored successfully"
                    },
                    onFailure = {
                        Log.e("Restore", "Restore failed", it)
                        snackbarMessage = "Restore failed"
                    }
                )
            },
            bottomSheetState = bottomSheetState
        )
    }
}