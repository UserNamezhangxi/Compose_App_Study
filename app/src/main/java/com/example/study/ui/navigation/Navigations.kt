package com.example.study.ui.navigation

sealed class Navigations(val route:String) {
    // 首页
    object Page1:Navigations("Page1")

    // 文章详情页面
    object Page2:Navigations("Page2")


}