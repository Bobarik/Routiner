package com.vlaskorobogatov.routiner.onboarding.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.mvikotlin.core.instancekeeper.getStore
import com.arkivanov.mvikotlin.core.store.StoreFactory
import com.arkivanov.mvikotlin.extensions.coroutines.labels
import com.arkivanov.mvikotlin.extensions.coroutines.stateFlow
import com.vlaskorobogatov.routiner.onboarding.store.OnboardingFactory
import com.vlaskorobogatov.routiner.onboardingapi.component.OnboardingComponent
import kotlinx.coroutines.ExperimentalCoroutinesApi

class OnboardingComponentImpl(
    componentContext: ComponentContext,
    storeFactory: StoreFactory
) : OnboardingComponent, ComponentContext by componentContext {

    private val store = instanceKeeper.getStore {
        OnboardingFactory(storeFactory = storeFactory).create()
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    override val state = store.stateFlow
    override val labelFlow = store.labels
}
