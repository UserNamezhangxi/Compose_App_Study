package com.example.study

import android.app.Activity
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.study.ui.components.TopAppbar
import com.example.study.ui.screen.MainScreen
import com.example.study.ui.theme.StudyTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            StudyTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun Counter() {
    val count = remember { mutableStateOf(0) }  // 定义一个用于计数的状态变量

    SideEffect {                                // 使用 SideEffect 记录 count 的当前值
        println("Count is ${count.value}")      // 每次重组时会调用
    }

    Column {
        Button(onClick = { count.value++ }) {
            Text("Increase Count")
        }
        Text("Counter ${count.value}")          // 每次状态更新时，文本都会更改并触发重组
    }
}


@Composable
fun Counter1() {
    val count = remember { mutableStateOf(0) }  // 定义一个用于计数的状态变量

    SideEffect {                                // 使用 SideEffect 记录 count 的当前值
        println("Count is ${count.value}")      // 每次重组时会调用
    }

    Column {
        Button(onClick = { count.value++ }) {
            Text("Increase Count ${count.value}")  // 每次点击按钮时，这种重组不会触发外部副作用
        }
    }
}

@Composable
fun Counter2() {
    val count = remember { mutableStateOf(0) }  // 定义一个用于计数的状态变量

    SideEffect {                                // 使用 SideEffect 记录 count 的当前值
        println("Count is ${count.value}")      // 每次重组时会调用
    }

    Column {
        Button(onClick = { count.value++ }) {
            SideEffect {
                println("@@@ Count is ${count.value}")  // 每次重组时会调用
            }
            Text("Increase Count ${count.value}")       // 每次点击按钮时，这种重组不会触发外部副作用
        }
    }
}


@Composable
fun Timer() {
    val time = remember { mutableIntStateOf(0) }
    DisposableEffect(Unit) {
        val scope = CoroutineScope(Dispatchers.Default)
        val job = scope.launch {
            while (true) {
                delay(1000)
                time.intValue++
                println("@@@Timer is working ${time.intValue}")
            }
        }

        onDispose {
            println("view is removed..") // 页面销毁，或者控件不可见时候走 DisposableEffect 的 onDispose 方法
            job.cancel()
        }
    }

    Text(
        text = "Time is ${time.value}",
        modifier = Modifier.padding(15.dp),
        fontSize = 20.sp
    )
}

@Composable
fun LaunchedEffectComposable() {
    val isLoading = remember { mutableStateOf(false) }
    val data = remember { mutableStateOf(listOf<String>()) }

    // 定义一个 LaunchedEffect 来异步执行长时间运行的操作，
    // 如果 isLoading.value 发生变化，LaunchedEffect 将取消并重新启动
    LaunchedEffect(isLoading.value) {
        if (isLoading.value) {
            val newData = fetchData()  // 执行长时间运行的操作，例如从网络获取数据
            data.value = newData       // 使用新数据更新状态
            isLoading.value = false
        }
    }

    Column {
        Button(modifier = Modifier.padding(30.dp), onClick = { isLoading.value = true }) {
            Text("Fetch Data")
        }
        if (isLoading.value) {
            CircularProgressIndicator()  // 显示加载指示器
        } else {
            LazyColumn {
                items(data.value.size) { index ->
                    Text(text = data.value[index])
                }
            }
        }
    }
}

// 通过暂停协程 3 秒来模拟网络调用
private suspend fun fetchData(): List<String> {
    // Simulate a network delay
    delay(3000)
    return listOf("Item 1", "Item 2", "Item 3", "Item 4", "Item 5",)
}



@Composable
fun MyComponent() {
    // 它将创建一个与当前组合关联的协程范围，我们可以在其中调用任何挂起函数。
    // rememberCoroutineScope 用于创建与 Composable 函数的生命周期绑定的协程范围。
    // 这样一来，你就可以高效、安全地管理协程，确保可组合函数消失时取消协程。
    // 您可以在范围内使用 launch功能，轻松安全地管理异步操作
    val coroutineScope = rememberCoroutineScope()
    var data by remember { mutableStateOf("") }

    Column {
        Button(onClick = {
            coroutineScope.launch {
                // Simulate network call
                delay(2000)
                data = "Data loaded"
            }
        }) {
            Text("Load data")
        }

        Text(text = data)
    }
}



@Composable
fun TestCompose() {
    var dynamicData by remember { mutableStateOf("") }
    LaunchedEffect(Unit) {
        delay(3000L)
        dynamicData = "New Compose Text 11"
    }
    MyComponent1(title = dynamicData)
}


/**
 * 最初，title 是一个 “Hi, Compose”。3 秒后，title 变为“New Compose Text”。
 * 5 秒后，data也会变为“New Compose Text”，从而触发 UI 的重构。
 * 这将更新 Text 可组合项。因此，总延迟为 5 秒，
 * 如果我们没有使用 rememberUpdatedState，那么我们必须重新启动第二个 LaunchedEffect，这将需要 8 秒。
 * */
@Composable
fun MyComponent1(title: String) {
    var data by remember { mutableStateOf("Hi, Compose") }

    /*如果要引用一个值，如果该值发生更改，则不应重新启动，
    请使用 rememberUpdatedState。当关键参数的值之一更新时，LaunchedEffect 会重新启动，
    但有时我们希望在不重新启动的情况下捕获效果中更改的值。
    如果我们有长时间运行的选项，重新启动成本很高，则此过程会很有帮助。*/
    val updatedData by rememberUpdatedState(title)

    LaunchedEffect(Unit) { // 如果监听data 则会走第二次重组 若此时内部是耗时操作会影响启动速度
        println("LaunchedEffect ....")
        delay(5000L)
        data = updatedData
    }
    println("data " + data)
    Text(text = data)
}
