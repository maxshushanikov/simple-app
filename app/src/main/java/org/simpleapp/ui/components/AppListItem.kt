package org.simpleapp.ui.components

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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import org.simpleapp.R
import org.simpleapp.model.AppInfo

@Composable
fun AppListItem(app: AppInfo) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(dimensionResource(R.dimen.app_card_corner_radius)),
        colors = CardDefaults.cardColors(
            containerColor = colorResource(R.color.app_surface)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = dimensionResource(R.dimen.app_card_elevation)
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.app_card_content_padding)),
            verticalAlignment = Alignment.Top
        ) {
            Box(
                modifier = Modifier
                    .size(dimensionResource(R.dimen.app_icon_size))
                    .clip(RoundedCornerShape(dimensionResource(R.dimen.app_icon_corner_radius)))
                    .background(colorResource(app.iconBackgroundRes)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(app.iconRes),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(dimensionResource(R.dimen.app_icon_inner_padding))
                )
            }
            Spacer(
                modifier = Modifier.width(
                    dimensionResource(R.dimen.app_icon_content_spacing)
                )
            )
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = stringResource(app.nameRes),
                    style = MaterialTheme.typography.titleMedium,
                    color = colorResource(R.color.app_text_primary)
                )
                Spacer(
                    modifier = Modifier.height(
                        dimensionResource(R.dimen.app_name_description_spacing)
                    )
                )
                Text(
                    text = stringResource(app.descriptionRes),
                    style = MaterialTheme.typography.bodySmall,
                    color = colorResource(R.color.app_text_secondary)
                )
                Spacer(
                    modifier = Modifier.height(
                        dimensionResource(R.dimen.app_description_category_spacing)
                    )
                )
                Surface(
                    shape = CircleShape,
                    color = colorResource(R.color.app_surface_variant)
                ) {
                    Text(
                        text = stringResource(app.categoryRes),
                        modifier = Modifier.padding(
                            horizontal = dimensionResource(R.dimen.app_category_horizontal_padding),
                            vertical = dimensionResource(R.dimen.app_category_vertical_padding)
                        ),
                        style = MaterialTheme.typography.labelMedium,
                        color = colorResource(R.color.app_accent)
                    )
                }
            }
        }
    }
}
