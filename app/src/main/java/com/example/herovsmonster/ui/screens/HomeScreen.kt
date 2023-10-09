package com.example.herovsmonster.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.herovsmonster.R
import com.example.herovsmonster.ui.components.home.DrawButtonHome
import com.example.herovsmonster.ui.components.home.DrawHeroColumn
import com.example.herovsmonster.ui.components.home.DrawMonsterColumn
import com.example.herovsmonster.ui.components.home.DrawTitle
import com.example.herovsmonster.ui.theme.HeroVSMonsterTheme

@Composable
fun HomeScreen(navController: NavController) {
    DrawBackground()
    DrawTitle()
    Column(
        Modifier
            .padding(top = 550.dp, start = 75.dp)
    ) {
        DrawButtonHome(text = "Start", navController = navController)
        Spacer(
            Modifier
                .padding(top = 15.dp, end = 15.dp)
        )
        DrawButtonHome(text = "Guide", navController = navController)

    }
    DrawHeroColumn()
    DrawMonsterColumn()
}

@Composable
fun DrawBackground() {
    Image(
        painter = painterResource(id = R.drawable.background),
        contentDescription = "Demo Background",
        contentScale = ContentScale.FillBounds

    )
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HeroVSMonsterTheme {
        HomeScreen(navController = rememberNavController())
    }
}