package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shubham.igi.data.model.FilmInventoryItem
import com.shubham.igi.ui.components.FilmStockContent
import com.shubham.igi.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsFilm

@Composable
fun FilmStockScreen(
    items: List<FilmInventoryItem>,
    onItemClick: (FilmInventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = "Film Stock",
                onHome = { navTo("start") },
                onSync = {}
            )
        },
        bottomBar = {
            NavigationButtonsFilm(navTo = navTo)
        }
    ) { innerPadding ->
        FilmStockContent(
            modifier = Modifier.padding(innerPadding),
            items = items,
            onItemClick = onItemClick,
            navTo = navTo
        )
    }
}