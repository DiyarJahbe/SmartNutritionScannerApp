package com.example.smartnutritionscannerapp.data.repository

import com.example.smartnutritionscannerapp.data.local.dao.ProductDao
import com.example.smartnutritionscannerapp.data.mapper.toDomain
import com.example.smartnutritionscannerapp.data.mapper.toEntity
import com.example.smartnutritionscannerapp.data.remote.api.OpenFoodFactsApi
import com.example.smartnutritionscannerapp.domain.model.Product
import com.example.smartnutritionscannerapp.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

/**
 * Repository implementation that fetches from API with local cache fallback.
 */
class ProductRepositoryImpl @Inject constructor(
    private val api: OpenFoodFactsApi,
    private val dao: ProductDao
) : ProductRepository {

    /**
     * Fetches product by barcode from API, caches it locally.
     * Falls back to local cache if API call fails.
     */
    override suspend fun getProductByBarcode(barcode: String): Product {
        return try {
            val response = api.getProductByBarcode(barcode)
            if (response.status == 1 && response.product != null) {
                val product = response.product.toDomain(barcode)
                // Cache to local storage
                dao.insertProduct(product.toEntity())
                product
            } else {
                // Product not found on API, try local cache
                dao.getProductByBarcode(barcode)?.toDomain()
                    ?: throw Exception("Product not found for barcode: $barcode")
            }
        } catch (e: Exception) {
            // Network error — fallback to local cache
            val cached = dao.getProductByBarcode(barcode)?.toDomain()
            if (cached != null) {
                cached
            } else {
                throw Exception("Product not found. Check your internet connection.")
            }
        }
    }

    override suspend fun saveProduct(product: Product) {
        dao.insertProduct(product.toEntity())
    }

    override fun getHistory(): Flow<List<Product>> {
        return dao.getAllProducts().map { entities ->
            entities.map { it.toDomain() }
        }
    }
}
