package com.example.smartnutritionscannerapp.presentation.screen.history

import com.example.smartnutritionscannerapp.domain.model.Product

/**
 * UI State for the History Screen.
 */
data class HistoryState(
    val products: List<Product> = emptyList(),
    val isLoading: Boolean = false,
    val error: String? = null
)
