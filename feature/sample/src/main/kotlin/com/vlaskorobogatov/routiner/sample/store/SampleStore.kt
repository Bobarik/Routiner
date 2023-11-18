package com.vlaskorobogatov.routiner.sample.store

import com.arkivanov.mvikotlin.core.store.Store

interface SampleStore : Store<SampleIntent, SampleState, SampleLabel>
