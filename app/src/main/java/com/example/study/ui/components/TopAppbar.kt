package com.example.study.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.study.ui.theme.blue200
import com.example.study.ui.theme.blue700
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun TopAppbar(statusBarHigh: Float, content: @Composable () -> Unit) {
    val systemUiController = rememberSystemUiController()
    val useDarkIcons = false

    SideEffect {
        systemUiController.setSystemBarsColor(
            color = Color.Transparent,
            darkIcons = useDarkIcons
        )
    }
    Row(
        modifier = Modifier
            .background(
                Brush.linearGradient(
                    listOf(blue700, blue200)
                )
            )
            .height((50+statusBarHigh).dp)
            .fillMaxWidth().padding(top = statusBarHigh.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        content()
    }
}
