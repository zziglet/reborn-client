package com.example.client.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R
import com.example.client.component.ButtonColorEnum
import com.example.client.component.ButtonComponent
import com.example.client.component.JobFieldComponent
import com.example.client.domain.TestUserInfo

@Composable
fun MyPageScreen() {
    var nickname by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        nickname = TestUserInfo.TEST_USERNAME
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFEF4))
    ) {
        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color(0xFFFFFBDC))
            ) {
                Row(
                    modifier = Modifier.padding(start = 15.dp, top = 50.dp)
                ) {
                    Text(
                        text = "내 정보",
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 33.6.sp,
                            fontFamily = FontFamily(Font(R.font.pretendardextrabold)),
                            color = Color(0xFF000000),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }

        item {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.rounded_edit_square_24),
                        contentDescription = null,
                        modifier = Modifier.padding(8.dp)
                    )
                    Text("를 누르면 편집할 수 있습니다")
                }

                HorizontalDivider(thickness = 1.dp, color = Color(0xFF48582F))

                // todo : 사용자 닉네임 수정
                Icon(
                    painter = painterResource(id = R.drawable.rounded_edit_square_24),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 20.dp, start = 300.dp)
                )

                // todo : 사용자 현 재직 상태 표시
                Text(
                    text = "재직 중",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 33.6.sp,
                        fontFamily = FontFamily(Font(R.font.pretendardregular)),
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(bottom = 5.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.icon_rebornlogo),
                    contentDescription = "Icon_rebornlogo",
                    modifier = Modifier
                        .width(108.dp)
                        .height(83.dp)
                        .padding(bottom = 5.dp)
                )

                nickname?.let {
                    Text(
                        text = it,
                        style = TextStyle(
                            fontSize = 24.sp,
                            lineHeight = 33.6.sp,
                            fontFamily = FontFamily(Font(R.font.pretendardextrabold)),
                            fontWeight = FontWeight(600),
                            color = Color(0xFF757575),
                            textAlign = TextAlign.Center,
                        ),
                        modifier = Modifier.padding(bottom = 10.dp)
                    )
                }

                Text(
                    text = "리본 온도",
                    style = TextStyle(
                        fontSize = 16.sp,
                        lineHeight = 33.6.sp,
                        fontFamily = FontFamily(Font(R.font.pretendardregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(top = 5.dp, bottom = 20.dp)
                )
                //todo: 리본 컴포넌트 추가
                HorizontalDivider(thickness = 1.dp, color = Color(0xFF48582F))

                //todo: 관심 분야 수정 아이콘
                Icon(
                    painter = painterResource(id = R.drawable.rounded_edit_square_24),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 20.dp, start = 300.dp)
                )

                Text(
                    text = "관심 분야",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 33.6.sp,
                        fontFamily = FontFamily(Font(R.font.pretendardextrabold)),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    )
                )

                JobFieldComponent {  }
                HorizontalDivider(thickness = 1.dp, color = Color(0xFF48582F))

                // todo: 나의 동네 수정 아이콘
                Icon(
                    painter = painterResource(id = R.drawable.rounded_edit_square_24),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 20.dp, start = 300.dp)
                )

                Text(
                    text = "나의 동네",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 33.6.sp,
                        fontFamily = FontFamily(Font(R.font.pretendardextrabold)),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(bottom = 10.dp)
                )

                ButtonComponent(buttonText = "화양동", buttonColorType = ButtonColorEnum.Green) { }
                Spacer(modifier = Modifier.size(30.dp))
                HorizontalDivider(thickness = 1.dp, color = Color(0xFF48582F))

                // todo: 나의 자격증 수정 아이콘
                Icon(
                    painter = painterResource(id = R.drawable.rounded_edit_square_24),
                    contentDescription = null,
                    modifier = Modifier.padding(top = 20.dp, start = 300.dp)
                )
                Text(
                    text = "나의 자격증",
                    style = TextStyle(
                        fontSize = 24.sp,
                        lineHeight = 33.6.sp,
                        fontFamily = FontFamily(Font(R.font.pretendardextrabold)),
                        color = Color(0xFF000000),
                        textAlign = TextAlign.Center,
                    ),
                    modifier = Modifier.padding(bottom = 10.dp)
                )
            }
        }
    }
}

