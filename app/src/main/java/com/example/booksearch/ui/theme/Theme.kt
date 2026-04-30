package com.example.booksearch.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val Primary = Color(0xFF5C4033)       // warm brown
private val OnPrimary = Color(0xFFFFFFFF)
private val PrimaryContainer = Color(0xFFEDD9C0)
private val Secondary = Color(0xFF7B6352)
private val Tertiary = Color(0xFF4E6B3E)
private val Background = Color(0xFFFDF8F2)
private val Surface = Color(0xFFFFF8EE)
private val SurfaceVariant = Color(0xFFF2E4D0)

private val BookColorScheme = lightColorScheme(
    primary = Primary,
    onPrimary = OnPrimary,
    primaryContainer = PrimaryContainer,
    secondary = Secondary,
    tertiary = Tertiary,
    background = Background,
    surface = Surface,
    surfaceVariant = SurfaceVariant
)

@Composable
fun BookSearchTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = BookColorScheme,
        content = content
    )
}
