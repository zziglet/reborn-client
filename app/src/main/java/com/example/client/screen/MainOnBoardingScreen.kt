package com.example.client.screen

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.client.R
import com.example.client.component.ButtonColorEnum
import com.example.client.component.ButtonComponent
import com.example.client.component.JobFieldComponent
import com.example.client.component.PageIndexComponent
import com.example.client.component.PickerComponent

@Composable
fun MainOnboardingScreen(userName: String, navController: NavController) {

    /* 카카오 로그인 시 사용자 닉네임 가져오기
    LaunchedEffect(Unit) {
        UserInfo.fetchUserInfo { user ->
            nickname = user?.nickname ?: TestUserInfo.TEST_USERNAME
        }
    }*/

    val questions = listOf(
        "현재 경제활동 상태",
        "현재 거주하는 지역",
        "관심 있는 분야"
    )

    var currentQuestionIndex by remember { mutableStateOf(0) }
    var selectedAnswer by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFBDC))
    ) {
        Row(
            modifier = Modifier.padding(start = 15.dp, top = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.icon_rebornlogo),
                contentDescription = "Icon_rebornlogo",
                modifier = Modifier
                    .width(80.dp)
                    .height(66.dp)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = Color(0xFFFFFEF4), shape = RoundedCornerShape(size = 40.dp))
        ) {
            Row(){
                Column(modifier = Modifier.padding(top = 20.dp, start = 20.dp)) {
                    Text(
                        text = "반가워요,\n",
                        fontSize = 30.sp,
                        color = Color(0xFF000000),
                        modifier = Modifier.height(35.dp),
                        fontFamily = FontFamily(Font(R.font.pretendardregular))
                    )
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(
                        text = "$userName 님!",
                        fontSize = 30.sp,
                        color = Color(0xFF000000),
                        modifier = Modifier.height(35.dp),
                        fontFamily = FontFamily(Font(R.font.pretendardextrabold))
                    )
                }
                Spacer(modifier = Modifier.size(width = 185.dp, height = 20.dp))
                PageIndexComponent(currentPage = currentQuestionIndex + 1, totalPage = questions.size)
            }
            Spacer(modifier = Modifier.size(70.dp))
            Text(
                text = questions[currentQuestionIndex],
                fontSize = 30.sp,
                modifier = Modifier
                    .height(40.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                fontFamily = FontFamily(Font(R.font.pretendardregular))
            )
            Spacer(modifier = Modifier.size(70.dp))
            when (currentQuestionIndex) {
                0 -> {
                    val jobFields = listOf("재직", "퇴직")
                    jobFields.forEach { field ->
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable {
                                    selectedAnswer = field
                                }
                                .padding(8.dp),
                        ) {
                            Text(
                                text = field,
                                fontSize = if (selectedAnswer == field) 40.sp else 32.sp,
                                modifier = Modifier
                                    .height(40.dp)
                                    .align(alignment = Alignment.CenterHorizontally),
                                fontFamily = FontFamily(Font(R.font.pretendardextrabold)),
                                color = if (selectedAnswer == field) Color(0xFF48582F) else Color(
                                    0xff979797
                                )
                            )
                            Spacer(modifier = Modifier.size(20.dp))
                        }
                    }
                }

                1 -> {
                    Box(
                        modifier = Modifier.fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally),
                        contentAlignment = Alignment.Center,
                    ){
                        PickerComponent()
                    }
                }

                2 -> {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(alignment = Alignment.CenterHorizontally),
                    ) {
                        JobFieldComponent()
                    }
                }
            }

            Spacer(modifier = Modifier.height(70.dp))

            val text = if (currentQuestionIndex < questions.size - 1) "다음 질문" else "제출"
            Column(
                modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            ) {
                ButtonComponent(
                    buttonText = text,
                    buttonColorType = if (currentQuestionIndex < questions.size - 1) ButtonColorEnum.Green else ButtonColorEnum.LightGreen,
                    onClick = {
                        if (currentQuestionIndex < questions.size - 1) {
                            currentQuestionIndex++
                        } else {
                            // todo : 컴포넌트 상태 값 받아서 마지막 질문일 경우 제출 버튼 기능 구현
                            navController.navigate("Main")
                        }
                    }
                )
            }
        }
    }
}