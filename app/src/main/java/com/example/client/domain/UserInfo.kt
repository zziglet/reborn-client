package com.example.client.domain

object TestUserInfo {
    var TEST_USERNAME = "김영숙"
    const val TEST_PASSWORD = "admin"
    var USERIMG = ""
    var INTEREST = listOf("")
    var REGION = ""
    var REBORNTEMPERATURE = 0
    var EMPLOYMENT = ""
}

//object UserInfo {
//    // 사용자 정보를 요청하는 함수
//    fun fetchUserInfo(callback: (User?) -> Unit) {
//        UserApiClient.instance.me { user, error ->
//            if (error != null) {
//                Log.e("UserData", "Failed to fetch user info: ${error.message}")
//                callback(null)
//            } else if (user != null) {
//                val userId = user.id
//                val nickname = user.kakaoAccount?.profile?.nickname
//                val profileImageUrl = user.kakaoAccount?.profile?.thumbnailImageUrl // 필요에 따라 추가
//
//                // User 객체 생성
//                val userInfo = userId?.let { User(it, nickname, profileImageUrl) }
//                callback(userInfo)
//            }
//        }
//    }
//}