package com.vlaskorobogatov.routiner.start.store

import com.arkivanov.mvikotlin.core.store.Store
import com.vlaskorobogatov.routiner.startapi.component.store.StartLabel
import com.vlaskorobogatov.routiner.startapi.component.store.StartState

interface StartStore : Store<StartIntent, StartState, StartLabel>

sealed interface StartIntent
