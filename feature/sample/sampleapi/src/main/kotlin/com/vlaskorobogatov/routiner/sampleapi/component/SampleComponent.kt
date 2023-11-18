package com.vlaskorobogatov.routiner.sampleapi.component

import com.vlaskorobogatov.routiner.archcore.component.FeatureComponent
import com.vlaskorobogatov.routiner.sampleapi.store.SampleLabel
import com.vlaskorobogatov.routiner.sampleapi.store.SampleState

interface SampleComponent : FeatureComponent<SampleState, SampleLabel>
