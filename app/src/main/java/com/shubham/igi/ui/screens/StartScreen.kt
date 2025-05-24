package com.shubham.igi.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.shubham.igi.utils.restoreDatabase

@Composable
fun StartScreen(navTo: (String) -> Unit) {
    val context = LocalContext.current

    var restoreInProgress by remember { mutableStateOf(true) }
    var restoreFailed by remember { mutableStateOf(false) }

    // Trigger restore on first composition and on retry
    LaunchedEffect(restoreFailed) {
        if (restoreFailed) return@LaunchedEffect // wait for retry click

        restoreDatabase(
            context = context,
            onSuccess = {
                restoreInProgress = false
                restoreFailed = false
                Log.d("Restore", "Database restored successfully")
            },
            onFailure = { e ->
                restoreInProgress = false
                restoreFailed = true
                Log.e("Restore", "Restore failed", e)
            }
        )
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        contentAlignment = Alignment.Center
    ) {
        when {
            restoreInProgress -> {
                // Show progress indicator while restoring
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                    Spacer(modifier = Modifier.height(16.dp))
                    Text("Restoring latest backup...")
                }
            }

            restoreFailed -> {
                // Show error and retry button
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "Failed to restore backup.",
                        color = MaterialTheme.colorScheme.error
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Button(onClick = {
                        restoreInProgress = true
                        restoreFailed = false
                    }) {
                        Text("Retry")
                    }
                }
            }

            else -> {
                // Show main content only after restore success
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text("I G Insulation", style = MaterialTheme.typography.headlineSmall)
                    Spacer(modifier = Modifier.height(24.dp))

                    Button(onClick = { navTo("home") }) {
                        Text("Inventory")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { navTo("film_stock") }) {
                        Text("Inventory Film")
                    }
                    Spacer(modifier = Modifier.height(8.dp))

                    Button(onClick = { navTo("clients") }) {
                        Text("Clients")
                    }
                }
            }
        }
    }
}