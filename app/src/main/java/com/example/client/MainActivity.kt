package com.example.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.client.data.api.RetrofitClient
<<<<<<< HEAD
<<<<<<< HEAD
import com.example.client.data.model.viewmodel.JobPostLicenseViewModel
import com.example.client.data.model.viewmodel.JobPostLicenseViewModelFactory
import com.example.client.data.model.viewmodel.JobOnBoardingViewModel
import com.example.client.data.model.viewmodel.JobOnBoardingViewModelFactory
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
import com.example.client.data.model.viewmodel.JobPostViewModel
import com.example.client.data.model.viewmodel.JobPostViewModelFactory
import com.example.client.data.repository.MainOnBoardingRepository
import com.example.client.data.model.viewmodel.MainOnBoardingViewModel
import com.example.client.data.model.viewmodel.MainOnBoardingViewModelFactory
import com.example.client.data.model.viewmodel.MyPageViewModel
import com.example.client.data.model.viewmodel.MyPageViewModelFactory
import com.example.client.data.model.viewmodel.mypage.EditInterestedViewModel
import com.example.client.data.model.viewmodel.mypage.EditInterestedViewModelFactory
import com.example.client.data.model.viewmodel.mypage.EditProfileViewModel
import com.example.client.data.model.viewmodel.mypage.EditProfileViewModelFactory
import com.example.client.data.model.viewmodel.mypage.EditRegionViewModel
import com.example.client.data.model.viewmodel.mypage.EditRegionViewModelFactory
import com.example.client.data.repository.JobPostLicenseRepository
import com.example.client.data.repository.JobPostRepository
import com.example.client.data.repository.MyPageRepository
import com.example.client.data.repository.mypage.EditInterestedRepository
import com.example.client.data.repository.mypage.EditProfileRepository
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
<<<<<<< HEAD
<<<<<<< HEAD
            jobPostLicenseRepository = JobPostLicenseRepository(apiService),
            jobOnBoardingRepository = JobOnBoardingRepository(apiService),
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
            myPageRepository = MyPageRepository(apiService),
            editInterestedRepository = EditInterestedRepository(apiService),
            editRegionRepository = EditRegionRepository(apiService),
            editProfileRepository = EditProfileRepository(apiService),
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
<<<<<<< HEAD
<<<<<<< HEAD
            jobPostLicenseViewModel = ViewModelProvider(this,
                JobPostLicenseViewModelFactory(repositories.jobPostLicenseRepository)
            ).get(JobPostLicenseViewModel::class.java),
            jobOnBoardingViewModel = ViewModelProvider(
                this,
                JobOnBoardingViewModelFactory(repositories.jobOnBoardingRepository)
            ).get(JobOnBoardingViewModel::class.java),
            sharedCertificationViewModel = ViewModelProvider(
                this,
                SharedCertificationViewModelFactory(repositories.jobOnBoardingRepository)
            ).get(SharedCertificationViewModel::class.java),
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
            myPageViewModel = ViewModelProvider(this,
                MyPageViewModelFactory(repositories.myPageRepository)
            ).get(MyPageViewModel::class.java),
            editInterestedViewModel = ViewModelProvider(this,
                EditInterestedViewModelFactory(repositories.editInterestedRepository)
            ).get(EditInterestedViewModel::class.java),
            editRegionViewModel = ViewModelProvider(this,
                EditRegionViewModelFactory(repositories.editRegionRepository)
            ).get(EditRegionViewModel::class.java),
            editProfileViewModel = ViewModelProvider(this,
                EditProfileViewModelFactory(repositories.editProfileRepository)
            ).get(EditProfileViewModel::class.java),
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
<<<<<<< HEAD
<<<<<<< HEAD
    val jobPostLicenseRepository: JobPostLicenseRepository,
    val jobOnBoardingRepository: JobOnBoardingRepository,
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
    val myPageRepository: MyPageRepository,
    val editInterestedRepository: EditInterestedRepository,
    val editRegionRepository: EditRegionRepository,
    val editProfileRepository: EditProfileRepository
    // 필요한 다른 repository 추가
)

// ViewModel들을 담는 데이터 클래스
data class AppViewModels(
    val mainOnBoardingViewModel: MainOnBoardingViewModel,
    val jobPostViewModel: JobPostViewModel,
<<<<<<< HEAD
<<<<<<< HEAD
    val jobPostLicenseViewModel: JobPostLicenseViewModel,
    val jobOnBoardingViewModel: JobOnBoardingViewModel,
    val sharedCertificationViewModel: SharedCertificationViewModel,
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
=======
>>>>>>> parent of 619281e (Merge pull request #37 from Grades5-6/feature/work-onboarding)
    val myPageViewModel: MyPageViewModel,
    val editInterestedViewModel: EditInterestedViewModel,
    val editRegionViewModel: EditRegionViewModel,
    val editProfileViewModel: EditProfileViewModel,
    // 필요한 다른 viewModel 추가
)