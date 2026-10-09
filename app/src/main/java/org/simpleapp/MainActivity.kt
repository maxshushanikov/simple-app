package org.simpleapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.simpleapp.ui.theme.SimpleappTheme

const val EXTRA_TEXT = "org.simpleapp.EXTRA_TEXT"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SimpleappTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    IntentExamplesScreen(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
private fun IntentExamplesScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current
    var input by rememberSaveable { mutableStateOf("") }
    val trimmedInput = input.trim()

    Column(
        modifier = modifier
            .verticalScroll(rememberScrollState())
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Примеры Intent")
        OutlinedTextField(
            value = input,
            onValueChange = { input = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Текст или номер телефона") },
            supportingText = { Text("Для звонка введите номер телефона") },
            singleLine = true
        )
        Button(
            onClick = {
                if (trimmedInput.isEmpty()) {
                    Toast.makeText(context, "Введите текст", Toast.LENGTH_SHORT).show()
                } else {
                    context.startActivity(
                        Intent(context, SecondActivity::class.java)
                            .putExtra(EXTRA_TEXT, trimmedInput)
                    )
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Открыть вторую Activity")
        }
        Button(
            onClick = {
                if (!isValidPhoneNumber(trimmedInput)) {
                    Toast.makeText(context, "Введите корректный номер телефона", Toast.LENGTH_SHORT)
                        .show()
                } else {
                    val dialIntent = Intent(
                        Intent.ACTION_DIAL,
                        Uri.fromParts("tel", trimmedInput, null)
                    )
                    try {
                        context.startActivity(dialIntent)
                    } catch (_: ActivityNotFoundException) {
                        Toast.makeText(
                            context,
                            "Не найдено приложение для звонков",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Позвонить другу")
        }
        Button(
            onClick = {
                if (trimmedInput.isEmpty()) {
                    Toast.makeText(context, "Введите текст для отправки", Toast.LENGTH_SHORT).show()
                } else {
                    val sendIntent = Intent(Intent.ACTION_SEND).apply {
                        type = "text/plain"
                        putExtra(Intent.EXTRA_TEXT, trimmedInput)
                    }
                    context.startActivity(Intent.createChooser(sendIntent, "Поделиться через…"))
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Поделиться текстом")
        }
    }
}

private fun isValidPhoneNumber(value: String): Boolean {
    return value.isNotEmpty() &&
        value.any(Char::isDigit) &&
        value.matches(Regex("""^[+]?[0-9().,;*#\-\s]+$"""))
}

@Preview(showBackground = true)
@Composable
private fun IntentExamplesPreview() {
    SimpleappTheme {
        IntentExamplesScreen()
    }
}
