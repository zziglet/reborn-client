package com.example.client.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.tooling.preview.Preview
import com.example.client.R

@Composable
fun NicknameFieldComponent(userName: String, onCancel: (String) -> Unit) {
    var nicknameText by remember { mutableStateOf("") }

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        OutlinedTextField(
            value = nicknameText,
            onValueChange = { nicknameText = it },
            placeholder = { Text(userName) },
            modifier = Modifier
                .height(52.dp)
                .width(264.dp)
                .background(Color.LightGray, shape = RoundedCornerShape(8.dp)),
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = Color.White,
                focusedContainerColor = Color.White,
                unfocusedIndicatorColor = Color.LightGray,
                focusedIndicatorColor = Color.LightGray
            ),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    onCancel(nicknameText)
                }
            ),
            trailingIcon = {
                // 화살표 아이콘
                Icon(
                    painter = painterResource(id = R.drawable.outline_cancel_24),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable { nicknameText = "" }
                        .padding(8.dp)
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNicknameFieldComponent() {
    NicknameFieldComponent(
        userName = "사용자 이름",
        onCancel = { nickname ->
            // 여기에 nickname을 처리하는 로직을 추가할 수 있습니다.
            println("닉네임: $nickname")
        }
    )
}
