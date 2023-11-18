package com.vlaskorobogatov.routiner.root.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.vlaskorobogatov.routiner.root.component.RootComponent
import com.vlaskorobogatov.routiner.splash.ui.SplashScreen

@Composable
fun RootScreen(
    component: RootComponent
) = Children(stack = component.stack) {
    when (val child = it.instance) {
        is RootComponent.Child.Splash -> SplashScreen(child.component)
    }
}
