package org.simpleapp.ui.catalog

import org.simpleapp.model.AppInfo

data class AppCatalogUiState(
    val apps: List<AppInfo> = emptyList()
)
