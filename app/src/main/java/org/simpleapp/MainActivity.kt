package org.simpleapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import org.simpleapp.ui.screen.IntentExamplesScreen
import org.simpleapp.ui.theme.SimpleappTheme
import org.simpleapp.validation.PhoneNumberValidator

const val EXTRA_TEXT = "org.simpleapp.EXTRA_TEXT"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleappTheme {
                var input by rememberSaveable { mutableStateOf("") }
                val snackbarHostState = remember { SnackbarHostState() }
                val coroutineScope = rememberCoroutineScope()

                fun showMessage(messageResId: Int) {
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(getString(messageResId))
                    }
                }

                IntentExamplesScreen(
                    input = input,
                    onInputChange = { input = it },
                    snackbarHostState = snackbarHostState,
                    onOpenSecondActivity = { value ->
                        openSecondActivity(value)?.let(::showMessage)
                    },
                    onCallFriend = { value ->
                        callFriend(value)?.let(::showMessage)
                    },
                    onShareText = { value ->
                        shareText(value)?.let(::showMessage)
                    }
                )
            }
        }
    }

    private fun openSecondActivity(value: String): Int? {
        val text = value.trim()
        if (text.isEmpty()) {
            return R.string.enter_text
        }

        startActivity(
            Intent(this, SecondActivity::class.java)
                .putExtra(EXTRA_TEXT, text)
        )
        return null
    }

    private fun callFriend(value: String): Int? {
        val phoneNumber = value.trim()
        if (!PhoneNumberValidator.isValid(phoneNumber)) {
            return R.string.invalid_phone_number
        }

        val dialIntent = Intent(
            Intent.ACTION_DIAL,
            Uri.fromParts("tel", phoneNumber, null)
        )
        try {
            startActivity(dialIntent)
        } catch (_: ActivityNotFoundException) {
            return R.string.dialer_not_found
        }
        return null
    }

    private fun shareText(value: String): Int? {
        val text = value.trim()
        if (text.isEmpty()) {
            return R.string.enter_text_to_share
        }

        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, text)
        }
        startActivity(Intent.createChooser(sendIntent, getString(R.string.share_via)))
        return null
    }
}
