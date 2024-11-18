package com.example.client.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.client.R

data class MenuItem(
    val name: String,
    val submenus: List<String>
)

@Composable
fun PickerComponent() {
    // 메뉴 데이터 정의
    val menuData = listOf(
        MenuItem("서울", listOf("광진구", "용산구", "강동구", "강북구", "마포구", "중구")),
        MenuItem("경기", listOf("수원시", "화성시", "안양시", "부천시", "고양시")),
        MenuItem("전라", listOf("전주시", "광주", "순천시")),
        MenuItem("강원", listOf("춘천시", "원주시", "강릉시"))
    )

    var selectedLeftMenu by remember { mutableStateOf<MenuItem?>(null) }
    var selectedSubMenu by remember { mutableStateOf<String?>(null) }

    Row(
        modifier = Modifier.height(174.dp)
    ) {
        Column(
            modifier = Modifier
                .width(141.dp)
                .fillMaxHeight()
        ) {
            menuData.forEach { menuItem ->
                val backgroundColor =
                    if (selectedLeftMenu == menuItem) Color(0xFF48582F) else Color.Transparent

                Column(modifier = Modifier
                    .fillMaxWidth()
                    .background(backgroundColor)
                    .clickable {
                        selectedLeftMenu = menuItem
                        selectedSubMenu = null
                    }
                    .padding(start = 20.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
                ) {
                    Text(
                        text = menuItem.name,
                        style = TextStyle(
                            fontSize = 16.sp,
                            lineHeight = 24.sp,
                            fontFamily = FontFamily(Font(R.font.pretendardextrabold)),
                            color = if (selectedLeftMenu == menuItem) Color(0xFFFCF4DC) else Color(0xff61646b),
                            textAlign = TextAlign.Center,
                        )
                    )
                }
            }
        }

        // todo : 상위, 하위 모두 선택해야 넘어갈 수 있도록 구현해야 함
        Box(
            modifier = Modifier
                .width(196.dp)
                .fillMaxHeight()
                .background(Color(0xfffffffb))
                .height(192.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.Start
            ) {
                selectedLeftMenu?.submenus?.forEach { submenu ->
                    Box(
                        modifier = Modifier.padding(horizontal = 18.dp, vertical = 8.dp)
                    ) {
                        Text(text = submenu, modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                selectedSubMenu = submenu
                            }
                            .padding(8.dp),
                            style = TextStyle(
                                fontSize = 16.sp,
                                lineHeight = 20.sp,
                                fontFamily = FontFamily(Font(R.font.pretendardregular)),
                                fontWeight = if (selectedSubMenu == submenu) FontWeight.ExtraBold else FontWeight.Normal,)
                        )
                    }
                }
            }
        }
    }
}