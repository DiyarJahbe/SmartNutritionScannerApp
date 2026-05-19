package com.example.smartnutritionscannerapp.presentation.screen.scanner

/**
 * UI Events for the Scanner Screen.
 */
sealed class ScannerEvent {
    data class PermissionResult(val isGranted: Boolean) : ScannerEvent()
    data class BarcodeDetected(val barcode: String) : ScannerEvent()
    object ToggleScanning : ScannerEvent()
}
