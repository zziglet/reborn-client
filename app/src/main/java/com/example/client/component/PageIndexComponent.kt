package com.example.client.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PageIndexComponent(
    currentPage: Int,
    totalPage: Int
) {
    Row(modifier = Modifier.padding(8.dp)) {
        Text(
            text = "$currentPage",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
        )

        Text(
            text = "/$totalPage",
            fontSize = 24.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Gray
        )
    }
}