package com.vlaskorobogatov.routiner.root.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.parcelable.Parcelable
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.vlaskorobogatov.routiner.root.component.RootComponent.Child
import com.vlaskorobogatov.routiner.root.component.RootComponent.Child.Splash
import com.vlaskorobogatov.routiner.root.store.RootStoreFactory
import com.vlaskorobogatov.routiner.splash.component.SplashComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.parcelize.Parcelize
import org.koin.java.KoinJavaComponent.get

class RootComponentImpl(
    componentContext: ComponentContext,
    storeFactory: StoreFactory,
) : RootComponent, ComponentContext by componentContext {

    private val splash: SplashComponent get() = get(SplashComponent::class.java)

    private val store = instanceKeeper.getStore {
        RootStoreFactory(storeFactory = storeFactory).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state = store.stateFlow
    override val labelFlow = store.labels

    private val navigation = StackNavigation<Config>()

    private val _stack = childStack(
        source = navigation,
        initialConfiguration = Config.Splash,
        handleBackButton = false
    ) { configuration, componentContext ->
        when (configuration) {
            Config.Splash -> Splash(splash)
        }
    }

    override val stack: Value<ChildStack<*, Child>> = _stack

    private sealed interface Config : Parcelable {
        @Parcelize data object Splash : Config
    }
}
