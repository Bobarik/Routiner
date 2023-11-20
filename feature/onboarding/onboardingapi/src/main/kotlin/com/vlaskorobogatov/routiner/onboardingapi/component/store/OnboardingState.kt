package com.vlaskorobogatov.routiner.onboardingapi.component.store

import com.vlaskorobogatov.routiner.archcore.store.State

data class OnboardingState(
    val pagerContent: PagerContent = PagerContent.Habits
) : State

enum class PagerContent {
    Habits, Tracking, Connection
}
