package org.simpleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.simpleapp.ui.AppNavHost
import org.simpleapp.ui.theme.SimpleappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleappTheme {
                AppNavHost()
            }
        }
    }
}
