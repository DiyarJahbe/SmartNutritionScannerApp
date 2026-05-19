package com.example.smartnutritionscannerapp.presentation.screen.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartnutritionscannerapp.domain.usecase.GetHistoryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val getHistoryUseCase: GetHistoryUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HistoryState())
    val state: StateFlow<HistoryState> = _state.asStateFlow()

    init {
        loadHistory()
    }

    fun onEvent(event: HistoryEvent) {
        when (event) {
            HistoryEvent.Refresh -> loadHistory()
        }
    }

    private fun loadHistory() {
        viewModelScope.launch {
            getHistoryUseCase()
                .onStart { _state.update { it.copy(isLoading = true) } }
                .catch { e ->
                    _state.update { 
                        it.copy(
                            isLoading = false, 
                            error = e.message ?: "Failed to load history"
                        ) 
                    }
                }
                .collect { products ->
                    _state.update { it.copy(isLoading = false, products = products, error = null) }
                }
        }
    }
}
