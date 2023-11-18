package com.vlaskorobogatov.routiner.splash.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import kotlinx.coroutines.Dispatchers.Main
import org.koin.core.component.KoinComponent
import org.koin.ext.getFullName

class SplashStoreFactory(
    private val storeFactory: StoreFactory
) : KoinComponent {

    fun create(): SplashStore = object :
        SplashStore,
        Store<SplashIntent, SplashState, SplashLabel> by storeFactory.create(
            name = SplashStore::class.getFullName(),
            initialState = SplashState(),
            executorFactory = ::ExecutorImpl,
            reducer = ReducerImpl
        ) {}

    private inner class ExecutorImpl :
        CoroutineExecutor<SplashIntent, SplashAction, SplashState, SplashMessage, SplashLabel>(mainContext = Main) {
        override fun executeIntent(intent: SplashIntent, getState: () -> SplashState) = TODO("Splash")
    }

    private object ReducerImpl : Reducer<SplashState, SplashMessage> {
        override fun SplashState.reduce(msg: SplashMessage): SplashState = when (msg) {
            else -> copy(text = "Hello reduced!")
        }
    }
}
