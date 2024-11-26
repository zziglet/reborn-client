package com.example.client.data.api

import com.example.client.data.model.request.MainOnBoardingRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("onboarding/submit")
    suspend fun submitOnboarding(@Body request: MainOnBoardingRequest): Response<Void>
}