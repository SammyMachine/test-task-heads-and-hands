package com.example.herovsmonster.ui.screens

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import com.example.herovsmonster.ui.components.fight.DrawEntityInTopColumn
import com.example.herovsmonster.ui.components.fight.DrawParamsInTopColumn


// Toast.makeText(
//                        context,
//                        "${it.first} dealt ${it.second} damage!",
//                        Toast.LENGTH_SHORT
//                    ).show()

fun toastForFight(text: String, currentContext: Context) {
    Toast.makeText(
        currentContext,
        text,
        Toast.LENGTH_SHORT
    ).show()
}

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun FightScreen(fightViewModel: FightViewModel) {
    fightViewModel.getDataFromFight()
    val forToast = fightViewModel.dealtDamage.collectAsState().value
    val enabledButtons = fightViewModel.enableButtons.collectAsState()
    val healthValuePlayer = fightViewModel.healthValuePlayer.collectAsState().value
    val healthValueMonster = fightViewModel.healthValueMonster.collectAsState().value
    val heroHeal = fightViewModel.heroHeal.collectAsState().value

    if (forToast.second != -1 && !enabledButtons.value) {
        toastForFight("${forToast.first} dealt ${forToast.second} damage!", LocalContext.current)
        fightViewModel.resetAll()
    }
    if (healthValuePlayer == 0 || healthValueMonster == 0) {
        toastForFight("Game is ended!", LocalContext.current)
    }
    if (heroHeal.first > 0 && heroHeal.second >= 0) {
        toastForFight("Healed ${heroHeal.first} health! Count of heals left: ${heroHeal.second}", LocalContext.current)
        fightViewModel.resetAll()
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(254, 200, 145)),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DrawParamsInTopColumn(
            fightViewModel.dataFromFight.collectAsState().value,
            healthValuePlayer,
            healthValueMonster
        )
        DrawEntityInTopColumn(
            fightViewModel::playerAttack,
            fightViewModel::restoreHealth,
            enabledButtons.value,
            healthValuePlayer == 0 || healthValueMonster == 0
        )
    }
}
