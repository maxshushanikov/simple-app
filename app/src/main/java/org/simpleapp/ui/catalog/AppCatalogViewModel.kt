package org.simpleapp.ui.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.simpleapp.R
import org.simpleapp.data.AppCatalogRepository
import org.simpleapp.model.AppInfo

class AppCatalogViewModel(
    private val repository: AppCatalogRepository = AppCatalogRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(AppCatalogUiState())
    val uiState: StateFlow<AppCatalogUiState> = _uiState.asStateFlow()

    private val _events = Channel<AppCatalogUiEvent>(Channel.BUFFERED)
    val events = _events.receiveAsFlow()

    init {
        loadApps()
    }

    private fun loadApps() {
        _uiState.update { it.copy(apps = repository.apps) }
    }

    fun onToolbarClick() {
        viewModelScope.launch {
            _events.send(AppCatalogUiEvent.ShowSnackbar(R.string.toolbar_snackbar_message))
        }
    }

    companion object {
        fun factory(
            repository: AppCatalogRepository = AppCatalogRepository
        ): ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(AppCatalogViewModel::class.java)) {
                    return AppCatalogViewModel(repository) as T
                }
                throw IllegalArgumentException("Unknown ViewModel class: $modelClass")
            }
        }
    }
}
