package com.example.study.ui.viewmodel

import androidx.collection.mutableIntListOf
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.VideoSettings
import androidx.compose.material3.Icon
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.study.ui.bean.Category
import com.example.study.ui.bean.SwiperEntity
import com.example.study.ui.bean.TypeData
import kotlin.collections.listOf

class MainViewModel : ViewModel() {

    val category by mutableStateOf(
        listOf(
            Category("思想政治"),
            Category("法律法规"),
            Category("职业道德"),
            Category("诚信自律")
        )
    )

    var selectIndex by mutableIntStateOf(0)

    val types by mutableStateOf(
        listOf(
            TypeData(
                "相关咨询",
                Icons.Default.Description
            ),
            TypeData(
                "视频课程",
                Icons.Default.VideoSettings
            ),
        ),
    )

    /**类型*/
    var typeIndex by mutableIntStateOf(0)

    var swiperPager by mutableStateOf(listOf(
        SwiperEntity("https://i0.hdslb.com/bfs/banner/c2129bedf66133fe2f69e5cb61171a60e001d1ed.png@800w_512h_!web-home-carousel-cover.avif"),
        SwiperEntity("https://i0.hdslb.com/bfs/sycp/creative_img/202509/39f8d2c4d429322d2fb4d7a484e2970e.jpg@800w_512h_!web-home-carousel-cover.avif"),
        SwiperEntity("https://i0.hdslb.com/bfs/banner/859dc7dccda5adbc69aebbc1147a27870f2e2d76.png@800w_512h_!web-home-carousel-cover.avif")))

}