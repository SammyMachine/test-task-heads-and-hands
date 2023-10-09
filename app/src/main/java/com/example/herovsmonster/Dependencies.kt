package com.example.herovsmonster

import com.example.herovsmonster.data.Fight

object Dependencies {
    val fight: Fight by lazy { Fight() }
}