package org.simpleapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import org.simpleapp.R

@Composable
fun CatalogTopBar(
    onClick: (() -> Unit)? = null
) {
    Surface(color = colorResource(R.color.app_accent)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .windowInsetsPadding(WindowInsets.statusBars)
                .height(dimensionResource(R.dimen.catalog_top_bar_height))
                .padding(horizontal = dimensionResource(R.dimen.catalog_top_bar_horizontal_padding))
                .then(
                    if (onClick != null) {
                        Modifier.clickable(onClick = onClick)
                    } else {
                        Modifier
                    }
                ),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.ic_catalog_logo),
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(R.dimen.catalog_logo_size))
            )
            Spacer(
                modifier = Modifier.width(
                    dimensionResource(R.dimen.catalog_logo_title_spacing)
                )
            )
            Text(
                text = stringResource(R.string.catalog_title),
                style = MaterialTheme.typography.titleLarge,
                color = colorResource(R.color.app_on_accent)
            )
        }
    }
}
