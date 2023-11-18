package com.vlaskorobogatov.routiner.splash.store

import com.vlaskorobogatov.routiner.archcore.store.State

data class SplashState(
    val text: String = "Hello world"
) : State
