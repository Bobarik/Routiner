package com.vlaskorobogatov.routiner.splashapi.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.vlaskorobogatov.routiner.onboardingapi.component.OnboardingComponent
import com.vlaskorobogatov.routiner.startapi.component.StartComponent

interface SplashComponent {

    sealed class Child {
        data class Start(val component: StartComponent) : Child()
        data class Onboarding(val component: OnboardingComponent) : Child()
    }

    val stack: Value<ChildStack<*, Child>>
}
