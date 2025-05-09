package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.InventoryUpdate
import com.shubham.igi.ui.components.HistoryContent
import com.shubham.igi.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsInventory

@Composable
fun HistoryScreen(
    updates: List<InventoryUpdate>,
    navTo: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = "History",
                onHome = { navTo("start") },
                onSync = {}
            )
        },
        bottomBar = {
            NavigationButtonsInventory(navTo = navTo)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            HistoryContent(
                updates = updates,
                modifier = Modifier.weight(1f)
            )
        }
    }
}