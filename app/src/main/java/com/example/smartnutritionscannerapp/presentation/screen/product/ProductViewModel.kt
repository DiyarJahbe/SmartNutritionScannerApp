package com.example.smartnutritionscannerapp.presentation.screen.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartnutritionscannerapp.domain.usecase.GetProductByBarcodeUseCase
import com.example.smartnutritionscannerapp.domain.usecase.SaveProductUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val getProductByBarcodeUseCase: GetProductByBarcodeUseCase,
    private val saveProductUseCase: SaveProductUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ProductState())
    val state: StateFlow<ProductState> = _state.asStateFlow()

    private var currentBarcode: String? = null

    fun onEvent(event: ProductEvent) {
        when (event) {
            is ProductEvent.LoadProduct -> {
                currentBarcode = event.barcode
                fetchProduct(event.barcode)
            }
            ProductEvent.Refresh -> {
                currentBarcode?.let { fetchProduct(it) }
            }
        }
    }

    private fun fetchProduct(barcode: String) {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val product = getProductByBarcodeUseCase(barcode)
                // Auto-save to history
                saveProductUseCase(product)
                _state.update { it.copy(isLoading = false, product = product) }
            } catch (e: Exception) {
                _state.update { 
                    it.copy(
                        isLoading = false, 
                        error = e.message ?: "An unexpected error occurred"
                    ) 
                }
            }
        }
    }
}
