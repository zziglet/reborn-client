package com.example.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.client.data.api.RetrofitClient
import com.example.client.data.model.viewmodel.JobPostViewModel
import com.example.client.data.model.viewmodel.JobPostViewModelFactory
import com.example.client.data.repository.MainOnBoardingRepository
import com.example.client.data.model.viewmodel.MainOnBoardingViewModel
import com.example.client.data.model.viewmodel.MainOnBoardingViewModelFactory
import com.example.client.data.repository.JobPostRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val apiService = RetrofitClient.instance

        // 모든 Repository 초기화
        val repositories = AppRepositories(
            mainOnBoardingRepository = MainOnBoardingRepository(apiService),
            jobPostRepository = JobPostRepository(apiService),
            // 필요한 다른 repository 추가
        )

        // 모든 ViewModel 초기화
        val viewModels = AppViewModels(
            mainOnBoardingViewModel = ViewModelProvider(this, 
                MainOnBoardingViewModelFactory(repositories.mainOnBoardingRepository))
                .get(MainOnBoardingViewModel::class.java),
            jobPostViewModel = ViewModelProvider(this,
                JobPostViewModelFactory(repositories.jobPostRepository)
            ).get(JobPostViewModel::class.java),
            // 필요한 다른 viewModel 추가
        )

        setContent {
            StartScreen(viewModels)
        }
    }
}

// Repository들을 담는 데이터 클래스
data class AppRepositories(
    val mainOnBoardingRepository: MainOnBoardingRepository,
    val jobPostRepository: JobPostRepository
    // 필요한 다른 repository 추가
)

// ViewModel들을 담는 데이터 클래스
data class AppViewModels(
    val mainOnBoardingViewModel: MainOnBoardingViewModel,
    val jobPostViewModel: JobPostViewModel,
    // 필요한 다른 viewModel 추가
)