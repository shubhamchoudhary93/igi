package com.shubham.igi.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shubham.igi.data.model.FilmInventoryItem
import com.shubham.igi.ui.components.AddEditFilmContent
import com.shubham.igi.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsFilm
import com.shubham.igi.viewmodel.FilmInventoryViewModel

@Composable
fun AddEditFilmScreen(
    viewModel: FilmInventoryViewModel,
    onSave: (FilmInventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = "Add / Edit Film",
                onHome = { navTo("start") },
                onSync = {}
            )
        },
        bottomBar = {
            NavigationButtonsFilm(navTo = navTo)
        }
    ) { innerPadding ->
        AddEditFilmContent(
            modifier = Modifier.padding(innerPadding),
            viewModel = viewModel,
            onSave = onSave
        )
    }
}