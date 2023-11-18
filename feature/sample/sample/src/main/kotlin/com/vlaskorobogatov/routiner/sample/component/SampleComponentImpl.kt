package com.vlaskorobogatov.routiner.sample.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.vlaskorobogatov.routiner.sample.store.SampleStoreFactory
import com.vlaskorobogatov.routiner.sampleapi.component.SampleComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

class SampleComponentImpl(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : SampleComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        SampleStoreFactory(storeFactory = storeFactory).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state = store.stateFlow
    override val labelFlow = store.labels
}
