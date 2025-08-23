package com.example.study.ui.screen

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

// 首页内容
@Composable
fun HomeScreen() {
    Text(
        text = "首页",
        style = MaterialTheme.typography.headlineLarge
    )
}