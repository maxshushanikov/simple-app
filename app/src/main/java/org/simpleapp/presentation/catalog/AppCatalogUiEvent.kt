package org.simpleapp.presentation.catalog

sealed interface AppCatalogUiEvent {
    data class ShowSnackbar(val messageRes: Int) : AppCatalogUiEvent
}
