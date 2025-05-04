package com.shubham.igi.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.screens.*

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object AddEdit : Screen("add_edit")
    object List : Screen("list")
    object History : Screen("history")
}

@Composable
fun InventoryNavHost(
    navController: NavHostController,
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
                navTo = { navController.navigate(it) }
            )
        }

        composable(Screen.AddEdit.route) {
            AddEditScreen(
                item = null, // If editing, pass item via ViewModel or NavBackStack
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
                    // Navigate to edit screen with selected item
                    // (You’ll need shared ViewModel or nav args for passing item)
                    navController.navigate(Screen.AddEdit.route)
                },
                navTo = { navController.navigate(it) }
            )
        }

        composable(Screen.History.route) {
            HistoryScreen(updates = allUpdates,
                navTo = { navController.navigate(it) })
        }
    }
}