package com.example.client

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.rememberNavController
import com.example.client.navigation.BottomNavigationBar
import com.example.client.navigation.NavigationHost
import com.example.client.viewmodel.MainOnBoardingViewModel

@Composable
fun StartScreen(onBoardingViewModel: MainOnBoardingViewModel){
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.background(color = Color.White),
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .background(color = Color.White)
        ) {
            //NavigationHost 오타 수정
            NavigationHost(navController = navController, onBoardingViewModel)
        }
    }
}