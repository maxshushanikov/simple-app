package org.simpleapp.ui.catalog

import org.simpleapp.model.AppInfo

/**
 * Состояние экрана каталога. Хранится во ViewModel и переживает configuration change.
 */
data class AppCatalogUiState(
    val apps: List<AppInfo> = emptyList()
)
