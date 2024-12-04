package com.example.client.data.api

import com.example.client.data.model.request.KakaoLoginRequest
import com.example.client.data.model.request.MainOnBoardingRequest
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @POST("users/onboarding")
    suspend fun submitOnboarding(@Body request: MainOnBoardingRequest): Response<Void>

    @GET("jobs/posts")
    suspend fun getJobList(): Response<Void>

    @POST("auth/kakao")
    fun sendKakaoToken(@Body request: KakaoLoginRequest): Call<Void>
}