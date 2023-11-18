package com.vlaskorobogatov.routiner.splashui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Modifier
import com.vlaskorobogatov.routiner.splashapi.store.SplashState

@Composable
fun SplashContent(
    state: SplashState
) = Scaffold { insetPadding ->
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(insetPadding),
        contentAlignment = Center
    ) {

        Text(text = state.text, style = typography.displayLarge)
    }
}
