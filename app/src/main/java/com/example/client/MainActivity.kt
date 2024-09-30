package com.example.client

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    private lateinit var hosts: List<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //[todo] : host 변수 init

        hosts = listOf(
            "https://kauth.kakao.com/oauth/authorize", //auth
            "https://kauth.kakao.com/oauth/token", //token
            "https://kapi.kakao.com/v2/user/me")  //user info
        enableEdgeToEdge()

        //[todo] : login screen 출력
        setContent {
            LoginScreen(hosts)
        }
    }
}

