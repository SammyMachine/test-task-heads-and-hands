package com.example.herovsmonster.ui.screens

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.herovsmonster.Dependencies
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class FightViewModel : ViewModel() {


    private val currentFight = Dependencies.fight

    private val _dataFromFight = MutableStateFlow(Pair(listOf(""), listOf("")))
    val dataFromFight = _dataFromFight.asStateFlow()

    val healthValuePlayer: StateFlow<Int> = currentFight.healthValuePlayer
    val healthValueMonster: StateFlow<Int> = currentFight.healthValueMonster

    private val _enableButtons = MutableStateFlow(true)
    val enableButtons = _enableButtons.asStateFlow()

    private val _dealtDamage = MutableStateFlow(Pair("", -1))
    val dealtDamage = _dealtDamage.asStateFlow()

    private val _heroHeal = MutableStateFlow(Pair(-1, -1))
    val heroHeal = _heroHeal.asStateFlow()

    fun resetAll() {
        _dealtDamage.update { "" to -1 }
        _heroHeal.update { -1 to -1 }
    }


    fun getDataFromFight() {
        _dataFromFight.update {
            Pair(
                currentFight.listOfParamValuesPlayer.value.map(Int::toString),
                currentFight.listOfParamValuesMonster.value.map(Int::toString)
            )
        }

    }

    fun restoreHealth() {
        viewModelScope.launch(Dispatchers.IO) {
            _enableButtons.update { false }
            val healInfo = currentFight.playerTurnHeal()
            _heroHeal.update { healInfo }
            _enableButtons.update { true }
        }
    }

    fun playerAttack() {
        viewModelScope.launch(Dispatchers.IO) {
            _enableButtons.update { false }
            var dmg = currentFight.playerTurnAttack()
            _dealtDamage.update { "Hero" to dmg }
            delay(3000)
            dmg = currentFight.monsterTurn()
            _dealtDamage.update { "Monster" to dmg }
            delay(3000)
            _enableButtons.update { true }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                FightViewModel()
            }
        }
    }
}

