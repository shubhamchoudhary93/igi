package com.shubham.igi

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import com.shubham.igi.data.AppDatabase
import com.shubham.igi.inventory.data.repository.FilmInventoryRepository
import com.shubham.igi.inventory.data.repository.InventoryRepository
import com.shubham.igi.inventory.viewmodel.FilmInventoryViewModel
import com.shubham.igi.inventory.viewmodel.InventoryViewModel
import com.shubham.igi.ui.navigation.InventoryNavHost
import com.shubham.igi.ui.theme.InventoryAppTheme

class MainActivity : ComponentActivity() {

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {
            InventoryAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background,
                    tonalElevation = 0.dp
                ) {
                    val context = applicationContext
                    val db = AppDatabase.getDatabase(context)
                    val repository = InventoryRepository(db.inventoryDao(), db.updateDao(), context)
                    val filmStockRepository =
                        FilmInventoryRepository(db.filmInventoryDao(), context)

                    val viewModel: InventoryViewModel = viewModel(
                        factory = InventoryViewModel.Factory(repository)
                    )

                    val filmViewModel: FilmInventoryViewModel = viewModel(
                        factory = FilmInventoryViewModel.Factory(filmStockRepository)
                    )

                    val navController = rememberNavController()

                    // Collect state from ViewModel
                    val items by viewModel.inventoryItems.collectAsState()
                    val filmStockItems by filmViewModel.filmInventoryItems.collectAsState()
                    val tempUpdates by viewModel.tempUpdates.collectAsState()
                    val allUpdates by viewModel.allUpdates.collectAsState()

                    // ✅ Pass the ViewModel to InventoryNavHost
                    InventoryNavHost(
                        navController = navController,
                        viewModel = viewModel,
                        filmViewModel = filmViewModel,
                        inventoryItems = items,
                        filmStockItems = filmStockItems,
                        tempUpdates = tempUpdates,
                        allUpdates = allUpdates,
                        onAddUpdate = { id, itemName, category, change, date ->
                            viewModel.addTempUpdate(
                                id,
                                itemName,
                                category,
                                change,
                                date
                            )
                        },
                        onCommit = { viewModel.commitUpdates() },
                        onSaveItem = { item ->
                            if (item.id == 0) viewModel.insertItem(item)
                            else viewModel.updateItem(item)
                        },
                        onSaveItemFilm = { item ->
                            if (item.id == 0) filmViewModel.insertItem(item)
                            else filmViewModel.updateItem(item)
                        }
                    )
                }
            }
        }
    }
}