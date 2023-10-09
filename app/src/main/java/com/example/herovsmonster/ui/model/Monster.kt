package com.example.herovsmonster.ui.model

import com.example.herovsmonster.R

enum class Monster {
    HEALTH {
        override fun toDrawableRes(): Int = R.drawable.monster_health
        override fun toStringResource(): Int = R.string.monster_health
    },
    DAMAGE {
        override fun toDrawableRes(): Int = R.drawable.monster_damage
        override fun toStringResource(): Int = R.string.monster_damage
    },
    DEFENCE {
        override fun toDrawableRes(): Int = R.drawable.monster_defence
        override fun toStringResource(): Int = R.string.monster_defence
    },
    ATTACK {
        override fun toDrawableRes(): Int = R.drawable.monster_attack
        override fun toStringResource(): Int = R.string.monster_attack
    };

    abstract fun toDrawableRes(): Int
    abstract fun toStringResource(): Int
}