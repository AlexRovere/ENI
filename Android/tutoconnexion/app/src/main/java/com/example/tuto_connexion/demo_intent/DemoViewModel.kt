package com.example.tuto_connexion.demo_intent

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.tuto_connexion.demo_intent.data.RandomName

// Permet de gérer les events et modifier les states
class DemoViewModel(private val dataSrc: RandomName) : ViewModel() {

    val clickNumber: MutableState<Int> = mutableIntStateOf(0)
    val uiState : MutableState<UiState> = mutableStateOf(UiState())

    init {
        this.onUiEvent(UiEvent.OnInit)
    }

    fun onUiEvent(uiEvent: UiEvent) {
        when(uiEvent) {
            is UiEvent.OnInit  -> {
                uiState.value = UiState(currentName = dataSrc.getRandomName())
                Log.i("custom", "on init")

            }
            is UiEvent.OnGenerateClick-> {
                uiState.value = uiState.value.copy(currentNumber = uiState.value.currentNumber + 1)
                Log.i("custom", "on generate click")
            }

            is UiEvent.OnGenerateRandomName -> {
                uiState.value = uiState.value.copy(currentName = dataSrc.getRandomName())
                Log.i("custom", "on generate random name")
            }
        }
    }
}