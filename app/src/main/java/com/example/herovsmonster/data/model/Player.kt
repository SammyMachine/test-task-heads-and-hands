package com.example.herovsmonster.data.model

import kotlin.math.roundToInt

class Player(
    attack: Int = 1,
    defence: Int = 1,
    health: Int = 1,
    damage: IntRange = 1..1
) : Entity(attack, defence, health, damage) {

    private var healBonus = 0
    private var healCount = 0

    fun getHealCount(): Int = healCount

    fun restoreHealth() {
        var health = this.getHealth()

        if (health in 1 until maxHealth && healCount < 4) {
            health += healBonus
            if (health > maxHealth) health = maxHealth
            healCount++
            this.changeHealth(health)
        }
    }

    fun setPlayer(listOfParamValues: List<Int>) {
        setAttack(listOfParamValues[0])
        setDefence(listOfParamValues[1])
        setHealth(listOfParamValues[2])
        healBonus = (maxHealth * 0.3).roundToInt()
        setDamage(listOfParamValues[3]..listOfParamValues[4])
    }
}
