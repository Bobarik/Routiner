package com.vlaskorobogatov.routiner.root.store

import com.vlaskorobogatov.routiner.archcore.store.State

data class RootState(
    val text: String = "Hello world"
) : State
