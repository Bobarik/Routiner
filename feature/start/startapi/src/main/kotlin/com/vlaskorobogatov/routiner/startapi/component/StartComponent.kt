package com.vlaskorobogatov.routiner.startapi.component

import com.vlaskorobogatov.routiner.archcore.component.FeatureComponent
import com.vlaskorobogatov.routiner.startapi.component.store.StartState
import com.vlaskorobogatov.routiner.startapi.component.store.StartLabel

interface StartComponent: FeatureComponent<StartState, StartLabel> {

    fun process()
}
