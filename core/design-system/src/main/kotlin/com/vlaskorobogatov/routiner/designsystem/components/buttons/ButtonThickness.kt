package com.vlaskorobogatov.routiner.designsystem.components.buttons

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

enum class ButtonThickness(
    val verticalPadding: Dp,
    val horizontalPadding: Dp
) {
    Thin(8.dp, 16.dp),
    Regular(12.dp, 20.dp),
    Thick(16.dp, 20.dp)
}
