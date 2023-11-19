package com.vlaskorobogatov.routiner.onboarding.di

import com.vlaskorobogatov.routiner.onboarding.component.OnboardingComponentImpl
import com.vlaskorobogatov.routiner.onboardingapi.component.OnboardingComponent
import org.koin.dsl.module

val OnboardingModule = module {
    factory<OnboardingComponent> { params ->
        OnboardingComponentImpl(
            componentContext = params.get(),
            storeFactory = get()
        )
    }
}
