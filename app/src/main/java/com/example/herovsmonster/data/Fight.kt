package com.example.herovsmonster.data

import android.util.Log
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.herovsmonster.data.model.Monster
import com.example.herovsmonster.data.model.Player
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class Fight {

    private lateinit var player: Player
    private lateinit var monster: Monster

    private val _listOfParamValuesPlayer = MutableStateFlow(mutableListOf<Int>())
    val listOfParamValuesPlayer = _listOfParamValuesPlayer.asStateFlow()

    private val _listOfParamValuesMonster = MutableStateFlow(mutableListOf<Int>())
    val listOfParamValuesMonster = _listOfParamValuesMonster.asStateFlow()

    private val _healthValuePlayer = MutableStateFlow(-1)
    val healthValuePlayer = _healthValuePlayer.asStateFlow()

    private val _healthValueMonster = MutableStateFlow(-1)
    val healthValueMonster = _healthValueMonster.asStateFlow()

    private lateinit var heroDealtDamage: Pair<String, Int>
    private lateinit var monsterDealtDamage: Pair<String, Int>


    fun getHeroDamage(): Pair<String, Int> = heroDealtDamage

    fun getMonsterDamage(): Pair<String, Int> = monsterDealtDamage

    fun setEntity(listOfParamValues: MutableList<Int>) {
        player = Player()
        monster = Monster()

        _healthValuePlayer.update { -1 }
        _healthValueMonster.update { -1 }

        player.setPlayer(listOfParamValues)
        monster.setMonster(listOfParamValues)

        _listOfParamValuesPlayer.update { getPlayer().toMutableList() }
        _listOfParamValuesMonster.update { getMonster().toMutableList() }
    }

    private fun getPlayer(): List<Int> = player.getEntity()

    private fun getMonster(): List<Int> = monster.getEntity()

    fun playerTurnAttack(): Int {
        player.attackModifier(monster.getDefence())
        val attack = player.attack()
        monster.getDamage(attack)
        _healthValueMonster.update { monster.getHealth() }
        return attack
    }

    fun playerTurnHeal(): Pair<Int, Int> {
        var info = player.getHealth()
        player.restoreHealth()
        _healthValuePlayer.update { player.getHealth() }
        info = player.getHealth() - info
        return Pair(info, 4 - player.getHealCount())
    }

    fun monsterTurn(): Int {
        monster.attackModifier(player.getDefence())
        val attack = monster.attack()
        player.getDamage(attack)
        _healthValuePlayer.update { player.getHealth() }
        return attack
    }
}