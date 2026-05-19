package com.example.smartnutritionscannerapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "products")
data class ProductEntity(
    @PrimaryKey val barcode: String,
    val name: String,
    val imageUrl: String?,
    val calories: Double,
    val protein: Double,
    val fat: Double,
    val carbs: Double,
    val healthScore: Int,
    val recommendation: String,
    val scannedAt: Long
)
