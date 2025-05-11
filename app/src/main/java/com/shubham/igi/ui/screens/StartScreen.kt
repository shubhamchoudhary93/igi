package com.shubham.igi.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
    var restoreInProgress by remember { mutableStateOf(false) }

    // Trigger restore only once when this composable is first loaded
    LaunchedEffect(true) {
        if (!restoreInProgress) {
            restoreInProgress = true
            restoreDatabase(
                context = context,
                onSuccess = { Log.d("Restore", "Database restored successfully") },
                onFailure = { e -> Log.e("Restore", "Restore failed", e) }
            )
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("I G Insulation", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(24.dp))
        Button(onClick = { navTo("home") }) {
            Text("Inventory")
        }
        Button(onClick = { navTo("film_stock") }) {
            Text("Inventory Film")
        }
    }
}