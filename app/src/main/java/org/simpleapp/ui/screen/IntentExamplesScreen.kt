package org.simpleapp.ui.screen

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
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.simpleapp.R

@Composable
fun IntentExamplesScreen(
    input: String,
    onInputChange: (String) -> Unit,
    onOpenSecondActivity: (String) -> Unit,
    onCallFriend: (String) -> Unit,
    onShareText: (String) -> Unit,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(text = stringResource(R.string.intent_examples_title))
            OutlinedTextField(
                value = input,
                onValueChange = onInputChange,
                modifier = Modifier.fillMaxWidth(),
                label = { Text(stringResource(R.string.text_or_phone_label)) },
                supportingText = { Text(stringResource(R.string.phone_number_supporting_text)) },
                singleLine = true
            )
            Button(
                onClick = { onOpenSecondActivity(input) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.open_second_activity))
            }
            Button(
                onClick = { onCallFriend(input) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.call_friend))
            }
            Button(
                onClick = { onShareText(input) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(stringResource(R.string.share_text))
            }
        }
    }
}
