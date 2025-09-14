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
import com.example.study.ui.bean.ArticleEntity
import com.example.study.ui.bean.Category
import com.example.study.ui.bean.SwiperEntity
import com.example.study.ui.bean.TypeData
import com.example.study.ui.bean.VideoEntity
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

    var swiperPager by mutableStateOf(
        listOf(
            SwiperEntity("https://i0.hdslb.com/bfs/banner/c2129bedf66133fe2f69e5cb61171a60e001d1ed.png@800w_512h_!web-home-carousel-cover.avif"),
            SwiperEntity("https://i0.hdslb.com/bfs/sycp/creative_img/202509/39f8d2c4d429322d2fb4d7a484e2970e.jpg@800w_512h_!web-home-carousel-cover.avif"),
            SwiperEntity("https://i0.hdslb.com/bfs/banner/859dc7dccda5adbc69aebbc1147a27870f2e2d76.png@800w_512h_!web-home-carousel-cover.avif")
        )
    )

    var notificationMsg by mutableStateOf(
        listOf(
            "党旗飘扬ABCDEFG党旗飘扬ABCDEFG党旗飘扬ABCDEFG党旗飘扬ABCDEFG",
            "党旗飘扬HIJKLMNI",
            "党旗飘扬QQQQQQQQQQQ党旗飘扬QQQQQQQQQQQ党旗飘扬QQ"
        )
    )

    var articleList by mutableStateOf(
        listOf(
            ArticleEntity(
                "标题1",
                "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容",
                "2025-09-10:10:59"
            ),
            ArticleEntity("标题2", "内容内容", "2025-09-10:10:59"),
            ArticleEntity(
                "标题3",
                "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容",
                "2025-09-10:10:59"
            ),
            ArticleEntity(
                "标题4",
                "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容",
                "2025-09-10:10:59"
            ),
            ArticleEntity("标题5", "内容内容", "2025-09-10:10:59"),
            ArticleEntity(
                "标题6",
                "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容",
                "2025-09-10:10:59"
            ),
            ArticleEntity(
                "标题7",
                "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容",
                "2025-09-10:10:59"
            ),
            ArticleEntity("标题8", "内容内容", "2025-09-10:10:59"),
            ArticleEntity(
                "标题9",
                "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容",
                "2025-09-10:10:59"
            )
        )
    )

    var videoList by mutableStateOf(
        listOf(
            VideoEntity(
                "https://i0.hdslb.com/bfs/banner/83a38f643994817c57efcc26a0b6c6b545cdb316.png@800w_512h_!web-home-carousel-cover.avif?mirror_report_swipe=1",
                "title1title1title1title1title1title1title1title1title1",
                "video",
                "2:56"
            ),
            VideoEntity(
                "https://i0.hdslb.com/bfs/banner/7534521038eb9035aa54715e82ef4c1281d4326e.png@800w_512h_!web-home-carousel-cover.avif",
                "title2title2title2title2title2title2title2",
                "video",
                "12:56"
            ),
            VideoEntity(
                "https://i0.hdslb.com/bfs/banner/5c47a022abf92858da2e0acc0b5372bef605b007.png@800w_512h_!web-home-carousel-cover.avif",
                "title3",
                "video",
                "23:56"
            ),
            VideoEntity(
                "https://i0.hdslb.com/bfs/banner/3b4571df30f7b9679c30c793735d18ae3f03b780.jpg@800w_512h_!web-home-carousel-cover.avif",
                "title44444444444444444444444444444444444444444444444444444444",
                "video",
                "4:56"
            ),
            VideoEntity(
                "https://i0.hdslb.com/bfs/banner/99e591ddc00986d16283c3b5bda147205f17c78f.jpg@800w_512h_!web-home-carousel-cover.avif",
                "title5555555555tle5tle5tle5tle5tle5tle5",
                "video",
                "5:56"
            ),
            VideoEntity(
                "https://i0.hdslb.com/bfs/banner/3b4571df30f7b9679c30c793735d18ae3f03b780.jpg@800w_512h_!web-home-carousel-cover.avif",
                "title44444444444444444444444444444444444444444444444444444444",
                "video",
                "4:56"
            ),
            VideoEntity(
                "https://i0.hdslb.com/bfs/banner/99e591ddc00986d16283c3b5bda147205f17c78f.jpg@800w_512h_!web-home-carousel-cover.avif",
                "title5555555555tle5tle5tle5tle5tle5tle5",
                "video",
                "5:56"
            )
        )
    )

    var isShowArtical by mutableIntStateOf(0)
}