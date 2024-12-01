package com.example.client.navigation

sealed class NavRoutes(val route: String) {
    object Main : NavRoutes("Main")

    object Login : NavRoutes("Login")
    object MainOnborading : NavRoutes("MainOnboarding")
}