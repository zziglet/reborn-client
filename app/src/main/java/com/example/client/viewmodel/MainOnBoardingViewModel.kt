package com.example.client.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.client.data.repository.MainOnboardingRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainOnBoardingViewModel(private val repository: MainOnboardingRepository) : ViewModel() {

    fun submitOnboardingData(username: String, answers: List<String>, callback: (Boolean) -> Unit) {
        viewModelScope.launch {
            try {
                val response: Response<Void> = repository.submitOnboarding(username, answers)
                callback(response.isSuccessful) // API 호출 결과에 따라 성공 여부 반환
            } catch (e: Exception) {
                callback(false) // 오류 발생 시 false 반환
            }
        }
    }
}