package com.example.herovsmonster.data.model

open class Entity (
    private var attack: Int = 1,
    private var defence: Int = 1,
    private var health: Int = 1,
    private var damage: IntRange = 1..1
) {
    protected var maxHealth = -1
    private var attackModifier = 0

    init {
        checkValidInput()
    }

    fun getEntity(): List<Int> = listOf(attack, defence, health, damage.first, damage.last)

    fun getDefence() = defence

    fun getHealth() = health

    fun changeHealth(value: Int) { health = value }

    fun getDamage(otherDamage: Int) {
        health -= otherDamage
        if (health < 0) health = 0
    }

    fun attackModifier(otherDefence: Int) {
        val modifier = attack - otherDefence + 1
        attackModifier = if (modifier < 0) 1 else modifier
    }

    fun isDied(): Boolean = health == 0

    fun attack(): Int {
        var myDamage = 0
        if (checkSuccess()) myDamage = damage.random()
        return myDamage
    }

    fun setAttack(value: Int) {
        attack = value
    }

    fun setDefence(value: Int) {
        defence = value
    }

    fun setHealth(value: Int) {
        health = value
        maxHealth = health
    }

    fun setDamage(value: IntRange) {
        damage = value
    }

    private fun checkValidInput() {
        if (attack !in 1 .. 30 || defence !in 1 .. 30 || health < 1 || damage.first > damage.last)
            throw IllegalArgumentException("Invalid Input")
    }

    private fun checkSuccess(): Boolean {
        var modifier = attackModifier
        var success = false
        while (modifier != 0) {
            val dice = (1..6).random()
            if (dice > 4) {
                success = true
                break
            } else modifier--
        }
        return success
    }
}


