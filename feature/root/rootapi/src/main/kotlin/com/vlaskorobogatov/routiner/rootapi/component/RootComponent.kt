package com.vlaskorobogatov.routiner.rootapi.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.vlaskorobogatov.routiner.splashapi.component.SplashComponent

interface RootComponent {

    sealed class Child {
        data class Splash(val component: SplashComponent) : Child()
    }

    val stack: Value<ChildStack<*, Child>>
}
