package com.example.simpleapp.ui.catalog

import androidx.annotation.StringRes
import com.example.simpleapp.domain.model.AppInfo

sealed interface CatalogUiState {
    data object Loading : CatalogUiState
    data class Success(val apps: List<AppInfo>) : CatalogUiState
    data class Error(@StringRes val messageRes: Int) : CatalogUiState
}
