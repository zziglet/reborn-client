package com.example.client.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.client.AppViewModels
import com.example.client.screen.JobMainScreen
import com.example.client.screen.JobOnBoardingScreen
import com.example.client.screen.LoginScreen
import com.example.client.screen.MainScreen
import com.example.client.screen.MainOnboardingScreen
import com.example.client.screen.MyPageScreen

@Composable
fun NavigationHost(
    navController: NavHostController,
    viewModels: AppViewModels
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

        composable(NavRoutes.MainOnboarding.route) {
            MainOnboardingScreen(
                mainOnBoardingViewModel = viewModels.mainOnBoardingViewModel,
                navController = navController
            )
        }

        composable(NavRoutes.JobMain.route) {
            JobMainScreen(
                jobPostViewModel = viewModels.jobPostViewModel,
                navController = navController
            )
        }

        composable(NavRoutes.MyPage.route) {
            MyPageScreen(
                sharedCertificationViewModel = viewModels.sharedCertificationViewModel,
                navController = navController)
        }

        composable(NavRoutes.JobOnboarding.route){
            JobOnBoardingScreen(
                sharedViewModel = viewModels.sharedCertificationViewModel,
                viewModel = viewModels.jobOnBoardingViewModel,
                navController = navController
            )
        }

    }
}