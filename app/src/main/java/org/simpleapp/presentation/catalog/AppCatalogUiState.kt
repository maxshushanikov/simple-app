package org.simpleapp.presentation.catalog

import org.simpleapp.domain.model.AppInfo

data class AppCatalogUiState(
    val apps: List<AppInfo> = emptyList()
)
