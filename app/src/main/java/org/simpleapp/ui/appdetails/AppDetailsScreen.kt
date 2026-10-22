package org.simpleapp.ui.appdetails

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.simpleapp.R
import org.simpleapp.data.AppCatalogRepository
import org.simpleapp.model.AppInfo

/**
 * Карточка приложения (на основе экрана из практического репозитория VkEducation).
 * Внизу — отдельный UI-блок «Витрина» с HorizontalPager.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppDetailsScreen(
    app: AppInfo,
    onBackClick: () -> Unit,
    onShowcaseAppClick: (AppInfo) -> Unit,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = colorResource(R.color.app_background),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(app.nameRes),
                        color = colorResource(R.color.app_on_accent)
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = stringResource(R.string.back),
                            tint = colorResource(R.color.app_on_accent)
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(R.color.app_accent)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            // --- Header карточки (в стиле практики) ---
            AppDetailsHeader(app = app)

            Spacer(modifier = Modifier.height(16.dp))

            // Кнопка «Установить»
            Button(
                onClick = { /* no-op for homework */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = dimensionResource(R.dimen.catalog_content_horizontal_padding)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.app_accent)
                ),
                shape = RoundedCornerShape(12.dp)
            ) {
                Text(text = stringResource(R.string.install))
            }

            Spacer(modifier = Modifier.height(24.dp))

            // --- Блок «Витрина» в самом низу карточки ---
            ShowcaseBlock(
                apps = AppCatalogRepository.showcaseApps,
                onAppClick = onShowcaseAppClick,
                modifier = Modifier.padding(bottom = 24.dp)
            )
        }
    }
}

@Composable
private fun AppDetailsHeader(
    app: AppInfo,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                horizontal = dimensionResource(R.dimen.catalog_content_horizontal_padding),
                vertical = 16.dp
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(96.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(colorResource(app.iconBackgroundRes)),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(app.iconRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = stringResource(app.categoryRes),
                style = MaterialTheme.typography.labelMedium,
                color = colorResource(R.color.app_accent)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(app.nameRes),
                style = MaterialTheme.typography.headlineSmall,
                color = colorResource(R.color.app_text_primary)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = stringResource(app.descriptionRes),
                style = MaterialTheme.typography.bodyMedium,
                color = colorResource(R.color.app_text_secondary)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Surface(
                shape = CircleShape,
                color = colorResource(R.color.app_surface_variant)
            ) {
                Text(
                    text = stringResource(app.categoryRes),
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 5.dp),
                    style = MaterialTheme.typography.labelMedium,
                    color = colorResource(R.color.app_accent)
                )
            }
        }
    }
}
