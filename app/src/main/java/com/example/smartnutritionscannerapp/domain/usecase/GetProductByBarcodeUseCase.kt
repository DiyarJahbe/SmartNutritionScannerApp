package com.example.smartnutritionscannerapp.domain.usecase

import com.example.smartnutritionscannerapp.domain.model.Product
import com.example.smartnutritionscannerapp.domain.repository.ProductRepository
import javax.inject.Inject

/**
 * Use case to fetch a product by its barcode.
 * Fetches from remote API with local cache fallback.
 */
class GetProductByBarcodeUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(barcode: String): Product {
        return repository.getProductByBarcode(barcode)
    }
}
