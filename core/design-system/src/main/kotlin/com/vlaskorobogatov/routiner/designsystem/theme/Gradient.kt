package com.vlaskorobogatov.routiner.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color

val GradientColorFirst = Color(color = 0xFF6B73FF)
val GradientColorSecond = Color(color = 0xFF000DFF)

internal val MainGradient = Brush.linearGradient(
    0f to GradientColorFirst,
    1f to GradientColorSecond,
    start = Offset(x = 130f, y = 104f),
    end = Offset(x = 390f, y = 104f),
)

val LocalGradientColors = staticCompositionLocalOf { Brush.linearGradient() }
