package com.vlaskorobogatov.routiner.sample.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.Dispatchers.Main
import org.koin.core.component.KoinComponent
import org.koin.ext.getFullName

class SampleStoreFactory(
    private val storeFactory: StoreFactory
) : KoinComponent {

    fun create(): SampleStore = object :
        SampleStore,
        Store<SampleIntent, SampleState, SampleLabel> by storeFactory.create(
            name = SampleStore::class.getFullName(),
            initialState = SampleState(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private inner class ExecutorImpl :
        CoroutineExecutor<SampleIntent, SampleAction, SampleState, SampleMessage, SampleLabel>(mainContext = Main) {
        override fun executeIntent(intent: SampleIntent, getState: () -> SampleState) = TODO("Sample")
    }

    private object ReducerImpl : Reducer<SampleState, SampleMessage> {
        override fun SampleState.reduce(msg: SampleMessage): SampleState = when (msg) {
            else -> copy(text = "Hello reduced!")
        }
    }
}
