package com.example.myandroidbook.navigation

sealed class Screen(val route: String) {
    object Welcome : Screen(route = "welcome_screen")
    object Home : Screen(route = "home_screen")
    object Details : Screen("details_screen/{kotlinId}") {
        fun passHeroId(kotlinId: Int): String {
            return "details_screen/$kotlinId"
        }
    }

    object Search : Screen("search_screen")
}