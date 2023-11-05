package com.vlaskorobogatov.routiner.designsystem.components.circleloader

import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

object CircleLoaderDefaults {
    val DefaultCircleLoaderSize = 36.dp
    val MaxContentSize = 32.dp

    @Composable
    fun circleLoaderColors(
        trackColor: Color = colorScheme.outline,
        progressColor: Color = colorScheme.primary,
        contentColor: Color = colorScheme.onSurface
    ) = CircleLoaderColors(
        trackColor = trackColor,
        progressColor = progressColor,
        contentColor = contentColor
    )
}
