package com.vlaskorobogatov.routiner.archcore.component

import com.vlaskorobogatov.routiner.archcore.store.Label
import com.vlaskorobogatov.routiner.archcore.store.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface FeatureComponent<out STATE : State, out LABEL : Label> {

    val state: StateFlow<STATE>
    val labelFlow: Flow<LABEL>
}
