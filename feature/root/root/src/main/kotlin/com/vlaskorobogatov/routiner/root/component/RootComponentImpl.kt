package com.vlaskorobogatov.routiner.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.vlaskorobogatov.routiner.rootapi.component.RootComponent
import com.vlaskorobogatov.routiner.rootapi.component.RootComponent.Child.Splash
import com.vlaskorobogatov.routiner.splashapi.component.SplashComponent
import kotlinx.serialization.Serializable
import org.koin.core.parameter.parametersOf
import org.koin.java.KoinJavaComponent.get

class RootComponentImpl(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {

    private fun splash(componentContext: ComponentContext): SplashComponent = get(
        clazz = SplashComponent::class.java,
        parameters = { parametersOf(componentContext) }
    )

    private val navigation = StackNavigation<Config>()

    private val _stack = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Splash,
        handleBackButton = false
    ) { configuration, componentContext ->
        when (configuration) {
            Config.Splash -> Splash(splash(componentContext))
        }
    }

    override val stack: Value<ChildStack<*, RootComponent.Child>> = _stack

    @Serializable
    private sealed interface Config {
        @Serializable data object Splash : Config
    }
}
