package com.example.client.data.repository

import com.example.client.data.api.ApiService
import retrofit2.Response

class JobPostRepository(private val apiService: ApiService) {
    // 온보딩 데이터를 제출하는 메서드
    suspend fun postJobList(
        jobTitle: String,
        companyName: String,
        hmUrl: String,
        workAddr: String
    ): Response<Void> {
        // API 호출
        return apiService.getJobList()
    }
}