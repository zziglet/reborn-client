package com.example.client.navigation

sealed class NavRoutes(val route: String) {
    object Main : NavRoutes("Main")
    object Login : NavRoutes("Login")
    object MainOnboarding : NavRoutes("MainOnboarding")
    object JobMain : NavRoutes("JobMain")
    object MyPage : NavRoutes("MyPage")
}