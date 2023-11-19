package com.vlaskorobogatov.routiner.startui.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.vlaskorobogatov.routiner.designsystem.R.drawable.img_logo
import com.vlaskorobogatov.routiner.designsystem.R.drawable.img_logo_title
import com.vlaskorobogatov.routiner.startapi.component.StartComponent

@Composable
fun StartScreen(
    component: StartComponent
) = Box(
    modifier = Modifier.fillMaxSize(),
    contentAlignment = Center
) {
    Row(
        modifier = Modifier,
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalAlignment = CenterVertically
    ) {
        Image(painter = painterResource(id = img_logo), contentDescription = null)
        Image(painter = painterResource(id = img_logo_title), contentDescription = null)
    }
}
