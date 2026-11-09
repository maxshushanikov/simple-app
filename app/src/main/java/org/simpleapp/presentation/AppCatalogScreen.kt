package org.simpleapp.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.pluralStringResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import org.simpleapp.AppContainer
import org.simpleapp.R
import org.simpleapp.domain.model.AppInfo
import org.simpleapp.presentation.catalog.AppCatalogUiEvent
import org.simpleapp.presentation.catalog.AppCatalogViewModel
import org.simpleapp.presentation.components.AppListItem
import org.simpleapp.presentation.components.CatalogTopBar
import org.simpleapp.presentation.theme.SimpleappTheme

@Composable
fun AppCatalogScreen(
    onAppClick: (AppInfo) -> Unit = {},
    modifier: Modifier = Modifier,
    viewModel: AppCatalogViewModel = viewModel(factory = AppCatalogViewModel.factory())
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    val snackbarHostState = remember { SnackbarHostState() }
    val snackbarMessage = stringResource(R.string.toolbar_snackbar_message)

    // Channel-события: после rotation не переигрываются (в отличие от State)
    LaunchedEffect(Unit) {
        viewModel.events.collect { event ->
            when (event) {
                is AppCatalogUiEvent.ShowSnackbar -> {
                    snackbarHostState.showSnackbar(message = snackbarMessage)
                }
            }
        }
    }

    AppCatalogContent(
        apps = uiState.apps,
        onAppClick = onAppClick,
        onToolbarClick = viewModel::onToolbarClick,
        snackbarHostState = snackbarHostState,
        modifier = modifier
    )
}

@Composable
private fun AppCatalogContent(
    apps: List<AppInfo>,
    onAppClick: (AppInfo) -> Unit,
    onToolbarClick: () -> Unit,
    snackbarHostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colorResource(R.color.app_background),
        topBar = { CatalogTopBar(onClick = onToolbarClick) },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(
                horizontal = dimensionResource(R.dimen.catalog_content_horizontal_padding),
                vertical = dimensionResource(R.dimen.catalog_content_vertical_padding)
            ),
            verticalArrangement = Arrangement.spacedBy(
                dimensionResource(R.dimen.catalog_item_spacing)
            )
        ) {
            item {
                Column(
                    modifier = Modifier.padding(
                        bottom = dimensionResource(R.dimen.catalog_header_bottom_padding)
                    )
                ) {
                    Text(
                        text = stringResource(R.string.catalog_heading),
                        style = MaterialTheme.typography.headlineSmall,
                        color = colorResource(R.color.app_text_primary)
                    )
                    Spacer(
                        modifier = Modifier.height(
                            dimensionResource(R.dimen.catalog_header_subtitle_spacing)
                        )
                    )
                    Text(
                        text = pluralStringResource(
                            R.plurals.app_count,
                            apps.size,
                            apps.size
                        ),
                        style = MaterialTheme.typography.bodyMedium,
                        color = colorResource(R.color.app_text_secondary)
                    )
                }
            }
            items(
                items = apps,
                key = { app -> app.id }
            ) { app ->
                AppListItem(
                    app = app,
                    onClick = { onAppClick(app) }
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun AppCatalogScreenPreview() {
    SimpleappTheme {
        AppCatalogContent(
            apps = AppContainer.appCatalogRepository.getApps(),
            onAppClick = {},
            onToolbarClick = {},
            snackbarHostState = remember { SnackbarHostState() }
        )
    }
}
