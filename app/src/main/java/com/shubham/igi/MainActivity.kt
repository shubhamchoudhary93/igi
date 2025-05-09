package com.shubham.igi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.shubham.igi.data.AppDatabase
import com.shubham.igi.data.repository.FilmInventoryRepository
import com.shubham.igi.data.repository.InventoryRepository
import com.shubham.igi.ui.navigation.InventoryNavHost
import com.shubham.igi.ui.theme.InventoryAppTheme
import com.shubham.igi.viewmodel.FilmInventoryViewModel
import com.shubham.igi.viewmodel.InventoryViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            InventoryAppTheme {
                Surface(color = MaterialTheme.colorScheme.background) {
                    val context = applicationContext
                    val db = AppDatabase.getDatabase(context)
                    val repository = InventoryRepository(db.inventoryDao(), db.updateDao())
                    val filmStockRepository = FilmInventoryRepository(db.filmInventoryDao())

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