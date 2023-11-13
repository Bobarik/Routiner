package com.vlaskorobogatov.routiner.archcompose

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.repeatOnLifecycle
import com.vlaskorobogatov.routiner.archcore.component.FeatureComponent
import com.vlaskorobogatov.routiner.archcore.store.Label
import com.vlaskorobogatov.routiner.archcore.store.State

@SuppressLint("ComposableNaming")
@Composable
fun <STATE : State, LABEL : Label> FeatureComponent<STATE, LABEL>.collectLabel(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
    sideEffect: (suspend (sideEffect: LABEL) -> Unit)
) {
    val lifecycleOwner = LocalLifecycleOwner.current

    LaunchedEffect(key1 = labelFlow, key2 = lifecycleOwner) {
        lifecycleOwner.lifecycle.repeatOnLifecycle(lifecycleState) {
            labelFlow.collect { sideEffect(it) }
        }
    }
}

@Composable
fun <STATE : State, LABEL : Label> FeatureComponent<STATE, LABEL>.collectAsState(
    lifecycleState: Lifecycle.State = Lifecycle.State.STARTED,
) = state.collectAsStateWithLifecycle(minActiveState = lifecycleState)
