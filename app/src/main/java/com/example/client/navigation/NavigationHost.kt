package com.example.client.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.client.screen.LoginScreen
import com.example.client.screen.MainScreen
import com.example.client.screen.MainOnboardingScreen
import com.example.client.viewmodel.MainOnBoardingViewModel

@Composable
fun NavigationHost(
    navController: NavHostController,
    mainOnBoardingViewModel: MainOnBoardingViewModel
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
            MainOnboardingScreen(
                onBoardingViewModel = mainOnBoardingViewModel,
                navController = navController
            )
        }

    }
}