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
import com.example.client.data.model.viewmodel.MyPageViewModel
import com.example.client.data.model.viewmodel.MyPageViewModelFactory
import com.example.client.data.model.viewmodel.mypage.EditInterestedViewModel
import com.example.client.data.model.viewmodel.mypage.EditInterestedViewModelFactory
import com.example.client.data.model.viewmodel.mypage.EditRegionViewModel
import com.example.client.data.model.viewmodel.mypage.EditRegionViewModelFactory
import com.example.client.data.repository.JobPostRepository
import com.example.client.data.repository.MyPageRepository
import com.example.client.data.repository.mypage.EditInterestedRepository
import com.example.client.data.repository.mypage.EditRegionRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val apiService = RetrofitClient.instance

        // 모든 Repository 초기화
        val repositories = AppRepositories(
            mainOnBoardingRepository = MainOnBoardingRepository(apiService),
            jobPostRepository = JobPostRepository(apiService),
            myPageRepository = MyPageRepository(apiService),
            editInterestedRepository = EditInterestedRepository(apiService),
            editRegionRepository = EditRegionRepository(apiService)
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
            myPageViewModel = ViewModelProvider(this,
                MyPageViewModelFactory(repositories.myPageRepository)
            ).get(MyPageViewModel::class.java),
            editInterestedViewModel = ViewModelProvider(this,
                EditInterestedViewModelFactory(repositories.editInterestedRepository)
            ).get(EditInterestedViewModel::class.java),
            editRegionViewModel = ViewModelProvider(this,
                EditRegionViewModelFactory(repositories.editRegionRepository)
            ).get(EditRegionViewModel::class.java),
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
    val jobPostRepository: JobPostRepository,
    val myPageRepository: MyPageRepository,
    val editInterestedRepository: EditInterestedRepository,
    val editRegionRepository: EditRegionRepository
    // 필요한 다른 repository 추가
)

// ViewModel들을 담는 데이터 클래스
data class AppViewModels(
    val mainOnBoardingViewModel: MainOnBoardingViewModel,
    val jobPostViewModel: JobPostViewModel,
    val myPageViewModel: MyPageViewModel,
    val editInterestedViewModel: EditInterestedViewModel,
    val editRegionViewModel: EditRegionViewModel
    // 필요한 다른 viewModel 추가
)