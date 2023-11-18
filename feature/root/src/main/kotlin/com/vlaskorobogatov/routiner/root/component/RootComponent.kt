package com.vlaskorobogatov.routiner.root.component

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.vlaskorobogatov.routiner.archcore.component.FeatureComponent
import com.vlaskorobogatov.routiner.root.store.RootLabel
import com.vlaskorobogatov.routiner.root.store.RootState
import com.vlaskorobogatov.routiner.splash.component.SplashComponent

interface RootComponent : FeatureComponent<RootState, RootLabel> {

    sealed class Child {
        data class Splash(val component: SplashComponent) : Child()
    }

    val stack: Value<ChildStack<*, Child>>
}
