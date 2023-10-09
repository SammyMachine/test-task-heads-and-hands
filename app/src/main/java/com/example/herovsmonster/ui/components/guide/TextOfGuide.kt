package com.example.herovsmonster.ui.components.guide

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

@Composable
fun DrawTextOfGuide() {
    Text(
        text = userGuideText,
        style = TextStyle(
            fontSize = 19.sp,
            color = Color(84, 66, 60),
            drawStyle = Stroke(
                width = 5f,
                miter = 1f,
                join = StrokeJoin.Round
            ),
            letterSpacing = 1.sp
        ),
    )
}

const val userGuideText = """
    User Guide for the Game

    Welcome to the game! In this adventure, you will encounter creatures, including the Player and Monsters. Each creature has various attributes and abilities, and your goal is to navigate through the challenges they present. Let's get started with the basics.

    Creatures

    1. Player
    - The Player is your character, and you control their actions.
    - The Player has two primary attributes: Attack and Defense, both ranging from 1 to 30.
    - Health is a crucial factor for the Player. It's a natural number that ranges from 0 to N. If the Player's health reaches 0, they perish.
    - The Player has a special ability: they can heal themselves up to 4 times, restoring 30% of their maximum health.

    2. Monsters
    - Monsters are formidable opponents that the Player must face.
    - Like the Player, Monsters also possess Attack and Defense attributes, ranging from 1 to 30.
    - Similar to the Player, Monsters have a Health stat, which must be depleted to defeat them.
    - Monsters can deal damage to the Player within a specific range, defined by the Damage parameter (e.g., 1-6).

    Combat

    In the game, creatures engage in combat by attempting to strike each other. Here's how combat works:

    1. Attack Modifier Calculation
       - The attacking creature's Attack minus the defending creature's Defense, plus 1, determines the Attack Modifier.

    2. Determining Success
       - Success in an attack is determined by rolling a number of six-sided dice equal to the Attack Modifier.
       - There is always at least one die rolled.
       - An attack is considered successful if at least one die shows a 5 or 6.

    3. Damage Calculation
       - If the attack is successful, a random value within the Damage parameter of the attacking creature is subtracted from the Health of the defending creature.

    Healing

    The Player has the ability to heal themselves. Here's how it works:

    - The Player can use healing up to 4 times.
    - Each healing session restores 30% of the Player's maximum health.

    Strategy Tips

    - To survive and succeed in the game, carefully manage your character's Attack, Defense, and Health.
    - Use healing wisely, as it's a limited resource.
    - Be strategic in combat, as successful attacks can turn the tide of battle.

    Good luck on your adventure, and may you emerge victorious in your encounters with the creatures of this world!
"""
