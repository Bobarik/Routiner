package com.vlaskorobogatov.routiner.splash.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.vlaskorobogatov.routiner.splash.store.SplashStoreFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi

class SplashComponentImpl(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : SplashComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        SplashStoreFactory(storeFactory = storeFactory).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state = store.stateFlow
    override val labelFlow = store.labels
}
