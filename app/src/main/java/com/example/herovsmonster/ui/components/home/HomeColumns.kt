package com.example.herovsmonster.ui.components.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.herovsmonster.R

@Composable
fun DrawHeroColumn() {
    Column(
        Modifier
            .padding(top = 360.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.hero),
            contentDescription = "hero"
        )
    }
}

@Composable
fun DrawMonsterColumn() {
    Column(
        Modifier
            .padding(top = 389.dp, start = 220.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.monster),
            contentDescription = "monster"
        )
    }
}
