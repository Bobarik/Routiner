package com.vlaskorobogatov.routiner

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.arkivanov.decompose.defaultComponentContext
import com.vlaskorobogatov.routiner.designsystem.theme.RoutinerTheme
import com.vlaskorobogatov.routiner.rootapi.component.RootComponent
import com.vlaskorobogatov.routiner.rootui.ui.RootScreen
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val root: RootComponent by inject(parameters = { parametersOf(defaultComponentContext()) })

        enableEdgeToEdge()

        setContent {
            RoutinerTheme {
                RootScreen(component = root)
            }
        }
    }
}
