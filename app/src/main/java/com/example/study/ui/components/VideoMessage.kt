package com.example.study.ui.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.example.study.ui.viewmodel.MainViewModel

@Composable
fun VideoMessage(vm: MainViewModel) {
    LazyColumn {
        val contraintSet = ConstraintSet {
            val cover = createRefFor("cover")
            val title = createRefFor("title")
            val type = createRefFor("type")
            val duration = createRefFor("duration")

            constrain(cover) {
                start.linkTo(parent.start)
                centerVerticallyTo(parent)
                width = Dimension.value(115.dp)
            }
            constrain(title) {
                start.linkTo(cover.end, margin = 8.dp)
                end.linkTo(parent.end)
                width = Dimension.fillToConstraints
            }
            constrain(type) {
                start.linkTo(title.start)
                bottom.linkTo(parent.bottom)
            }

            constrain(duration) {
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            }
        }

        items(vm.videoList) { videoItem ->
            ConstraintLayout(
                contraintSet, modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                AsyncImage(
                    model = videoItem.url,
                    contentDescription = "",
                    modifier = Modifier
                        .aspectRatio(4.5f / 3f)
                        .layoutId("cover")
                )
                Text(
                    videoItem.title,
                    fontSize = 16.sp,
                    color = Color(0xff000000),
                    modifier = Modifier
                        .layoutId("title")
                        .fillMaxWidth(),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    videoItem.type,
                    fontSize = 10.sp,
                    color = Color(0xff999999),
                    modifier = Modifier.layoutId("type"),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    "时长${videoItem.duration}",
                    fontSize = 10.sp,
                    color = Color(0xff999999),
                    modifier = Modifier.layoutId("duration"),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }
            HorizontalDivider(modifier = Modifier.padding(horizontal = 8.dp))
        }
    }
}
