package com.example.smartnutritionscannerapp.data.remote.api

import com.example.smartnutritionscannerapp.data.remote.dto.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * Retrofit API interface for OpenFoodFacts.
 */
interface OpenFoodFactsApi {

    @GET("api/v0/product/{barcode}.json")
    suspend fun getProductByBarcode(
        @Path("barcode") barcode: String
    ): ProductResponse
}
