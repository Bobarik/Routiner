package com.vlaskorobogatov.routiner.splashapi.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.vlaskorobogatov.routiner.startapi.component.StartComponent

interface SplashComponent {

    sealed class Child {
        // TODO: get children their own components
        data class Start(val component: StartComponent) : Child()
        data class Onboarding(val component: SplashComponent) : Child()
    }

    val stack: Value<ChildStack<*, Child>>
}
