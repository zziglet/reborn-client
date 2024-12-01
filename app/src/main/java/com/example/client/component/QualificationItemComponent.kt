package com.example.client.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R

data class Qualification(
    val title: String,
    val date: String
)

@Composable
fun QualificationItemComponent(qualification: Qualification) {

    ListItem(
        modifier = Modifier.fillMaxWidth()
            .background(Color(0xFFFFFEF4)), // 전체 너비를 채우도록
        headlineContent = {
            Box(
                modifier = Modifier.fillMaxWidth(), // Box를 전체 너비로 설정
                contentAlignment = Alignment.Center // 중앙 정렬
            ) {
                Text(
                    text = qualification.title,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.pretendardregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF1D1B20)
                    ),
                    modifier = Modifier.padding(bottom = 8.dp),
                )
            }
        },
        supportingContent = {
            Box(
                modifier = Modifier.fillMaxWidth(), // Box를 전체 너비로 설정
                contentAlignment = Alignment.Center // 중앙 정렬
            ) {
                Text(
                    text = qualification.date,
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontFamily = FontFamily(Font(R.font.pretendardregular)),
                        fontWeight = FontWeight(400),
                        color = Color(0xFF49454F)
                    )
                )
            }
        }
    )

}

@Preview(showBackground = true)
@Composable
fun QualificationItemComponent() {
    val sample = Qualification(
        title = "문화해설사",
        date = "2022.03.24"
    )

    QualificationItemComponent(qualification = sample)
}