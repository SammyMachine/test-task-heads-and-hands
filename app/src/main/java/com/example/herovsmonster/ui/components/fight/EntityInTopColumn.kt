package com.example.herovsmonster.ui.components.fight

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.herovsmonster.R

@Composable
fun DrawEntityInTopColumn(
    attack: () -> Unit,
    heal: () -> Unit,
    enableButtons: Boolean,
    isEndGame: Boolean
) {
    Row(
        modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DrawColumnForEntity(true, heal, isEndGame, enableButtons)
        DrawColumnForEntity(false, attack, isEndGame, enableButtons)
    }
}

@Composable
fun DrawColumnForEntity(
    isHero: Boolean,
    function: () -> Unit,
    isEndGame: Boolean,
    enableButtons: Boolean
) {
    val (entityID, buttonImageID) = if (isHero) R.drawable.hero to R.drawable.hero_health
    else R.drawable.monster to R.drawable.hero_attack

    Column(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = entityID),
            contentDescription = null
        )
        Button(
            modifier = Modifier.padding(top = 50.dp),
            enabled = !isEndGame && enableButtons,
            onClick = {
                function()
            }
        ) {
            Icon(
                painter = painterResource(id = buttonImageID),
                contentDescription = null,
                tint = Color.Unspecified
            )
        }
    }
    Row {

    }
}
