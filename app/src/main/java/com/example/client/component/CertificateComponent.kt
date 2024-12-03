package com.example.client.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R

@Composable
fun CertificateComponent(
    type: String,
    name: String,
    date: String
) {
    Box(
        modifier = Modifier
            .size(width = 312.dp, height = 119.dp)
            .background(
                color = Color(0xFF8FA86A),
                shape = RoundedCornerShape(20.dp)
            )
    ) {

        Text(
            text = type,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFDCF5B5),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 18.dp, top = 14.dp)
        )
        Text(
            text = name,
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color(0xFFFFFBDC),
            modifier = Modifier
                .align(Alignment.TopStart)
                .padding(start = 18.dp, top = 40.dp)
        )

        Image(
            painter = painterResource(R.drawable.icon_certificate),
            contentDescription = null,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(top = 17.dp, end = 18.dp)
        )

        Text(
            text = date,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color(0xFFF5F5F5),
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(end = 11.dp, bottom = 11.dp
                )
        )
    }
}

@Preview
@Composable
fun CertificateComponentPreview() {
    CertificateComponent(
        type = "기술사",
        name = "섬유기술사",
        date = "25.06.08"
    )
}