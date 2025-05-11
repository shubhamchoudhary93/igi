package com.shubham.igi.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Download
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Upload
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: String, onHome: () -> Unit, onBackup: () -> Unit, onRestore: () -> Unit) {
    CenterAlignedTopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = onHome) {
                Icon(imageVector = Icons.Filled.Home, contentDescription = "Go to Start Screen")
            }
        },
        actions = {
            IconButton(onClick = onBackup) {
                Icon(imageVector = Icons.Filled.Upload, contentDescription = "Backup Data")
            }
            IconButton(onClick = onRestore) {
                Icon(imageVector = Icons.Filled.Download, contentDescription = "Restore Data")
            }
        },
    )
}