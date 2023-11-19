package com.vlaskorobogatov.routiner.splash.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.vlaskorobogatov.routiner.onboardingapi.component.OnboardingComponent
import com.vlaskorobogatov.routiner.splashapi.component.SplashComponent
import com.vlaskorobogatov.routiner.splashapi.component.SplashComponent.Child.Onboarding
import com.vlaskorobogatov.routiner.splashapi.component.SplashComponent.Child.Start
import com.vlaskorobogatov.routiner.startapi.component.StartComponent
import kotlinx.serialization.Serializable
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.get

class SplashComponentImpl(
    componentContext: ComponentContext,
) : SplashComponent, ComponentContext by componentContext {

    private fun start(
        componentContext: ComponentContext,
        onProcess: () -> Unit
    ): StartComponent = get(
        clazz = StartComponent::class.java,
        parameters = { parametersOf(componentContext, onProcess) }
    )

    private fun onboarding(
        componentContext: ComponentContext,
    ): OnboardingComponent = get(
        clazz = OnboardingComponent::class.java,
        parameters = { parametersOf(componentContext) }
    )

    private val navigation = StackNavigation<Config>()

    private val _stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Start,
        handleBackButton = false
    ) { configuration, componentContext ->
        when (configuration) {
            Config.Start -> Start(
                start(
                    componentContext = componentContext,
                    onProcess = { navigation.push(Config.Onboarding) }
                )
            )

            Config.Onboarding -> Onboarding(onboarding(componentContext = componentContext))
        }
    }

    override val stack: Value<ChildStack<*, SplashComponent.Child>> = _stack

    @Serializable
    private sealed interface Config {
        @Serializable data object Start : Config
        @Serializable data object Onboarding : Config
    }
}
