package com.shubham.igi.ui.navigation

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
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
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shubham.igi.client.data.repository.ReceiptRepository
import com.shubham.igi.client.domain.usecase.AddClientUseCase
import com.shubham.igi.client.domain.usecase.GetClientsWithDueUseCase
import com.shubham.igi.client.ui.addeditclient.AddEditClientScreen
import com.shubham.igi.client.ui.addreceipt.AddReceiptScreen
import com.shubham.igi.client.ui.clientdetail.ClientDetailScreen
import com.shubham.igi.client.ui.clientdetail.ClientDetailViewModel
import com.shubham.igi.client.ui.clientdetail.ClientDetailViewModelFactory
import com.shubham.igi.client.ui.clientlist.ClientListScreen
import com.shubham.igi.client.ui.clientlist.ClientListViewModel
import com.shubham.igi.client.ui.clientlist.ClientListViewModelFactory
import com.shubham.igi.client.ui.receiptdetail.ReceiptDetailScreen
import com.shubham.igi.client.ui.receiptdetail.ReceiptDetailViewModel
import com.shubham.igi.client.ui.receiptdetail.ReceiptDetailViewModelFactory
import com.shubham.igi.data.AppDatabase
import com.shubham.igi.inventory.data.model.FilmInventoryItem
import com.shubham.igi.inventory.data.model.InventoryItem
import com.shubham.igi.inventory.data.model.InventoryUpdate
import com.shubham.igi.inventory.ui.components.ConfirmationBottomSheet
import com.shubham.igi.inventory.ui.screens.AddEditFilmScreen
import com.shubham.igi.inventory.ui.screens.AddEditScreen
import com.shubham.igi.inventory.ui.screens.FilmStockScreen
import com.shubham.igi.inventory.ui.screens.HistoryFilmScreen
import com.shubham.igi.inventory.ui.screens.HistoryScreen
import com.shubham.igi.inventory.ui.screens.HomeScreen
import com.shubham.igi.inventory.ui.screens.InventoryListScreen
import com.shubham.igi.inventory.viewmodel.FilmInventoryViewModel
import com.shubham.igi.inventory.viewmodel.InventoryViewModel
import com.shubham.igi.ui.screens.StartScreen
import com.shubham.igi.utils.backupDatabase
import com.shubham.igi.utils.restoreDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@RequiresApi(Build.VERSION_CODES.N)
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

    val db = AppDatabase.getDatabase(context)
    val repo = ReceiptRepository(
        clientDao = db.clientDao(),
        receiptDao = db.receiptDao(),
        context = context
    )

    val getClientsWithDue = GetClientsWithDueUseCase(repo)
    val addClient = AddClientUseCase(repo)

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

        composable(Screen.ClientList.route) {
            val viewModel: ClientListViewModel = viewModel(
                factory = ClientListViewModelFactory(getClientsWithDue)
            )

            ClientListScreen(
                viewModel = viewModel,
                onClientClick = { clientId -> navController.navigate("clients/$clientId") },
                onAddClientClick = { navController.navigate(Screen.AddClient.route) }
            )
        }

        composable(Screen.AddClient.route) {
            AddEditClientScreen(
                onSave = { client ->
                    CoroutineScope(Dispatchers.IO).launch {
                        addClient(client)
                    }
                    navController.popBackStack()
                },
                onCancel = { navController.popBackStack() }
            )
        }

        composable("clients/{clientId}") { backStackEntry ->
            val clientId = backStackEntry.arguments?.getString("clientId")?.toLongOrNull()
            clientId?.let {
                val viewModel: ClientDetailViewModel = viewModel(
                    factory = ClientDetailViewModelFactory(clientId, repo)
                )

                ClientDetailScreen(
                    viewModel = viewModel,
                    onAddReceipt = { navController.navigate("clients/$clientId/add-receipt") },
                    onReceiptClick = { receiptId -> navController.navigate("receipt/$receiptId") }
                )
            }
        }

        composable("clients/{clientId}/add-receipt") { backStackEntry ->
            val clientId = backStackEntry.arguments?.getString("clientId")?.toLongOrNull()
            clientId?.let {
                AddReceiptScreen(
                    clientId = it,
                    onSave = { receipt ->
                        CoroutineScope(Dispatchers.IO).launch {
                            repo.addReceipt(receipt)
                        }
                        navController.popBackStack()
                    },
                    onCancel = { navController.popBackStack() }
                )
            }
        }

        composable("receipt/{receiptId}") { backStackEntry ->
            val receiptId = backStackEntry.arguments?.getString("receiptId")?.toLongOrNull()
            receiptId?.let {
                val viewModel: ReceiptDetailViewModel = viewModel(
                    factory = ReceiptDetailViewModelFactory(it, repo)
                )

                ReceiptDetailScreen(
                    viewModel = viewModel,
                    onBack = { navController.popBackStack() },
                    onUpdated = {
                        navController.previousBackStackEntry?.savedStateHandle?.set("refresh", true)
                    }
                )
            }
        }

        composable(Screen.Start.route) {
            StartScreen(
                navTo = { route -> navController.navigate(route) }
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
                navTo = { navController.navigate(it) },
                navController = navController
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

    // Backup confirmation bottom sheet
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

    // Restore confirmation bottom sheet
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
                        viewModel.refresh() // Refresh after restore
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