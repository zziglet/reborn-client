package com.example.client.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.client.screen.LoginScreen
import com.example.client.screen.MainScreen
import com.example.client.screen.MainOnboardingScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = NavRoutes.Login.route
    ) {
        composable(NavRoutes.Login.route) {
            LoginScreen(navController)
        }

        composable(NavRoutes.Main.route) {
            MainScreen(navController)
        }

        composable(NavRoutes.MainOnborading.route) {
            MainOnboardingScreen("김영숙", navController)
        }

    }
}