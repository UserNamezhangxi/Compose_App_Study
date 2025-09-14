package com.example.study.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.study.ui.viewmodel.MainViewModel
import kotlinx.coroutines.delay

@Composable
fun VerticalMessage(vm: MainViewModel) {
    val pagerState = rememberPagerState(pageCount = { vm.swiperPager.size })
    val pagerIsDragged by pagerState.interactionSource.collectIsDraggedAsState()

    val pageInteractionSource = remember { MutableInteractionSource() }
    val pageIsPressed by pageInteractionSource.collectIsPressedAsState()

    // Stop auto-advancing when pager is dragged or one of the pages is pressed
    val autoAdvance = !pagerIsDragged && !pageIsPressed
    if (autoAdvance) {
        LaunchedEffect(pagerState, pageInteractionSource) {
            while (true) {
                delay(3000)
                val nextPage = (pagerState.currentPage + 1) % vm.swiperPager.size
                pagerState.animateScrollToPage(nextPage)
            }
        }
    }
    Row(
        modifier = Modifier
            .padding(start = 16.dp, top = 22.dp, end = 16.dp, bottom = 12.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(Color(0x22149ee7))
            .height(45.dp)
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text("最新活动", fontSize = 14.sp, color = Color(0XFF149EE7))
        VerticalPager(
            state = pagerState,
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.Start,
        ) { page ->
            Text(
                modifier = Modifier
                    .fillMaxSize()
                    .wrapContentSize(Alignment.CenterStart), // 左边居中
                text = vm.notificationMsg[page],
                color = Color(0xff333333),
                fontSize = 14.sp,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
        Text("更多", fontSize = 14.sp, color = Color(0XFF149EE7))
    }
}