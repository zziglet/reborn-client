package com.example.client.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.navigation.NavController
import com.example.client.R
import com.example.client.component.job.CertificateButtonComponent
import com.example.client.component.job.JobListComponent
import com.example.client.component.job.KeywordButtonComponent
import com.example.client.component.all.TabLayoutComponent
import com.example.client.domain.TestUserInfo

@Composable
fun JobMainScreen(navController: NavController){
    var nickname by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        nickname = TestUserInfo.TEST_USERNAME
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color(0xFFFFFBDC))
    ) {
       item {
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
               Icon(
                   painter = painterResource(id = R.drawable.baseline_search_24),
                   contentDescription = null,
                   modifier = Modifier
                       .padding(start = 230.dp)
                       .clickable {  }
                       .padding(8.dp),
                   tint = Color(0xFF48582F)
               )
           }
       }

        item{
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color(0xFFFFFEF4), shape = RoundedCornerShape(size = 40.dp))
            ) {
                Row() {
                    Column(modifier = Modifier.padding(top = 20.dp, start = 20.dp)) {
                        Row {
                            Text(
                                text = "$nickname",
                                fontSize = 30.sp,
                                color = Color(0xFF000000),
                                modifier = Modifier.height(35.dp),
                                fontFamily = FontFamily(Font(R.font.pretendardextrabold))
                            )
                            Text(
                                text = "님께",
                                fontSize = 30.sp,
                                color = Color(0xFF000000),
                                modifier = Modifier.height(35.dp),
                                fontFamily = FontFamily(Font(R.font.pretendardregular))
                            )
                            Spacer(modifier = Modifier.width(120.dp))
                            TextButton(
                                onClick = { navController.navigate("MyPage")},
                                enabled = true,
                            ) {
                                Text(
                                    text = "내 정보 편집",
                                    style = TextStyle(
                                        fontSize = 18.sp,
                                        lineHeight = 21.sp,
                                        fontFamily = FontFamily(Font(R.font.pretendardregular)),
                                        fontWeight = FontWeight(400),
                                        color = Color(0xFF688142),
                                        textAlign = TextAlign.Center,
                                    )
                                )
                            }
                        }
                        Text(
                            text = "추천드리는 공고",
                            fontSize = 30.sp,
                            color = Color(0xFF000000),
                            modifier = Modifier.height(35.dp),
                            fontFamily = FontFamily(Font(R.font.pretendardregular))
                        )
                    }
                    Spacer(modifier = Modifier.size(width = 185.dp, height = 20.dp))
                }
                Spacer(modifier = Modifier.size(20.dp))
                TabLayoutComponent(tabs = listOf("맞춤 일자리", "자격증 기반")) { page ->
                    when (page) {
                        0 -> {
                            // 맞춤 일자리 리스트
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                KeywordButtonComponent(
                                    buttonText = "서울 중구",
                                    onClick = {}
                                )
                                Spacer(modifier = Modifier.size(15.dp))
                                JobListComponent(
                                    companyName = "삼성전자",
                                    jobTitle = "생산직",
                                    location = "수원시 영통구",
                                    onClick = { /* 상세 페이지로 이동 */ }
                                )
                                JobListComponent(
                                    companyName = "삼성전자",
                                    jobTitle = "생산직",
                                    location = "수원시 영통구",
                                    onClick = { /* 상세 페이지로 이동 */ }
                                )
                                JobListComponent(
                                    companyName = "삼성전자",
                                    jobTitle = "생산직",
                                    location = "수원시 영통구",
                                    onClick = { /* 상세 페이지로 이동 */ }
                                )
                                JobListComponent(
                                    companyName = "삼성전자",
                                    jobTitle = "생산직",
                                    location = "수원시 영통구",
                                    onClick = { /* 상세 페이지로 이동 */ }
                                )
                                JobListComponent(
                                    companyName = "삼성전자",
                                    jobTitle = "생산직",
                                    location = "수원시 영통구",
                                    onClick = { /* 상세 페이지로 이동 */ }
                                )
                            }
                        }
                        1 -> {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 25.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "확인하고 싶은 자격증을 선택해주세요!",
                                    style = TextStyle(
                                        fontSize = 20.sp,
                                        lineHeight = 40.sp,
                                        fontFamily = FontFamily(Font(R.font.pretendardextrabold)),
                                        fontWeight = FontWeight(600),
                                        color = Color(0xFF000000),
                                        textAlign = TextAlign.Center,
                                    )
                                )
                                Spacer(modifier = Modifier.size(15.dp))
                                LazyVerticalGrid(
                                    columns = GridCells.Fixed(2),
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .height(1000.dp)
                                        .padding(horizontal = 8.dp),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                                    verticalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    val certList = listOf(
                                        Triple("한국고용정보원", "고용서비스", "25.07.15"),
                                        Triple("한국산업인력공단", "지게차운전", "25.08.20"),
                                        Triple("대한상공회의소", "컴퓨터활용능력", "25.09.10"),
                                        Triple("한국고용정보원", "직업상담사", "25.10.15")
                                        // ... 더 많은 데이터
                                    )

                                    items(certList) { (dept, name, date) ->
                                        CertificateButtonComponent(
                                            certificateDepartment = dept,
                                            certificateName = name,
                                            date = date,
                                            onClick = { /* 자격증 상세 정보로 이동 */ }
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
                Spacer(modifier = Modifier.size(70.dp))
            }
        }

    }
}