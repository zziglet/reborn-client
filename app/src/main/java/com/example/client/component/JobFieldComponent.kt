package com.example.client.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R

data class JobField(
    val name: String
)

@Composable
fun JobFieldComponent() {

    val jobFields = listOf(
        JobField("IT"),
        JobField("교육"),
        JobField("사무직"),
        JobField("판매직"),
        JobField("의료"),
        JobField("서비스"),
        JobField("건설"),
        JobField("제조업"),
        JobField("예술")
    )

    var selectedField by remember { mutableStateOf<JobField?>(null) }

    LazyVerticalGrid(
        columns = GridCells.Fixed(3),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(40.dp)
    ) {
        items(jobFields.size) { index ->
            val jobField = jobFields[index]
            val isSelected = selectedField == jobField
            val backgroundColor = if (isSelected) Color(0xFF48582F) else Color.Transparent

            Box(
                modifier = Modifier
                    .padding(5.dp) // 아이템 간의 간격
                    .border(width = 1.dp, color = Color(0xFF48582F), shape = RoundedCornerShape(size = 20.dp))
                    .background(backgroundColor, shape = RoundedCornerShape(size = 20.dp)) // 배경색 설정
                    .clickable {
                        selectedField = if (isSelected) null else jobField
                    }
                    .padding(10.dp), // 내부 패딩
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = jobField.name,
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily(Font(R.font.pretendardregular)),
                        color = if (isSelected) Color.White else Color.Black
                    )
                )
            }
        }
    }
}
