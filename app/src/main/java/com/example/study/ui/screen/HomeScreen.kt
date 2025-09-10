package com.example.study.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.LeadingIconTab
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.study.ui.components.TopAppbar
import com.example.study.ui.viewmodel.MainViewModel

// 首页内容
@Composable
fun HomeScreen(statusBarHigh: Float, vm: MainViewModel = viewModel()) {
    Column {
        TopAppbar(statusBarHigh) {
            Spacer(modifier = Modifier.width(8.dp))
            Surface(
                modifier = Modifier
                    .clip(RoundedCornerShape(16.dp))
                    .weight(1f),
                color = Color(0x33ffffff)
            ) {
                /*搜索按钮*/
                Row(modifier = Modifier.padding(6.dp)) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "",
                        tint = Color.White,
                        modifier = Modifier
                            .size(14.dp)
                            .align(Alignment.CenterVertically)

                    )
                    Text(
                        "搜索感兴趣的资讯或课程",
                        color = Color.White,
                        fontSize = 14.sp,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

            }
            Spacer(modifier = Modifier.width(8.dp))

            /*学习进度*/
            Text(
                text = "学习\n进度",
                fontSize = 12.sp,
                style = TextStyle(letterSpacing = 1.sp)
            ) /*控制文字的间距*/

            Spacer(modifier = Modifier.width(8.dp))

            /*进度*/
            Text(text = "26%")

            Spacer(modifier = Modifier.width(8.dp))

            /*提醒*/
            Icon(imageVector = Icons.Default.Notifications, contentDescription = "")

            Spacer(modifier = Modifier.width(8.dp))
        }

        TabRow(
            selectedTabIndex = vm.selectIndex,
            containerColor = Color(0x66149ee7),
            contentColor = Color(0xff149ee7)
        ) {
            vm.category.forEachIndexed { index, category ->
                Tab(
                    selected = index == vm.selectIndex,
                    onClick = {
                        vm.selectIndex = index
                    },
                    selectedContentColor = Color(0xff149ee7),
                    unselectedContentColor = Color(0xff666666),
                    text = {
                        Text(
                            text = category.title,
                            modifier = Modifier
                                .padding(4.dp, 8.dp),
                            maxLines = 1
                        )
                    }
                )
            }
        }

        TabRow(
            selectedTabIndex = vm.typeIndex,
            containerColor = Color.Transparent,
            contentColor = Color(0xff149ee7),
            indicator = {},
            divider = {}
        ) {
            vm.types.forEachIndexed { index, data ->
                LeadingIconTab(
                    selected = index == vm.typeIndex,
                    onClick = {
                        vm.typeIndex = index
                    },
                    selectedContentColor = Color(0xff149ee7),
                    unselectedContentColor = Color(0xff666666),
                    icon = {
                        Icon(imageVector = data.imgVector, contentDescription = "")
                    },
                    text = {
                        Text(
                            text = data.name,
                            modifier = Modifier
                                .padding(4.dp, 8.dp),
                            maxLines = 1
                        )
                    }
                )
            }
        }
    }

}
