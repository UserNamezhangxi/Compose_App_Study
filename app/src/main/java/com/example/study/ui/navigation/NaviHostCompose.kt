package com.example.study.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.study.ui.screen.PageOne
import com.example.study.ui.screen.PageTwo

@Composable
fun NaviHostCompose() {
    val navController = rememberNavController()
    NavHost(navController = navController,startDestination= Navigations.Page1.route) {
        composable(Navigations.Page1.route) {
            PageOne(navController)
        }

        composable(Navigations.Page2.route) {
            PageTwo(navController)
        }
    }
}