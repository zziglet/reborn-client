package com.example.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.client.data.api.RetrofitClient
import com.example.client.data.repository.MainOnBoardingRepository
import com.example.client.screen.MainOnBoardingScreen
import com.example.client.viewmodel.MainOnBoardingViewModel
import com.example.client.viewmodel.MainOnBoardingViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val apiService = RetrofitClient.instance // ApiService의 인스턴스를 생성해야 합니다.
        val repository = MainOnBoardingRepository(apiService)
        val onBoardingViewModel = ViewModelProvider(this, MainOnBoardingViewModelFactory(repository)).get(
            MainOnBoardingViewModel::class.java)

        setContent {
            StartScren()
        }
    }
}