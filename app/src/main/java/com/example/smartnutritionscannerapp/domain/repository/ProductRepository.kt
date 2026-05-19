package com.example.smartnutritionscannerapp.domain.repository

import com.example.smartnutritionscannerapp.domain.model.Product
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface for product data operations.
 */
interface ProductRepository {
    suspend fun getProductByBarcode(barcode: String): Product
    suspend fun saveProduct(product: Product)
    fun getHistory(): Flow<List<Product>>
}
