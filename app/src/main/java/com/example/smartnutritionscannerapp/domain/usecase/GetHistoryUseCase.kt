package com.example.smartnutritionscannerapp.domain.usecase

import com.example.smartnutritionscannerapp.domain.model.Product
import com.example.smartnutritionscannerapp.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * Use case to retrieve the scan history from local storage.
 */
class GetHistoryUseCase @Inject constructor(
    private val repository: ProductRepository
) {
    operator fun invoke(): Flow<List<Product>> {
        return repository.getHistory()
    }
}
