package com.example.herovsmonster.ui.components.fight

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.herovsmonster.ui.model.Hero
import com.example.herovsmonster.ui.model.Monster

@Composable
fun DrawParamsInTopColumn(
    value: Pair<List<String>, List<String>>,
    heroHealth: Int,
    monsterHealth: Int
) {
    Row(
        Modifier
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.width(15.dp))

        DrawColumnForRow(true, true, value, heroHealth)
        Spacer(modifier = Modifier.width(45.dp))

        DrawColumnForRow(true, false, value, -1)
        Spacer(modifier = Modifier.width(70.dp))

        DrawColumnForRow(false, false, value, -1)
        Spacer(modifier = Modifier.width(45.dp))

        DrawColumnForRow(false, true, value, monsterHealth)
        Spacer(modifier = Modifier.width(15.dp))
    }
}

@Composable
fun DrawColumnForRow(
    isHero: Boolean,
    isHealthAndDamage: Boolean,
    pair: Pair<List<String>, List<String>>,
    health: Int
) {
    val (topImage, bottomImage) = when {
        (isHero && isHealthAndDamage) -> Hero.HEALTH.toDrawableRes() to Hero.DAMAGE.toDrawableRes()
        (isHero && !isHealthAndDamage) -> Hero.DEFENCE.toDrawableRes() to Hero.ATTACK.toDrawableRes()
        (!isHero && !isHealthAndDamage) -> Monster.DEFENCE.toDrawableRes() to Monster.ATTACK.toDrawableRes()
        else -> Monster.HEALTH.toDrawableRes() to Monster.DAMAGE.toDrawableRes()
    }
    val (topText, bottomText) = when {
        (isHero && isHealthAndDamage) -> pair.first[2] to "${pair.first[3]}-${pair.first[4]}"
        (isHero && !isHealthAndDamage) -> pair.first[1] to pair.first[0]
        (!isHero && !isHealthAndDamage) -> pair.second[1] to pair.second[0]
        else -> pair.second[2] to "${pair.second[3]}-${pair.second[4]}"
    }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = topImage),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))

        DrawParameterValue(topText, health)
        Spacer(modifier = Modifier.height(10.dp))

        Image(
            painter = painterResource(id = bottomImage),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(10.dp))

        DrawParameterValue(bottomText, -1)
    }

}

@Composable
fun DrawParameterValue(text: String, health: Int) {
    if (health >= 0) {
        Text(text = health.toString())
    } else Text(text = text)
}
