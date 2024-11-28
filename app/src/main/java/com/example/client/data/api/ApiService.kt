package com.example.client.data.api

import com.example.client.data.model.request.KakaoLoginRequest
import com.example.client.data.model.request.MainOnBoardingRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/api/onboarding/save")
    suspend fun submitOnboarding(@Body request: MainOnBoardingRequest): Response<Void>

    @POST("/api/auth/kakao")
    fun sendKakaoToken(@Body request: KakaoLoginRequest): Call<Void>
}