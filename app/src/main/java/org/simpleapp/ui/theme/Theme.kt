package org.simpleapp.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.colorResource
import org.simpleapp.R

@Composable
fun SimpleappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val accent = colorResource(R.color.app_accent)
    val onAccent = colorResource(R.color.app_on_accent)
    val background = colorResource(R.color.app_background)
    val surface = colorResource(R.color.app_surface)
    val surfaceVariant = colorResource(R.color.app_surface_variant)
    val primaryText = colorResource(R.color.app_text_primary)
    val secondaryText = colorResource(R.color.app_text_secondary)

    val colorScheme = if (darkTheme) {
        darkColorScheme(
            primary = accent,
            onPrimary = onAccent,
            secondary = secondaryText,
            background = background,
            onBackground = primaryText,
            surface = surface,
            onSurface = primaryText,
            surfaceVariant = surfaceVariant,
            onSurfaceVariant = secondaryText
        )
    } else {
        lightColorScheme(
            primary = accent,
            onPrimary = onAccent,
            secondary = secondaryText,
            background = background,
            onBackground = primaryText,
            surface = surface,
            onSurface = primaryText,
            surfaceVariant = surfaceVariant,
            onSurfaceVariant = secondaryText
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}