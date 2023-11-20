package com.vlaskorobogatov.routiner.designsystem.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = Blue100,
    onPrimary = Color.White,
    onPrimaryContainer = Blue40,
    error = Red100,
    background = Color.White,
    surface = Color.White,
    onSurface = Black100,
    outline = Black10
)

@Composable
fun RoutinerTheme(
    content: @Composable () -> Unit
) {
    val colorScheme = LightColorScheme

    CompositionLocalProvider(
        LocalGradients provides Gradient()
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = Typography,
            content = content
        )
    }
}
