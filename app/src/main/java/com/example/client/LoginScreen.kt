package com.example.client

import android.content.Context
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.platform.LocalContext
import com.kakao.sdk.user.UserApiClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST

//데이터 모델
data class KakaoLoginRequest(
    val accessToken: String,
    val userId: Long,
    val nickname: String?
)

//api 호출 -> POST request
interface ApiService {
    @POST("auth/kakao")
    fun sendKakaoToken(@Body request: KakaoLoginRequest): Call<Void>
}

object RetrofitClient {
    private const val BASE_URL = "http://localhost:3000" // 서버 URL

    val instance: ApiService by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        retrofit.create(ApiService::class.java)
    }
}

//[todo] : login view 출력 -> 추후에 screen package로 이동할 예정
@Composable
fun LoginScreen(hosts: List<String>) {
    // LocalContext를 사용하여 현재 Context 가져오기
    val context = LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Button(
            onClick = { loginWithKakao(context, hosts) },
        ) {
            Text("카카오 로그인")
        }
    }
}

//[todo] : 카카오톡으로 로그인 요청(에뮬레이터에 카카오톡 어플 설치 및 로그인 필요)
private fun loginWithKakao(context: Context, hosts: List<String>) {
    UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
        if (error != null) {
            Log.e("Login", "Login Failed: ${error.message}")
        } else if (token != null) {
            fetchUserInfo(token.accessToken, hosts[2]) // user info URL
        }
    }
}

//[todo] : 로그인 성공 시 사용자 정보 요청
private fun fetchUserInfo(accessToken: String, userInfoUrl: String) {
    UserApiClient.instance.me { user, error ->
        if (error != null) {
            Log.e("UserInfo", "Failed to fetch user info: ${error.message}")
        } else if (user != null) {
            val userId = user.id
            val nickname = user.kakaoAccount?.profile?.nickname
            sendTokenToServer(accessToken, userId, nickname)
        }
    }
}

//[todo] : 서버에 access 토큰 전송
private fun sendTokenToServer(accessToken: String, userId: Long?, nickname: String?) {
    val request = userId?.let { KakaoLoginRequest(accessToken, it, nickname) }

    if (request != null) {
        RetrofitClient.instance.sendKakaoToken(request).enqueue(object : retrofit2.Callback<Void> {
            override fun onResponse(call: Call<Void>, response: retrofit2.Response<Void>) {
                if (response.isSuccessful) {
                    Log.d("TokenSend", "Token sent successfully!")
                } else {
                    Log.e("TokenSend", "Failed to send token: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Log.e("TokenSend", "Network error: ${t.message}")
            }
        })
    }
}





