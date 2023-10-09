package com.example.herovsmonster.ui.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.herovsmonster.ui.screens.FightViewModel
import com.example.herovsmonster.ui.screens.StartViewModel
import com.example.herovsmonster.ui.screens.FightScreen
import com.example.herovsmonster.ui.screens.GuideScreen
import com.example.herovsmonster.ui.screens.HomeScreen
import com.example.herovsmonster.ui.screens.StartScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    val startViewModel: StartViewModel = viewModel(factory = StartViewModel.Factory)
    val fightViewModel: FightViewModel = viewModel(factory = FightViewModel.Factory)

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.GuideScreen.route) {
            GuideScreen(navController = navController)
        }

        composable(route = Screen.StartScreen.route) {
            StartScreen(navController = navController, startViewModel = startViewModel)
        }

        composable(route = Screen.FightScreen.route) {
            FightScreen(fightViewModel = fightViewModel)
        }
    }
}
