package com.example.study.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.study.ui.components.TopAppbar

// 首页内容
@Composable
fun HomeScreen(statusBarHigh: Float) {
    Column {
        TopAppbar(statusBarHigh) {
            Text("学习")
        }
        Text(
            text = "首页",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(20.dp),
        )
    }

}
