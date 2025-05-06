package com.shubham.igi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.screens.AddEditScreen
import com.shubham.igi.ui.screens.HistoryScreen
import com.shubham.igi.ui.screens.HomeScreen
import com.shubham.igi.ui.screens.InventoryListScreen
import com.shubham.igi.viewmodel.InventoryViewModel

sealed class Screen(val route: String) {
    data object Home : Screen("home")
    data object AddEdit : Screen("add_edit")
    data object List : Screen("list")
    data object History : Screen("history")
}

@Composable
fun InventoryNavHost(
    navController: NavHostController,
    viewModel: InventoryViewModel,
    inventoryItems: List<InventoryItem>,
    tempUpdates: List<InventoryUpdate>,
    allUpdates: List<InventoryUpdate>,
    onAddUpdate: (Int, String, Int) -> Unit,
    onCommit: () -> Unit,
    onSaveItem: (InventoryItem) -> Unit,
) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {

        composable(Screen.Home.route) {
            HomeScreen(
                items = inventoryItems,
                tempUpdates = tempUpdates,
                onAddUpdate = onAddUpdate,
                onCommit = onCommit,
                onDiscard = { viewModel.clearTempUpdates() },
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

        composable(Screen.List.route) {
            InventoryListScreen(
                items = inventoryItems,
                onItemClick = {
                    viewModel.setSelectedItem(it) // ✅ set selected item in ViewModel
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
    }
}