package com.vlaskorobogatov.routiner.onboardingui.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement.Bottom
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithCache
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.layout.ContentScale.Companion.Fit
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.vlaskorobogatov.routiner.archcompose.collectLabel
import com.vlaskorobogatov.routiner.onboardingapi.component.OnboardingComponent
import com.vlaskorobogatov.routiner.onboardingapi.component.store.PagerContent
import com.vlaskorobogatov.routiner.onboardingui.ui.components.AuthButtons
import com.vlaskorobogatov.routiner.onboardingui.ui.mappers.pagerImage
import com.vlaskorobogatov.routiner.onboardingui.ui.mappers.pagerText
import com.vlaskorobogatov.routiner.onboardingui.ui.mappers.pagerTitle

@Composable
fun OnboardingScreen(
    component: OnboardingComponent
) {
    OnboardingContent()

    component.collectLabel {}
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingContent() = Scaffold(
    containerColor = Transparent
) { insetPadding ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(insetPadding)
            .padding(bottom = 24.dp),
    ) {
        val pagerState = rememberPagerState { PagerContent.entries.size }
        OnboardingPager(pagerState)
        Spacer(modifier = Modifier.height(32.dp))
        PagerIndicator(
            selected = pagerState.currentPage,
            amount = PagerContent.entries.size,
        )
        Spacer(modifier = Modifier.height(48.dp))
        AuthButtons()
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ColumnScope.OnboardingPager(pagerState: PagerState) {
    HorizontalPager(
        modifier = Modifier.weight(1f),
        state = pagerState
    ) {
        val state = PagerContent.entries[it]
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 12.dp, end = 12.dp),
            verticalArrangement = Bottom
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                painter = state.pagerImage,
                contentDescription = null,
                contentScale = Fit
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = state.pagerTitle, style = typography.displayMedium, color = colorScheme.onPrimary)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = state.pagerText, style = typography.bodyMedium, color = colorScheme.onPrimaryContainer)
        }
    }
}

@Preview
@Composable
fun PagerIndicator(
    modifier: Modifier = Modifier,
    selected: Int = 1,
    amount: Int = 3,
    colorSelected: Color = colorScheme.onPrimary,
    colorUnselected: Color = colorScheme.onPrimaryContainer,
    indicatorRadius: Dp = 4.dp,
    indicatorInterval: Dp = 16.dp
) = Spacer(
    modifier = modifier
        .padding(horizontal = 12.dp)
        .height(indicatorRadius * 2)
        .width(indicatorRadius * amount * 2 + indicatorInterval * (amount - 1))
        .drawWithCache {
            val indicatorRadiusPx = indicatorRadius.toPx()
            val indicatorIntervalPx = indicatorInterval.toPx()
            val heightOffset = size.height / 2
            onDrawBehind {
                for (i in 0 until amount) {
                    drawCircle(
                        color = if (selected == i) colorSelected else colorUnselected,
                        radius = indicatorRadiusPx,
                        center = Offset(
                            x = indicatorRadiusPx + indicatorRadiusPx * i * 2 + indicatorIntervalPx * i,
                            y = heightOffset
                        )
                    )
                }
            }
        }
)
