package com.shubham.igi.ui.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun NavigationButtonsFilm(navTo: (String) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
        val buttonModifier = Modifier.weight(1f)
        val buttonTextStyle = MaterialTheme.typography.labelLarge.copy(fontSize = 12.sp)
        val smallPadding = PaddingValues(vertical = 4.dp, horizontal = 8.dp)

        Button(onClick = { navTo("film_stock") },
            modifier = buttonModifier,
            contentPadding = smallPadding
        ) { Text("Film", style = buttonTextStyle) }
        Button(onClick = { navTo("add_edit_film") },
            modifier = buttonModifier,
            contentPadding = smallPadding
        ) { Text("Add/Edit", style = buttonTextStyle) }
        Button(onClick = { navTo("history_film") },
            modifier = buttonModifier,
            contentPadding = smallPadding
        ) { Text("History", style = buttonTextStyle) }
    }
}