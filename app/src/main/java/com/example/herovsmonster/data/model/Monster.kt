package com.example.herovsmonster.data.model

class Monster(
    attack: Int = 1,
    defence: Int = 1,
    health: Int = 1,
    damage: IntRange = 1..1
): Entity(attack, defence, health, damage) {

    fun setMonster(listOfParamValues: List<Int>) {
        setAttack((1..30).random())
        setDefence((1..30).random())
        setHealth(listOfParamValues[3] * 10 + listOfParamValues[4] * 3)
        setDamage(listOfParamValues[2] / 10 + 1..listOfParamValues[2] / 4 + 1)
    }
}