package com.example.client.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R
import com.example.client.domain.TestUserInfo
import com.example.client.domain.UserInfo

//[todo] : 메인화면 뷰 퍼블리싱
@Composable
fun MainScreen(){
    var nickname by remember { mutableStateOf<String?>(null) }

    //[todo] : 로그인한 사용자 닉네임 가져오기
    LaunchedEffect(Unit) {
        UserInfo.fetchUserInfo { user ->
            nickname = user?.nickname ?: TestUserInfo.TEST_USERNAME
        }
    }

    Column (
        modifier = Modifier.fillMaxSize()
            .background(color = Color(0xFFFFFBDC))
    ){
        Row(
            modifier = Modifier.padding(start = 15.dp, top = 40.dp)
        ){
            Image(
                painter = painterResource(id = R.drawable.icon_rebornlogo),
                contentDescription = "Icon_rebornlogo",
                modifier = Modifier
                    .width(80.dp)
                    .height(66.dp)
            )
        }
        Row(
            modifier = Modifier.padding(top = 10.dp, start = 20.dp)
        ){
            val greetingText = buildAnnotatedString {
                append(nickname ?: "사용자")
                addStyle(
                    SpanStyle(fontFamily = FontFamily(Font(R.font.pretendardextrabold))),
                    start = 0,
                    end = (nickname?.length ?: 3)) // "님," 포함

                append("님,\n안녕하세요 !")
                addStyle(SpanStyle(fontFamily = FontFamily(Font(R.font.pretendardregular))),
                    start = (nickname?.length ?: 4) + 3,
                    end = (nickname?.length ?: 4) + 8)
            }

            Text(
                text = greetingText,
                fontSize = 33.sp,
                color = Color(0xFF000000),
            )
            Spacer(modifier = Modifier.size(80.dp))
            Image(
                painter = painterResource(id = R.drawable.btn_editprofile),
                contentDescription = "Btn_editprofile",
                modifier = Modifier
                    .width(129.dp)
                    .height(69.dp)
                    .clickable {  }
            )

        }

        //[todo] : main 기능 button 구현
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(343.dp)
                .padding(top = 25.dp)
                .background(color = Color(0xFFFFFEF4), shape = RoundedCornerShape(size = 40.dp))
        ) {
            Image(
                painter = painterResource(id = R.drawable.btn_community),
                contentDescription = "Btn_editprofile",
                modifier = Modifier
                    .padding(top=20.dp, start = 10.dp)
                    .clickable {  }
            )
            Column(

            ) {
                Image(
                    painter = painterResource(id = R.drawable.btn_job),
                    contentDescription = "Btn_job",
                    modifier = Modifier
                        .padding(top=20.dp, start = 5.dp)
                        .clickable {  }
                )
                Image(
                    painter = painterResource(id = R.drawable.btn_hobby),
                    contentDescription = "Btn_job",
                    modifier = Modifier
                        .padding(top=5.dp, start = 5.dp)
                        .clickable {  }
                )
            }
        }

        //todo : 사용자 맞춤 추천 정보 퍼블리싱 및 데이터 가져오기
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(493.dp)
                .padding(top = 25.dp)
                .background(color = Color(0xFFFFFBDC), shape = RoundedCornerShape(size = 40.dp))
        ){
            //추후에 데이터 가져올 것
            Column {
                Text(
                    text = "이런 정보는 어떠세요?",
                    fontFamily = FontFamily(Font(R.font.pretendardregular)),
                    fontSize = 30.sp,
                    color = Color(0xFF000000),
                    modifier = Modifier.padding(start = 30.dp)
                )
                Text(
                    text = "55세에 UX 디자이너 되기",
                    fontFamily = FontFamily(Font(R.font.pretendardextrabold)),
                    fontSize = 24.sp,
                    color = Color(0xFF000000),
                    modifier = Modifier.padding(start = 32.dp, top=10.dp)
                )
            }
            Icon(
                painter = painterResource(id = R.drawable.btn_chevrons_right),
                contentDescription = "Btn_chevrons",
                modifier = Modifier
                    .padding(top=43.dp, start = 5.dp)
                    .clickable {  },
                tint = Color(0xFF93B65E)
            )
        }
    }
}