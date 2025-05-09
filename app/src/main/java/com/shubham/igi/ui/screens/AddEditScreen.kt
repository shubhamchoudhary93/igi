package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.shubham.igi.data.model.InventoryItem
import com.shubham.igi.ui.components.AddEditContent
import com.shubham.igi.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsInventory
import com.shubham.igi.viewmodel.InventoryViewModel

@Composable
fun AddEditScreen(
    viewModel: InventoryViewModel,
    onSave: (InventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    val selectedItem by viewModel.selectedItem.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = if (selectedItem == null) "Add Item" else "Edit Item",
                onHome = { navTo("start") },
                onSync = {}
            )
        },
        bottomBar = {
            NavigationButtonsInventory(navTo = navTo)
        }
    ) { innerPadding ->
        AddEditContent(
            modifier = Modifier.padding(innerPadding),
            selectedItem = selectedItem,
            onSave = {
                onSave(it)
                viewModel.clearSelectedItem()
            }
        )
    }
}