package org.simpleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.simpleapp.ui.screen.ReceivedTextScreen
import org.simpleapp.ui.theme.SimpleappTheme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val receivedText = intent.getStringExtra(EXTRA_TEXT)
            ?.takeIf(String::isNotBlank)
            ?: getString(R.string.no_text_received)

        setContent {
            SimpleappTheme {
                ReceivedTextScreen(receivedText = receivedText)
            }
        }
    }
}
