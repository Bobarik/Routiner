package com.vlaskorobogatov.routiner.sample.store

import com.arkivanov.mvikotlin.core.store.Store
import com.vlaskorobogatov.routiner.sampleapi.store.SampleLabel
import com.vlaskorobogatov.routiner.sampleapi.store.SampleState

interface SampleStore : Store<SampleIntent, SampleState, SampleLabel>
