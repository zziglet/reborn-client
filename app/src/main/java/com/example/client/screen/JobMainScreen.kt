package com.example.client.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.client.R
import com.example.client.component.PageIndexComponent
import com.example.client.domain.TestUserInfo

@Composable
fun JobMainScreen(navController: NavController){
    var nickname by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(Unit) {
        nickname = TestUserInfo.TEST_USERNAME
    }

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
                    }
                    Spacer(modifier = Modifier.size(8.dp))
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
            Spacer(modifier = Modifier.size(70.dp))
            Text(
                text = "얏호",
                fontSize = 30.sp,
                modifier = Modifier
                    .height(40.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                fontFamily = FontFamily(Font(R.font.pretendardregular))
            )
            Spacer(modifier = Modifier.size(70.dp))
        }
    }
}