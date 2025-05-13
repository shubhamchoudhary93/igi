package com.shubham.igi.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Muted Yellow and neutral light theme colors
private val LightColors = lightColorScheme(
    primary = Color(0xFFFBC02D),       // Muted yellow (Golden)
    secondary = Color(0xFFB59D4B),     // Warm, desaturated mustard
    background = Color(0xFFF5F5F5),    // Soft light gray background
    surface = Color(0xFFEFEFEF),       // Very light neutral surface
    onPrimary = Color.Black,            // Black text on yellow
    onSecondary = Color.Black,          // Black text on secondary
    onBackground = Color(0xFF1A1A1A),   // Near-black text for contrast
    onSurface = Color(0xFF1A1A1A),      // Black text on surface
)

// Muted Yellow and neutral dark theme colors
private val DarkColors = darkColorScheme(
    primary = Color(0xFFFFC107),       // Slightly deeper yellow
    secondary = Color(0xFF8C6C30),     // Deep mustard
    background = Color(0xFF121212),    // Dark neutral background
    surface = Color(0xFF1E1E1E),       // Slightly lighter dark surface
    onPrimary = Color.Black,            // Black text on yellow
    onSecondary = Color.Black,          // Black text on secondary
    onBackground = Color(0xFFE0E0E0),   // Soft light text on dark background
    onSurface = Color(0xFFE0E0E0),      // Soft light text on dark surface
)

@Composable
fun InventoryAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors

    MaterialTheme(
        colorScheme = colors,
        typography = Typography(),
        content = content
    )
}