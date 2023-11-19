package com.vlaskorobogatov.routiner.designsystem.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

internal val PrimaryLinear = listOf(
    Color(color = 0xFF6B73FF),
    Color(color = 0xFF000DFF),
)

internal val PrimaryRadial = listOf(
    Color(color = 0xFFEF88ED),
    Color(color = 0xFF7269E3),
    Color(color = 0x008350DB),
)

internal val SecondaryRadial: List<Color> = listOf(
    Color(color = 0xFFEBEBEB),
    Color(color = 0xFFA3A1C8),
    Color(color = 0x007B55BC),
)

data class Gradient(
    val primaryLinear: List<Color> = PrimaryLinear,
    val primaryRadial: List<Color> = PrimaryRadial,
    val secondaryRadial: List<Color> = SecondaryRadial,
)

val LocalGradients = staticCompositionLocalOf { Gradient() }
