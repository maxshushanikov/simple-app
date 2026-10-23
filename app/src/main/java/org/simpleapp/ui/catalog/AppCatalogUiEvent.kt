package org.simpleapp.ui.catalog

sealed interface AppCatalogUiEvent {
    data class ShowSnackbar(val messageRes: Int) : AppCatalogUiEvent
}
