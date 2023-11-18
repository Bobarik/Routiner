package com.vlaskorobogatov.routiner.sample.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.vlaskorobogatov.routiner.archcompose.collectAsState
import com.vlaskorobogatov.routiner.archcompose.collectLabel
import com.vlaskorobogatov.routiner.sampleapi.component.SampleComponent

@Composable
fun SampleScreen(
    sampleComponent: SampleComponent
) {
    val state by sampleComponent.collectAsState()

    SampleContent(state = state)

    sampleComponent.collectLabel { label ->
        when (label) {
            else -> {}
        }
    }
}
