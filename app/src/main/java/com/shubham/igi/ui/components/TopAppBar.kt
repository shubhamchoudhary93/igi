package com.shubham.igi.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.CloudUpload
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    title: String,
    onHome: () -> Unit,
    onBackup: () -> Unit,
    onRestore: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(4.dp), // Use shadow instead of elevation
        color = MaterialTheme.colorScheme.primary
    ) {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    title,
                    style = MaterialTheme.typography.titleLarge.copy(
                        color = MaterialTheme.colorScheme.onPrimary
                    )
                )
            },
            navigationIcon = {
                IconButton(onClick = onHome) {
                    Icon(
                        imageVector = Icons.Filled.Home,
                        contentDescription = "Go to Start Screen",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            actions = {
                IconButton(onClick = onBackup) {
                    Icon(
                        imageVector = Icons.Filled.CloudUpload,
                        contentDescription = "Backup Data",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
                IconButton(onClick = onRestore) {
                    Icon(
                        imageVector = Icons.Filled.ArrowDownward,
                        contentDescription = "Restore Data",
                        tint = MaterialTheme.colorScheme.onPrimary
                    )
                }
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent // Make background transparent as it's handled by Surface
            )
        )
    }
}