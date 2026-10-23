package org.simpleapp.ui.appdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import org.simpleapp.R
import org.simpleapp.model.AppInfo
import org.simpleapp.ui.components.AppListItem


@Composable
fun ShowcaseBlock(
    apps: List<AppInfo>,
    onAppClick: (AppInfo) -> Unit,
    modifier: Modifier = Modifier
) {
    val pageCount = 3
    val appsPerPage = 3
    val pagerState = rememberPagerState(pageCount = { pageCount })

    Column(modifier = modifier.fillMaxWidth()) {
        Text(
            text = stringResource(R.string.showcase_title),
            style = MaterialTheme.typography.headlineSmall,
            color = colorResource(R.color.app_text_primary),
            modifier = Modifier.padding(horizontal = dimensionResource(R.dimen.catalog_content_horizontal_padding))
        )
        Spacer(modifier = Modifier.height(12.dp))

        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(
                horizontal = dimensionResource(R.dimen.catalog_content_horizontal_padding)
            ),
            pageSpacing = 12.dp,
            modifier = Modifier.fillMaxWidth()
        ) { page ->
            val startIndex = page * appsPerPage
            val pageApps = apps.drop(startIndex).take(appsPerPage)

            Column(
                verticalArrangement = Arrangement.spacedBy(
                    dimensionResource(R.dimen.catalog_item_spacing)
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                pageApps.forEach { app ->
                    AppListItem(
                        app = app,
                        onClick = { onAppClick(app) }
                    )
                }
            }
        }
    }
}
