package com.vlaskorobogatov.routiner.splash.store

import com.arkivanov.mvikotlin.core.store.Store
import com.vlaskorobogatov.routiner.splashapi.store.SplashLabel
import com.vlaskorobogatov.routiner.splashapi.store.SplashState

interface SplashStore : Store<SplashIntent, SplashState, SplashLabel>
