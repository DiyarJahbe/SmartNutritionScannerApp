package com.example.smartnutritionscannerapp.domain.model

/**
 * Domain model representing a scanned product with its nutritional information.
 */
data class Product(
    val barcode: String,
    val name: String,
    val imageUrl: String?,
    val calories: Double,
    val protein: Double,
    val fat: Double,
    val carbs: Double,
    val healthScore: Int,
    val recommendation: Recommendation,
    val scannedAt: Long
)

/**
 * Diet recommendation based on the product's health score.
 */
enum class Recommendation {
    BULKING,
    CUTTING,
    NEUTRAL
}
