package com.example.herovsmonster.ui.screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.herovsmonster.Dependencies
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class StartViewModel : ViewModel() {

    private val presetFight = Dependencies.fight

    private val listOfValues = mutableListOf("", "", "", "", "")

    private val _validInput = MutableStateFlow(false)
    val validInput = _validInput.asStateFlow()

    fun updateList(pos: Int, value: String) {
        viewModelScope.launch(Dispatchers.IO) {
            listOfValues[pos] = value
            checkFieldsFull()
        }
    }

    private fun checkFieldsFull() {
        val flag =
            listOfValues[0] != "" && listOfValues[1] != "" && listOfValues[2] != "" && listOfValues[3] != "" && listOfValues[4] != ""
        if (flag) checkValidInput()
    }

    private fun checkValidInput() {
        val flag = mutableListOf(1, 1, 1, 1)
        if (!(listOfValues[0].matches(Regex("^[1-9](\\d?)\$")) && listOfValues[0].toInt() in 1..30)) {
            flag[0] = 0
            //throw IllegalArgumentException()
        } else flag[0] = 1
        if (!(listOfValues[1].matches(Regex("^[1-9](\\d?)\$")) && listOfValues[1].toInt() in 1..30)) {
            flag[1] = 0
            //throw IllegalArgumentException()
        } else flag[1] = 1
        if (!(listOfValues[2].matches(Regex("^[1-9][0-9]*\$")) && listOfValues[2].toInt() > 0)) {
            flag[2] = 0
            //throw IllegalArgumentException()
        } else flag[2] = 1
        if (!(listOfValues[3].matches(Regex("^[1-9][0-9]*\$")) && listOfValues[4].matches(
                Regex("^[1-9][0-9]*\$")
            ) && listOfValues[3].toInt() < listOfValues[4].toInt())
        ) {
            flag[3] = 0
            //throw IllegalArgumentException()
        } else flag[3] = 1
        if (!flag.contains(0)) setDataInFight()
        _validInput.update { !flag.contains(0) }
    }

    private fun setDataInFight() {
        val list = listOfValues.map(String::toInt).toMutableList()
        presetFight.setEntity(list)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                StartViewModel()
            }
        }
    }

}