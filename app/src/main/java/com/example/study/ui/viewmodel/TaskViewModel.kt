package com.example.study.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TaskViewModel: ViewModel() {

    val taskDate by mutableStateOf("学习周期:2025-09-10 ~ 2026-10-10")

    val allValue by  mutableStateOf(70)

    val totalRound = 100

    var calcRound by mutableStateOf(0f)
        private set

    /**
     * 更新学年积分
     * */
    fun updatePercent() {
        calcRound = 210f*allValue/totalRound
    }

}