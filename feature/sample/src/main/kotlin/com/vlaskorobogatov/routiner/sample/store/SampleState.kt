package com.vlaskorobogatov.routiner.sample.store

import com.vlaskorobogatov.routiner.archcore.store.State

data class SampleState(
    val text: String = "Hello world"
) : State
