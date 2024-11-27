package com.example.client.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R
import androidx.compose.material3.Button
import androidx.compose.material3.Icon

@Composable
fun JobListComponent(
        companyName: String,
        jobTitle: String,
        location: String,
        salary: String,
        onClick: () -> Unit
    ) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .height(128.dp)
            .width(330.dp)
            .shadow(8.dp, RoundedCornerShape(24.dp))
            .background(color = Color(0xFFFFFBDC), shape = RoundedCornerShape(20.dp)),
        contentAlignment = Alignment.TopStart
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFFFFBDC)) // 카드 배경색
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            // 왼쪽 텍스트 영역
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                // 회사명
                Text(
                    text = companyName,
                    color = Color(0xFF898A8D),
                    fontSize = 16.sp
                )
                // 업무명
                Text(
                    text = jobTitle,
                    color = Color(0xFF366943),
                    fontSize = 24.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                Spacer(modifier = Modifier.height(4.dp))
                // 위치
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_location), // 위치 아이콘
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = location,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(
                        painter = painterResource(id = R.drawable.icon_money), // 월급 아이콘
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),
                        tint = Color.Black
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = salary,
                        color = Color.Black,
                        fontSize = 16.sp
                    )
                }
            }

            // 오른쪽 버튼 영역
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxHeight()
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.icon_green_star), // 즐겨찾기 아이콘
                    contentDescription = null,
                    modifier = Modifier.size(20.dp),
                    tint = Color(0xFF687F45) // 기본은 회색
                )
                Spacer(modifier = Modifier.height(14.dp))
                Button(
                    onClick = onClick,
                    shape = RoundedCornerShape(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFF687F45) // 버튼 배경색
                    ),
                    contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                    modifier = Modifier
                        .height(40.dp)
                        .width(112.dp)
                        .padding(4.dp)
                ) {
                    Text(
                        text = "자세히 보기",
                        fontSize = 16.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}
/*
            CertificateButtonComponent(
                certificateDepartment = "한국고용정보원",
                certificateName = "고용서비스",
                date = "25.07.15",
                onClick = {
                    Log.i("ComponentTag", "CertificateButtonComponent")
                }
            )
*/
