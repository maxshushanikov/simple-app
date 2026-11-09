package com.example.simpleapp.ui.catalog

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.simpleapp.R
import com.example.simpleapp.data.repository.AppRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class CatalogViewModel @Inject constructor(
    // Интерфейс; через Hilt подставляется AppRepositoryImpl
    private val repository: AppRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow<CatalogUiState>(CatalogUiState.Loading)
    val uiState: StateFlow<CatalogUiState> = _uiState.asStateFlow()

    init {
        loadCatalog()
    }

    fun loadCatalog() {
        _uiState.value = CatalogUiState.Loading
        viewModelScope.launch {
            repository.getCatalog()
                .onSuccess { _uiState.value = CatalogUiState.Success(it) }
                .onFailure { _uiState.value = CatalogUiState.Error(it.toMessageRes()) }
        }
    }

    private fun Throwable.toMessageRes(): Int = when (this) {
        is IOException -> R.string.error_network
        is HttpException -> R.string.error_server
        else -> R.string.error_unknown
    }
}
