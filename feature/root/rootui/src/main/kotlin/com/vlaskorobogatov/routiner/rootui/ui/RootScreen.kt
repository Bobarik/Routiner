package com.vlaskorobogatov.routiner.rootui.ui

import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.vlaskorobogatov.routiner.rootapi.component.RootComponent
import com.vlaskorobogatov.routiner.splashui.SplashScreen

@Composable
fun RootScreen(
    component: RootComponent
) = Children(stack = component.stack) {
    when (val child = it.instance) {
        is RootComponent.Child.Splash -> SplashScreen(child.component)
    }
}
