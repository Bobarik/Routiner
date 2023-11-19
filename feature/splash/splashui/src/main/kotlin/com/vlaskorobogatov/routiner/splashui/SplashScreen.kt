package com.vlaskorobogatov.routiner.splashui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.slide
import com.arkivanov.decompose.extensions.compose.jetpack.stack.animation.stackAnimation
import com.vlaskorobogatov.routiner.designsystem.components.gradientbackground.gradientBackground
import com.vlaskorobogatov.routiner.designsystem.theme.LocalGradients
import com.vlaskorobogatov.routiner.onboardingui.ui.OnboardingScreen
import com.vlaskorobogatov.routiner.splashapi.component.SplashComponent
import com.vlaskorobogatov.routiner.startui.ui.StartScreen

@Composable
fun SplashScreen(
    splashComponent: SplashComponent
) = Children(
    modifier = Modifier
        .gradientBackground(
            background = LocalGradients.current.primaryLinear,
            leftCircle = LocalGradients.current.primaryRadial,
            rightCircle = LocalGradients.current.secondaryRadial
        )
        .fillMaxSize(),
    animation = stackAnimation(slide()),
    stack = splashComponent.stack
) {
    when (val child = it.instance) {
        is SplashComponent.Child.Onboarding -> OnboardingScreen(component = child.component)
        is SplashComponent.Child.Start -> StartScreen(component = child.component)
    }
}
