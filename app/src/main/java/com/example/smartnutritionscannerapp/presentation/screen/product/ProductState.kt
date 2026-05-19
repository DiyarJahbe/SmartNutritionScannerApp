package com.example.smartnutritionscannerapp.presentation.screen.product

import com.example.smartnutritionscannerapp.domain.model.Product

/**
 * UI State for the Product Screen.
 */
data class ProductState(
    val product: Product? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)
