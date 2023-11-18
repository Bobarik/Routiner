package com.vlaskorobogatov.routiner.splash.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.vlaskorobogatov.routiner.archcompose.collectAsState
import com.vlaskorobogatov.routiner.archcompose.collectLabel
import com.vlaskorobogatov.routiner.splash.component.SplashComponent

@Composable
fun SplashScreen(
    splashComponent: SplashComponent
) {
    val state by splashComponent.collectAsState()

    SplashContent(state = state)

    splashComponent.collectLabel { label ->
        when (label) {
            else -> {}
        }
    }
}
