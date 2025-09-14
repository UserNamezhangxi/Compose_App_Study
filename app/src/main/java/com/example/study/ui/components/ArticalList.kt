package com.example.study.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.study.ui.viewmodel.MainViewModel

@Composable
fun ArticalList(vm: MainViewModel) {
    LazyColumn {
        items(vm.articleList) { artical ->
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
                Text(
                    artical.title,
                    fontSize = 16.sp,
                    color = Color(0xff000000),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        artical.source,
                        fontSize = 10.sp,
                        color = Color(0xff999999),
                        maxLines = 1,
                        modifier = Modifier
                            .weight(1f)
                            .padding(end = 8.dp),
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        artical.timestamp,
                        fontSize = 10.sp,
                        color = Color(0xff999999),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }
                HorizontalDivider()
            }
        }
    }
}
