package com.example.client.data.model.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.client.data.repository.JobPostRepository
import kotlinx.coroutines.launch
import retrofit2.Response

class JobPostViewModel(private val repository: JobPostRepository) : ViewModel() {
    fun getJob(jobTitle: String,
                   companyName: String,
                   hmUrl: String,
                   workAddr: String) {
        viewModelScope.launch {
            // API 호출
            val response: Response<Void> = repository.postJobList(jobTitle, companyName, hmUrl, workAddr)
            if (response.isSuccessful) {
                // 성공적으로 제출된 경우 처리
                println("Job list : successfully!")
            } else {
                // 실패한 경우 처리
                println("Failed to job: ${response.code()}")
            }
        }
    }
}