package com.example.smartnutritionscannerapp.presentation.screen.scanner

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ScannerViewModel @Inject constructor() : ViewModel() {

    private val _state = MutableStateFlow(ScannerState())
    val state: StateFlow<ScannerState> = _state.asStateFlow()

    fun onEvent(event: ScannerEvent) {
        when (event) {
            is ScannerEvent.PermissionResult -> {
                _state.update { it.copy(hasCameraPermission = event.isGranted) }
            }
            is ScannerEvent.BarcodeDetected -> {
                // Handle barcode detection if needed (e.g. stop scanning)
                _state.update { it.copy(isScanning = false) }
            }
            ScannerEvent.ToggleScanning -> {
                _state.update { it.copy(isScanning = !it.isScanning) }
            }
        }
    }
}
