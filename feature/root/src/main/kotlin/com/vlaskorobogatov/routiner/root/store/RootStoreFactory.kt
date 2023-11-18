package com.vlaskorobogatov.routiner.root.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.Dispatchers.Main
import org.koin.core.component.KoinComponent
import org.koin.ext.getFullName

class RootStoreFactory(
    private val storeFactory: StoreFactory
) : KoinComponent {

    fun create(): RootStore = object :
        RootStore,
        Store<RootIntent, RootState, RootLabel> by storeFactory.create(
            name = RootStore::class.getFullName(),
            initialState = RootState(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private inner class ExecutorImpl :
        CoroutineExecutor<RootIntent, RootAction, RootState, RootMessage, RootLabel>(mainContext = Main) {
        override fun executeIntent(intent: RootIntent, getState: () -> RootState) = TODO("Root")
    }

    private object ReducerImpl : Reducer<RootState, RootMessage> {
        override fun RootState.reduce(msg: RootMessage): RootState = when (msg) {
            else -> copy(text = "Hello reduced!")
        }
    }
}
