package com.example.client

import android.app.Application
import com.kakao.sdk.common.KakaoSdk

private var APP_KEY = BuildConfig.KAKAO_API_KEY;
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        // Kakao SDK 초기화
        //KakaoSdk.init(this, APP_KEY)
    }
}
