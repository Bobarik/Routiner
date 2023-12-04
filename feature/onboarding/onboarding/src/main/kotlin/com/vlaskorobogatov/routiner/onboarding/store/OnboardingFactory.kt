package com.vlaskorobogatov.routiner.onboarding.store

import com.arkivanov.mvikotlin.core.store.Reducer
import com.arkivanov.mvikotlin.core.store.SimpleBootstrapper
import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.CoroutineExecutor
import com.vlaskorobogatov.routiner.onboardingapi.component.store.OnboardingLabel
import com.vlaskorobogatov.routiner.onboardingapi.component.store.OnboardingState
import kotlinx.coroutines.Dispatchers.Main

class OnboardingFactory(
    private val storeFactory: StoreFactory
) {

    fun create(): OnboardingStore =
        object :
            OnboardingStore,
            Store<OnboardingIntent, OnboardingState, OnboardingLabel> by storeFactory.create(
                name = OnboardingStore::class.java.name,
                initialState = OnboardingState(),
                bootstrapper = SimpleBootstrapper(Unit),
                executorFactory = ::ExecutorImpl,
                reducer = ReducerImpl
            ) {}

    private inner class ExecutorImpl :
        CoroutineExecutor<OnboardingIntent, Unit, OnboardingState, Unit, OnboardingLabel>(Main)

    private object ReducerImpl : Reducer<OnboardingState, Unit> {
        override fun OnboardingState.reduce(msg: Unit) = OnboardingState()
    }
}
