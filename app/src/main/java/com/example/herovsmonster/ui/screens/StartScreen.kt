package com.example.herovsmonster.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.herovsmonster.R
import com.example.herovsmonster.ui.components.DrawButtonToNextScreen
import com.example.herovsmonster.ui.components.start.DrawModifiers
import com.example.herovsmonster.ui.theme.HeroVSMonsterTheme

@Composable
fun StartScreen(navController: NavController, startViewModel: StartViewModel) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .background(Color(254, 200, 145))
            .fillMaxSize()
    ) {
        DrawModifiers(startViewModel)
        Image(
            painter = painterResource(id = R.drawable.swords),
            contentDescription = "swords"
        )
        DrawButtonToNextScreen(
            text = "To Fight",
            navController = navController,
            route = "fight_screen",
            validInput = startViewModel.validInput.collectAsState().value
        )
    }

}
