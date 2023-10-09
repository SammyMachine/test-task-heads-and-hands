package com.example.herovsmonster.ui.navigation

sealed class Screen(val route: String) {
    object HomeScreen : Screen("home_screen")
    object GuideScreen : Screen("guide_screen")
    object StartScreen : Screen("start_screen")
    object FightScreen : Screen("fight_screen")
}
