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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.shubham.igi.inventory.data.model.FilmInventoryItem
import com.shubham.igi.inventory.ui.components.ConfirmationBottomSheet
import com.shubham.igi.inventory.ui.components.FilmStockContent
import com.shubham.igi.inventory.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsFilm
import com.shubham.igi.utils.backupDatabase
import com.shubham.igi.utils.restoreDatabase

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilmStockScreen(
    items: List<FilmInventoryItem>,
    onItemClick: (FilmInventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
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

    // States for showing the confirmation bottom sheet
    var showBackupSheet by remember { mutableStateOf(false) }
    var showRestoreSheet by remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    Scaffold(
        topBar = {
            TopAppBar(
                title = "Film Stock",
                onHome = { navTo("start") },
                onBackup = { showBackupSheet = true },
                onRestore = { showRestoreSheet = true }
            )
        },
        bottomBar = {
            NavigationButtonsFilm(navTo = navTo)
        },
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        }
    ) { innerPadding ->
        FilmStockContent(
            modifier = Modifier.padding(innerPadding),
            items = items,
            onItemClick = onItemClick,
            navTo = navTo
        )
    }

    // In ConfirmationBottomSheet for Backup
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

    // In ConfirmationBottomSheet for Restore
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