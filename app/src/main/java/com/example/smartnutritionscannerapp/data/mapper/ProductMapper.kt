package com.example.smartnutritionscannerapp.data.mapper

import com.example.smartnutritionscannerapp.data.local.entity.ProductEntity
import com.example.smartnutritionscannerapp.data.remote.dto.ProductDto
import com.example.smartnutritionscannerapp.domain.model.Product
import com.example.smartnutritionscannerapp.domain.model.Recommendation

/**
 * Maps DTOs and entities to/from domain models.
 * Contains the health score calculation and recommendation business logic.
 */

/**
 * Maps a ProductDto from the API to a domain Product.
 * Calculates health score and recommendation.
 */
fun ProductDto.toDomain(barcode: String): Product {
    val calories = nutriments?.energyKcal100g
        ?: nutriments?.energyKcal
        ?: 0.0
    val protein = nutriments?.proteins100g
        ?: nutriments?.proteins
        ?: 0.0
    val fat = nutriments?.fat100g
        ?: nutriments?.fat
        ?: 0.0
    val carbs = nutriments?.carbohydrates100g
        ?: nutriments?.carbohydrates
        ?: 0.0

    val healthScore = calculateHealthScore(calories, protein, fat, carbs)
    val recommendation = determineRecommendation(healthScore)

    return Product(
        barcode = code ?: barcode,
        name = productName ?: "Unknown Product",
        imageUrl = imageFrontUrl ?: imageUrl,
        calories = calories,
        protein = protein,
        fat = fat,
        carbs = carbs,
        healthScore = healthScore,
        recommendation = recommendation,
        scannedAt = System.currentTimeMillis()
    )
}

/**
 * Maps a domain Product to a Room ProductEntity.
 */
fun Product.toEntity(): ProductEntity {
    return ProductEntity(
        barcode = barcode,
        name = name,
        imageUrl = imageUrl,
        calories = calories,
        protein = protein,
        fat = fat,
        carbs = carbs,
        healthScore = healthScore,
        recommendation = recommendation.name,
        scannedAt = scannedAt
    )
}

/**
 * Maps a Room ProductEntity to a domain Product.
 */
fun ProductEntity.toDomain(): Product {
    return Product(
        barcode = barcode,
        name = name,
        imageUrl = imageUrl,
        calories = calories,
        protein = protein,
        fat = fat,
        carbs = carbs,
        healthScore = healthScore,
        recommendation = try {
            Recommendation.valueOf(recommendation)
        } catch (e: Exception) {
            Recommendation.NEUTRAL
        },
        scannedAt = scannedAt
    )
}

/**
 * Calculates a health score from 0 to 100 based on nutritional values per 100g.
 */
private fun calculateHealthScore(
    calories: Double,
    protein: Double,
    fat: Double,
    carbs: Double
): Int {
    var score = 50.0
    score += (protein * 1.0).coerceAtMost(25.0)
    if (calories > 100) {
        score -= ((calories - 100) / 20.0).coerceAtMost(25.0)
    } else {
        score += 10.0
    }
    if (fat > 10) {
        score -= ((fat - 10) / 5.0).coerceAtMost(20.0)
    } else {
        score += 5.0
    }
    if (carbs > 50) {
        score -= ((carbs - 50) / 10.0).coerceAtMost(15.0)
    }
    return score.toInt().coerceIn(0, 100)
}

/**
 * Determines diet recommendation based on health score.
 */
private fun determineRecommendation(healthScore: Int): Recommendation {
    return when {
        healthScore >= 70 -> Recommendation.CUTTING
        healthScore <= 40 -> Recommendation.BULKING
        else -> Recommendation.NEUTRAL
    }
}
