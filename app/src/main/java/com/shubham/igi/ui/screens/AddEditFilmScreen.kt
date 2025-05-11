package com.shubham.igi.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import com.shubham.igi.data.model.FilmInventoryItem
import com.shubham.igi.ui.components.AddEditFilmContent
import com.shubham.igi.ui.components.TopAppBar
import com.shubham.igi.ui.navigation.NavigationButtonsFilm
import com.shubham.igi.utils.backupDatabase
import com.shubham.igi.utils.restoreDatabase
import com.shubham.igi.viewmodel.FilmInventoryViewModel

@Composable
fun AddEditFilmScreen(
    viewModel: FilmInventoryViewModel,
    onSave: (FilmInventoryItem) -> Unit,
    navTo: (String) -> Unit
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = "Add / Edit Film",
                onHome = { navTo("start") },
                onBackup = {
                    backupDatabase(
                        context = context,
                        onSuccess = { Log.d("Sync", "Backup uploaded successfully") },
                        onFailure = { e -> Log.e("Sync", "Backup upload failed", e) }
                    )
                },
                onRestore = {
                    restoreDatabase(
                        context = context,
                        onSuccess = { Log.d("Restore", "Database restored successfully") },
                        onFailure = { e -> Log.e("Restore", "Restore failed", e) }
                    )
                }
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