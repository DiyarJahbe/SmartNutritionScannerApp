package com.example.smartnutritionscannerapp.presentation.screen.scanner

/**
 * UI State for the Scanner Screen.
 */
data class ScannerState(
    val hasCameraPermission: Boolean = false,
    val isScanning: Boolean = true,
    val error: String? = null
)
