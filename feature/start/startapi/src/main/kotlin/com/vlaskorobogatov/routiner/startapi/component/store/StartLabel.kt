package com.vlaskorobogatov.routiner.startapi.component.store

import com.vlaskorobogatov.routiner.archcore.store.Label

sealed interface StartLabel : Label
data object MoveOnboarding : StartLabel
