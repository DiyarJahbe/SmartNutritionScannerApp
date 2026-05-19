package com.example.smartnutritionscannerapp.presentation.screen.product

/**
 * UI Events for the Product Screen.
 */
sealed class ProductEvent {
    data class LoadProduct(val barcode: String) : ProductEvent()
    object Refresh : ProductEvent()
}
