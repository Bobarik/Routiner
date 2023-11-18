package com.vlaskorobogatov.routiner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.vlaskorobogatov.routiner.designsystem.theme.RoutinerTheme
import com.vlaskorobogatov.routiner.root.ui.RootScreen
import com.vlaskorobogatov.routiner.root.component.RootComponent
import org.koin.android.ext.android.inject

class MainActivity : ComponentActivity() {

    private val root: RootComponent by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            RoutinerTheme {
                RootScreen(component = root)
            }
        }
    }
}
