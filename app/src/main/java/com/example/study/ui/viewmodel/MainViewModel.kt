package com.example.study.ui.viewmodel

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
import com.example.study.ui.bean.TypeData

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

    var typeIndex by mutableIntStateOf(0)
}