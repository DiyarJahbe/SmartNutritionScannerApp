package com.example.smartnutritionscannerapp.domain.usecase

import com.example.smartnutritionscannerapp.domain.model.Product
import com.example.smartnutritionscannerapp.domain.repository.ProductRepository
import javax.inject.Inject

/**
 * Use case to save a scanned product to local storage.
 */
class SaveProductUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    suspend operator fun invoke(product: Product) {
        repository.saveProduct(product)
    }
}
