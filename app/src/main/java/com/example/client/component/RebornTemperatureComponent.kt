package com.example.client.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RebornTemperatureComponent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "리본 온도",
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Slider(
            value = 0.4f,
            onValueChange = {},
            colors = SliderDefaults.colors(
                thumbColor = Color(0xFF455A30),
                activeTrackColor = Color(0xFF455A30),
                inactiveTrackColor = Color(0xFFE6E6E7),
            ),
            thumb = {
                Box(
                    modifier = Modifier
                        .size(24.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_reborn_red),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }
            },

            )
    }
}


@Preview
@Composable
fun RebornTemperatureComponentPreview() {
    RebornTemperatureComponent()
}