package com.vlaskorobogatov.routiner.start.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.vlaskorobogatov.routiner.startapi.component.store.MoveOnboarding
import com.vlaskorobogatov.routiner.startapi.component.store.StartLabel
import com.vlaskorobogatov.routiner.startapi.component.store.StartState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class StartFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): StartStore = object : StartStore, Store<StartIntent, StartState, StartLabel> by storeFactory.create(
        name = StartStore::class.java.name,
        initialState = StartState,
        bootstrapper = SimpleBootstrapper(Unit),
        executorFactory = ::ExecutorImpl,
        reducer = ReducerImpl
    ) {}

    private inner class ExecutorImpl : CoroutineExecutor<StartIntent, Unit, StartState, Unit, StartLabel>(
        Dispatchers.Main
    ) {
        override fun executeAction(action: Unit, getState: () -> StartState) {
            super.executeAction(action, getState)
            scope.launch {
                //TODO: logic related to account processing
                delay(timeMillis = 2000)
                publish(MoveOnboarding)
            }
        }
    }

    private object ReducerImpl : Reducer<StartState, Unit> {
        override fun StartState.reduce(msg: Unit) = StartState
    }
}
