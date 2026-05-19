package com.example.smartnutritionscannerapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.smartnutritionscannerapp.presentation.screen.history.HistoryScreen
import com.example.smartnutritionscannerapp.presentation.screen.home.HomeScreen
import com.example.smartnutritionscannerapp.presentation.screen.product.ProductScreen
import com.example.smartnutritionscannerapp.presentation.screen.scanner.ScannerScreen
import com.example.smartnutritionscannerapp.presentation.screen.splash.SplashScreen

/**
 * Main navigation graph for the app.
 */
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Splash.route
    ) {
        composable(Screen.Splash.route) {
            SplashScreen(
                onSplashFinished = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        composable(Screen.Home.route) {
            HomeScreen(
                onScanClick = {
                    navController.navigate(Screen.Scanner.route)
                },
                onHistoryClick = {
                    navController.navigate(Screen.History.route)
                }
            )
        }

        composable(Screen.Scanner.route) {
            ScannerScreen(
                onProductScanned = { barcode ->
                    navController.navigate(Screen.Product.createRoute(barcode)) {
                        popUpTo(Screen.Scanner.route) { inclusive = true }
                    }
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable(
            route = Screen.Product.route,
            arguments = listOf(
                navArgument("barcode") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val barcode = backStackEntry.arguments?.getString("barcode") ?: ""
            ProductScreen(
                barcode = barcode,
                onBackClick = {
                    navController.navigate(Screen.Home.route) {
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                onScanAgainClick = {
                    navController.navigate(Screen.Scanner.route) {
                        popUpTo(Screen.Home.route)
                    }
                }
            )
        }

        composable(Screen.History.route) {
            HistoryScreen(
                onProductClick = { barcode ->
                    navController.navigate(Screen.Product.createRoute(barcode))
                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
