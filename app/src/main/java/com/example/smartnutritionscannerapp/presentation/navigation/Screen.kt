package com.example.smartnutritionscannerapp.presentation.navigation

/**
 * Sealed class defining all navigation routes in the app.
 */
sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Home : Screen("home")
    object Scanner : Screen("scanner")
    object Product : Screen("product/{barcode}") {
        fun createRoute(barcode: String) = "product/$barcode"
    }
    object History : Screen("history")
}
