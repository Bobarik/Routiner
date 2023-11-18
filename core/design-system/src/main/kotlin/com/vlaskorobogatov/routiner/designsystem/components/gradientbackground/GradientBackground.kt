package com.vlaskorobogatov.routiner.designsystem.components.gradientbackground

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import com.vlaskorobogatov.routiner.designsystem.theme.LocalGradients

@Suppress("MagicNumber")
fun Modifier.gradientBackground(
    background: List<Color>,
    leftCircle: List<Color>,
    rightCircle: List<Color>,
) = this.then(
    drawWithCache {
        val leftCenter = Offset(size.width * 0.09f, size.height * 0.24f)
        val rightCenter = Offset(size.width * 0.56f, size.height * 0.85f)
        val circleRadius = size.width * 0.8f
        val gradientRadius = circleRadius
        val startRadius = size.width * 0.06f
        val increment = size.width * 0.1f
        val maxAlpha = 0.4f
        val alphaDecrement = 0.08f
        onDrawBehind {
            drawRect(brush = Brush.linearGradient(background))
            drawCircle(
                brush = Brush.radialGradient(
                    colors = leftCircle,
                    center = leftCenter,
                    radius = gradientRadius
                ),
                radius = circleRadius,
                center = leftCenter,
                alpha = maxAlpha
            )
            drawCircle(
                brush = Brush.radialGradient(
                    colors = rightCircle,
                    center = rightCenter,
                    radius = gradientRadius
                ),
                radius = circleRadius,
                center = rightCenter,
                alpha = maxAlpha
            )
            repeat(5) {
                drawCircle(
                    color = Color.White,
                    radius = startRadius + increment * it,
                    style = Stroke(width = 1f),
                    alpha = maxAlpha - alphaDecrement * it
                )
            }
        }
    }
)

@Preview
@Composable
private fun GradientPreview() = Box(
    modifier = Modifier
        .fillMaxSize()
        .gradientBackground(
            background = LocalGradients.current.primaryLinear,
            leftCircle = LocalGradients.current.primaryRadial,
            rightCircle = LocalGradients.current.secondaryRadial,
        )
)
