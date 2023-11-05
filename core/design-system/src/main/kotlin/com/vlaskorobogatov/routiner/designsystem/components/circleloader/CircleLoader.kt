package com.vlaskorobogatov.routiner.designsystem.components.circleloader

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vlaskorobogatov.routiner.designsystem.components.circleloader.CircleLoaderDefaults.circleLoaderColors
import com.vlaskorobogatov.routiner.designsystem.theme.RoutinerTheme

@Composable
fun CircleLoader(
    modifier: Modifier = Modifier,
    progress: Float,
    strokeWidth: Dp = 2.dp,
    colors: CircleLoaderColors = circleLoaderColors(),
    innerContent: @Composable (modifier: Modifier) -> Unit
) = Box(
    contentAlignment = Center
) {
    CircularProgressIndicator(
        modifier = modifier,
        progress = progress,
        color = colors.progressColor,
        trackColor = colors.trackColor,
        strokeCap = StrokeCap.Round,
        strokeWidth = strokeWidth
    )
    CompositionLocalProvider(
        LocalContentColor provides colors.contentColor,
        LocalTextStyle provides typography.labelLarge
    ) {
        innerContent(
            Modifier
                .padding(strokeWidth)
                .width(40.dp - strokeWidth * 2)
        )
    }
}

@Preview
@Composable
private fun CircleLoaderPreview() = RoutinerTheme {
    CircleLoader(
        progress = 0.25f,
        colors = circleLoaderColors(
            contentColor = Color.White
        )
    ) { modifier ->
        Text(
            modifier = modifier,
            text = "250002%",
            maxLines = 1,
            textAlign = TextAlign.Center
        )
    }
}
