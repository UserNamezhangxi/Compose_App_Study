package com.example.study.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

// 定义导航页面
sealed class NavScreen(
    val route: String,
    val title: String,
    val icon: ImageVector
) {
    object Home : NavScreen("home", "学习", Icons.Default.Home)
    object Messages : NavScreen("messages", "任务", Icons.Default.DateRange)
    object Settings : NavScreen("settings", "我的", Icons.Default.Person)
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val screens = listOf(
        NavScreen.Home,
        NavScreen.Messages,
        NavScreen.Settings
    )
    Scaffold(bottomBar = {
        NavigationBar {
            val navBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = navBackStackEntry?.destination?.route
            screens.forEach { item ->
                NavigationBarItem(
                    selected = currentRoute == item.route,
                    icon = {
                        Icon(item.icon, contentDescription = item.title)
                    },
                    label = {
                        Text(item.title)
                    },
                    onClick = {
                        navController.navigate(item.route) {
                            // 避免在返回栈中创建多个相同页面
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            // 确保相同路由只启动一个实例
                            launchSingleTop = true
                            // 恢复之前保存的状态
                            restoreState = true
                        }
                    },
                )
            }
        }
    }) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavScreen.Messages.route, // 默认展示哪个页面
        ) {
            composable(NavScreen.Home.route) {
                HomeScreen(innerPadding.calculateTopPadding().value,innerPadding.calculateBottomPadding().value)
            }
            composable(NavScreen.Messages.route) {
                StudyScreen(innerPadding.calculateTopPadding().value,innerPadding.calculateBottomPadding().value)
            }
            composable(NavScreen.Settings.route) {
                MineScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BottomNavPreview() {
    MaterialTheme {
        MainScreen()
    }
}