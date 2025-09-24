package com.example.study.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.study.ui.components.CircleRing
import com.example.study.ui.components.TopAppbar
import com.example.study.ui.viewmodel.TaskViewModel
import java.nio.file.WatchEvent

// 消息页内容
@Composable
fun StudyScreen(statusBarHigh: Float, bottomHigh: Float, vm: TaskViewModel = viewModel()) {

    val boxWSize: Int
    with(LocalConfiguration.current) {
        boxWSize = screenWidthDp / 2
    }

    LaunchedEffect(
        key1 = vm.allValue
    ) {
        vm.updatePercent()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(listOf(Color(0XFF149EE7), Color.White))
            )
    ) {
        // 标题栏
        Row(
            modifier = Modifier.statusBarsPadding()
        ) {
            Text(
                text = "学习任务",
                textAlign = TextAlign.Center,
                color = Color.White,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                fontSize = 18.sp
            )
        }

        LazyColumn() {
            item {
                Text(
                    text = vm.taskDate,
                    fontSize = 12.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(5.dp),
                )
            }

            // 学习进度
            item {
                Box(contentAlignment = Alignment.Center, modifier = Modifier.height(boxWSize.dp).fillMaxWidth().padding(top = 16.dp)) {
                    // 圆环
                    CircleRing(boxWSize)
                    // 初始值
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(buildAnnotatedString {
                            append(vm.allValue.toString())
                            withStyle(SpanStyle(fontSize = 12.sp)) {
                                append("分")
                            }
                        }, fontSize = 36.sp, color = Color.White)
                        Text(text="学年积分", fontSize = 12.sp, color = Color.White)
                    }

                }
            }

            item {
                Row(horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth().offset(y=(-50).dp)) {
                    Column {
                        Text("${vm.totalRound}分", color = Color.White, fontSize = 16.sp)
                        Text("学年规定积分", color = Color.White, fontSize = 12.sp)
                    }
                    Column {
                        Text("${vm.totalRound - vm.allValue}分", color = Color.White, fontSize = 16.sp)
                        Text("还差", color = Color.White, fontSize = 12.sp)
                    }
                }
            }
        }


    }
}