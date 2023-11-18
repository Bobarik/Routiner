package com.vlaskorobogatov.routiner.splashapi.store

import com.vlaskorobogatov.routiner.archcore.store.State

data class SplashState(
    val text: String = "Hello world"
) : State
