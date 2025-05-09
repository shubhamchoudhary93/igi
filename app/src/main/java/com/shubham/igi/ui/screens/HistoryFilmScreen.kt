package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shubham.igi.data.model.FilmInventoryItem
import com.shubham.igi.ui.components.FilmHistoryList
import com.shubham.igi.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsFilm

@Composable
fun HistoryFilmScreen(
    updates: List<FilmInventoryItem>,
    navTo: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = "Film History",
                onHome = { navTo("start") },
                onSync = {}
            )
        },
        bottomBar = {
            NavigationButtonsFilm(navTo = navTo)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
                .fillMaxSize()
        ) {
            FilmHistoryList(
                updates = updates,
                modifier = Modifier.weight(1f)
            )
        }
    }
}