package com.shubham.igi.ui.navigation

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shubham.igi.data.model.FilmInventoryItem
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.components.ConfirmationBottomSheet
import com.shubham.igi.ui.screens.AddEditFilmScreen
import com.shubham.igi.ui.screens.AddEditScreen
import com.shubham.igi.ui.screens.FilmStockScreen
import com.shubham.igi.ui.screens.HistoryFilmScreen
import com.shubham.igi.ui.screens.HistoryScreen
import com.shubham.igi.ui.screens.HomeScreen
import com.shubham.igi.ui.screens.InventoryListScreen
import com.shubham.igi.ui.screens.StartScreen
import com.shubham.igi.utils.backupDatabase
import com.shubham.igi.utils.restoreDatabase
import com.shubham.igi.viewmodel.FilmInventoryViewModel
import com.shubham.igi.viewmodel.InventoryViewModel

sealed class Screen(val route: String) {
    data object Start : Screen("start")
    data object Home : Screen("home")
    data object AddEdit : Screen("add_edit")
    data object AddEditFilm : Screen("add_edit_film")
    data object List : Screen("list")
    data object History : Screen("history")
    data object HistoryFilm : Screen("history_film")
    data object FilmStock : Screen("film_stock")
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InventoryNavHost(
    navController: NavHostController,
    viewModel: InventoryViewModel,
    filmViewModel: FilmInventoryViewModel,
    inventoryItems: List<InventoryItem>,
    filmStockItems: List<FilmInventoryItem>,
    tempUpdates: List<InventoryUpdate>,
    allUpdates: List<InventoryUpdate>,
    onAddUpdate: (Int, String, String, Int, String) -> Unit,
    onCommit: () -> Unit,
    onSaveItem: (InventoryItem) -> Unit,
    onSaveItemFilm: (FilmInventoryItem) -> Unit
) {
    val context = LocalContext.current

    val snackbarHostState = remember { SnackbarHostState() }
    var snackbarMessage by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(snackbarMessage) {
        snackbarMessage?.let {
            snackbarHostState.showSnackbar(it)
            snackbarMessage = null
        }
    }

    var showBackupSheet by remember { mutableStateOf(false) }
    var showRestoreSheet by remember { mutableStateOf(false) }

    val bottomSheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)

    NavHost(navController = navController, startDestination = Screen.Start.route) {

        composable(Screen.Start.route) {
            StartScreen(
                navTo = { navController.navigate(it) }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                items = inventoryItems,
                tempUpdates = tempUpdates,
                onAddUpdate = onAddUpdate,
                onCommit = onCommit,
                onDiscard = { viewModel.clearTempUpdates() },
                navTo = { navController.navigate(it) },
                snackbarHostState = snackbarHostState,
                onBackup = { showBackupSheet = true },
                onRestore = { showRestoreSheet = true }
            )
        }

        composable(Screen.FilmStock.route) {
            FilmStockScreen(
                items = filmStockItems,
                onItemClick = {
                    filmViewModel.setSelectedItem(it)
                    navController.navigate(Screen.AddEditFilm.route)
                },
                navTo = { navController.navigate(it) }
            )
        }

        composable(Screen.AddEdit.route) {
            AddEditScreen(
                viewModel = viewModel,
                onSave = {
                    onSaveItem(it)
                    navController.popBackStack()
                },
                navTo = { navController.navigate(it) }
            )
        }

        composable(Screen.AddEditFilm.route) {
            AddEditFilmScreen(
                viewModel = filmViewModel,
                onSave = {
                    onSaveItemFilm(it)
                    navController.popBackStack()
                },
                navTo = { navController.navigate(it) }
            )
        }

        composable(Screen.List.route) {
            InventoryListScreen(
                items = inventoryItems,
                onItemClick = {
                    viewModel.setSelectedItem(it)
                    navController.navigate(Screen.AddEdit.route)
                },
                navTo = { navController.navigate(it) }
            )
        }

        composable(Screen.History.route) {
            HistoryScreen(
                updates = allUpdates,
                navTo = { navController.navigate(it) }
            )
        }

        composable(Screen.HistoryFilm.route) {
            HistoryFilmScreen(
                updates = filmStockItems,
                navTo = { navController.navigate(it) }
            )
        }
    }

    // Backup confirmation
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

    // Restore confirmation
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
                        viewModel.refresh() // ✅ Refresh list after restore
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