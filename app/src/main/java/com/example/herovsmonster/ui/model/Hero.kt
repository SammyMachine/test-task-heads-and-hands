package com.example.herovsmonster.ui.model

import com.example.herovsmonster.R

enum class Hero {
    HEALTH {
        override fun toDrawableRes(): Int = R.drawable.hero_health
        override fun toStringResource(): Int = R.string.hero_health
    },
    DAMAGE {
        override fun toDrawableRes(): Int = R.drawable.hero_damage
        override fun toStringResource(): Int = R.string.hero_damage
    },
    DEFENCE {
        override fun toDrawableRes(): Int = R.drawable.hero_defence
        override fun toStringResource(): Int = R.string.hero_defence
    },
    ATTACK {
        override fun toDrawableRes(): Int = R.drawable.hero_attack
        override fun toStringResource(): Int = R.string.hero_attack
    };

    abstract fun toDrawableRes(): Int
    abstract fun toStringResource(): Int
}