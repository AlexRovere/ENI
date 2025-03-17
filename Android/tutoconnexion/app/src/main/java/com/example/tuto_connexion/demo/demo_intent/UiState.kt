package com.example.tuto_connexion.demo.demo_intent

// Permet de gérer plusieurs states pour un activité
data class UiState(
    val currentName: String = "",
    val currentNumber: Int = 0
)