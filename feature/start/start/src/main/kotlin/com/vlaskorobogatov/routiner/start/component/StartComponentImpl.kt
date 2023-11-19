package com.vlaskorobogatov.routiner.start.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.vlaskorobogatov.routiner.start.store.StartFactory
import com.vlaskorobogatov.routiner.startapi.component.StartComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

class StartComponentImpl(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : StartComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        StartFactory(storeFactory = storeFactory).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state = store.stateFlow
    override val labelFlow = store.labels
}
