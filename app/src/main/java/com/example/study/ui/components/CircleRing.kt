package com.example.study.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.study.ui.viewmodel.TaskViewModel

@Composable
fun CircleRing(boxWidth: Int,vm: TaskViewModel = viewModel()) {

    Canvas(modifier = Modifier.size(boxWidth.dp)) {
        rotate(180f) {
            drawArc(
                color = Color(0x33000017),
                startAngle = -10f,
                sweepAngle = 200f,
                useCenter = false,
                style = Stroke(30f, cap = StrokeCap.Round)
            )
        }
        rotate(180f) {
            drawArc(
                color = Color.White,
                startAngle = -10f,
                sweepAngle = vm.calcRound,
                useCenter = false,
                style = Stroke(30f, cap = StrokeCap.Round)
            )
        }
    }
}