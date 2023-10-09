package com.example.herovsmonster.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.herovsmonster.ui.components.DrawButtonToNextScreen
import com.example.herovsmonster.ui.components.guide.DrawTextOfGuide
import com.example.herovsmonster.ui.navigation.Screen
import com.example.herovsmonster.ui.theme.HeroVSMonsterTheme

@Composable
fun GuideScreen(navController: NavController) {
    Box(
        modifier = Modifier.background(Color(254, 200, 145))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            DrawTextOfGuide()
            Column (
                modifier = Modifier.padding(start = 75.dp)
            ) {
                DrawButtonToNextScreen(
                    text = "Back to Menu",
                    navController = navController,
                    route = Screen.HomeScreen.route,
                    validInput = true
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GuideScreenPreview() {
    HeroVSMonsterTheme {
        GuideScreen(navController = rememberNavController())
    }
}
