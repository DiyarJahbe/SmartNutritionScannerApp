package com.example.smartnutritionscannerapp.data.remote.dto

import com.google.gson.annotations.SerializedName

/**
 * Top-level response from OpenFoodFacts API.
 */
data class ProductResponse(
    @SerializedName("status")
    val status: Int,
    @SerializedName("product")
    val product: ProductDto?
)

/**
 * Product data transfer object mapping the relevant fields from OpenFoodFacts.
 */
data class ProductDto(
    @SerializedName("code")
    val code: String?,
    @SerializedName("product_name")
    val productName: String?,
    @SerializedName("image_url")
    val imageUrl: String?,
    @SerializedName("image_front_url")
    val imageFrontUrl: String?,
    @SerializedName("nutriments")
    val nutriments: NutrimentsDto?
)

/**
 * Nutriment values from OpenFoodFacts.
 * Values are per 100g.
 */
data class NutrimentsDto(
    @SerializedName("energy-kcal_100g")
    val energyKcal100g: Double?,
    @SerializedName("energy-kcal")
    val energyKcal: Double?,
    @SerializedName("proteins_100g")
    val proteins100g: Double?,
    @SerializedName("proteins")
    val proteins: Double?,
    @SerializedName("fat_100g")
    val fat100g: Double?,
    @SerializedName("fat")
    val fat: Double?,
    @SerializedName("carbohydrates_100g")
    val carbohydrates100g: Double?,
    @SerializedName("carbohydrates")
    val carbohydrates: Double?
)
