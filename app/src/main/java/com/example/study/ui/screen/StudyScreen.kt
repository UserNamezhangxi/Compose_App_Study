package com.example.study.ui.screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// 消息页内容
@Composable
fun StudyScreen() {
    Text(
        text = "消息中心",
        style = MaterialTheme.typography.headlineLarge
    )
}