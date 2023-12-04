package com.vlaskorobogatov.routiner.onboardingui.ui.mappers

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.vlaskorobogatov.routiner.onboardingapi.component.store.PagerContent
import com.vlaskorobogatov.routiner.onboardingui.R

val PagerContent.pagerTitle: String
    @Composable
    @ReadOnlyComposable
    get() = stringResource(
        when (this) {
            PagerContent.Habits -> R.string.onboarding_pager_habits_title
            PagerContent.Tracking -> R.string.onboarding_tracking_title
            PagerContent.Connection -> R.string.onboarding_connection_title
        }
    )

val PagerContent.pagerText: String
    @Composable
    @ReadOnlyComposable
    get() = stringResource(
        when (this) {
            PagerContent.Habits -> R.string.onboarding_habits_text
            PagerContent.Tracking -> R.string.onboarding_tracker_text
            PagerContent.Connection -> R.string.onboarding_connection_text
        }
    )

val PagerContent.pagerImage: Painter
    @Composable
    get() = painterResource(
        when (this) {
            PagerContent.Habits -> R.drawable.img_onboarding_habits
            PagerContent.Tracking -> R.drawable.img_onboarding_tracking
            PagerContent.Connection -> R.drawable.img_onboarding_connection
        }
    )
