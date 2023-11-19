package com.vlaskorobogatov.routiner.onboarding.store

import com.arkivanov.mvikotlin.core.store.Store
import com.vlaskorobogatov.routiner.onboardingapi.component.store.OnboardingLabel
import com.vlaskorobogatov.routiner.onboardingapi.component.store.OnboardingState

interface OnboardingStore : Store<OnboardingIntent, OnboardingState, OnboardingLabel>

sealed interface OnboardingIntent
