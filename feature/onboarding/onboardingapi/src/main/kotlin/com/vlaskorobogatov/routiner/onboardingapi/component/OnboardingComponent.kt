package com.vlaskorobogatov.routiner.onboardingapi.component

import com.vlaskorobogatov.routiner.archcore.component.FeatureComponent
import com.vlaskorobogatov.routiner.onboardingapi.component.store.OnboardingLabel
import com.vlaskorobogatov.routiner.onboardingapi.component.store.OnboardingState

interface OnboardingComponent : FeatureComponent<OnboardingState, OnboardingLabel>
