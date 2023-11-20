package com.vlaskorobogatov.routiner.designsystem.components.buttons

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun Button(
    modifier: Modifier = Modifier,
    label: String,
    icon: Painter? = null,
    thickness: ButtonThickness = ButtonThickness.Regular,
    colors: ButtonColors = buttonColors(
        containerColor = colorScheme.surface,
        contentColor = colorScheme.onSurface
    ),
    onClick: () -> Unit,
) = Button(
    modifier = modifier.defaultMinSize(minWidth = 58.dp, minHeight = 36.dp),
    contentPadding = PaddingValues(
        horizontal = thickness.horizontalPadding,
        vertical = thickness.verticalPadding
    ),
    colors = colors,
    onClick = onClick,
) {
    icon?.let {
        Image(
            modifier = Modifier
                .padding(end = 4.dp)
                .size(20.dp),
            painter = it,
            contentDescription = null
        )
    }
    Text(text = label)
}
