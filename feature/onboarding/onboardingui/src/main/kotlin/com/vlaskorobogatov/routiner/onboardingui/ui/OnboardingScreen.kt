package com.vlaskorobogatov.routiner.onboardingui.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.vlaskorobogatov.routiner.archcompose.collectAsState
import com.vlaskorobogatov.routiner.archcompose.collectLabel
import com.vlaskorobogatov.routiner.designsystem.components.buttons.Button
import com.vlaskorobogatov.routiner.designsystem.components.buttons.ButtonThickness.Thick
import com.vlaskorobogatov.routiner.designsystem.components.buttons.ButtonThickness.Thin
import com.vlaskorobogatov.routiner.onboardingapi.component.OnboardingComponent
import com.vlaskorobogatov.routiner.onboardingapi.component.store.OnboardingState
import com.vlaskorobogatov.routiner.onboardingui.R.drawable.ic_login_apple
import com.vlaskorobogatov.routiner.onboardingui.R.drawable.ic_login_email
import com.vlaskorobogatov.routiner.onboardingui.R.drawable.ic_login_facebook
import com.vlaskorobogatov.routiner.onboardingui.R.drawable.ic_login_google

@Composable
fun OnboardingScreen(
    component: OnboardingComponent
) {
    val state by component.collectAsState()

    OnboardingContent(state)

    component.collectLabel {

    }
}

@Composable
fun OnboardingContent(state: OnboardingState) = Scaffold(
    containerColor = Transparent
) { insetPadding ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(insetPadding)
            .padding(start = 12.dp, end = 12.dp, bottom = 24.dp)
    ) {
        //TODO: add pager
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(text = state.toString())
        }
        AuthButtons()
    }
}

@Composable
fun AuthButtons() = Column(
    modifier = Modifier
        .fillMaxWidth(),
    verticalArrangement = Arrangement.spacedBy(12.dp)
) {
    Button(
        modifier = Modifier.fillMaxWidth(),
        label = "Continue with E-mail",
        icon = painterResource(id = ic_login_email),
        onClick = { /*TODO*/ },
        thickness = Thick
    )
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Button(
            modifier = Modifier,
            label = "AppleID",
            icon = painterResource(id = ic_login_apple),
            onClick = { /*TODO*/ },
            thickness = Thin
        )
        Button(
            modifier = Modifier,
            label = "Google",
            icon = painterResource(id = ic_login_google),
            onClick = { /*TODO*/ },
            thickness = Thin
        )
        Button(
            modifier = Modifier,
            label = "Facebook",
            icon = painterResource(id = ic_login_facebook),
            onClick = { /*TODO*/ },
            thickness = Thin
        )
    }
    Text(
        modifier = Modifier.fillMaxWidth(),
        text = "By continuing, you agree with our\nTerms of Service & Privacy Policy",
        style = typography.bodySmall,
        color = Color(color = 0xFFAFB4FF),
        textAlign = TextAlign.Center
    )
}
