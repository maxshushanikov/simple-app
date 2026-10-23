package org.simpleapp.ui.catalog

/**
 * Одноразовые события UI (не переживают поворот экрана как состояние).
 */
sealed interface AppCatalogUiEvent {
    data class ShowSnackbar(val messageRes: Int) : AppCatalogUiEvent
}
