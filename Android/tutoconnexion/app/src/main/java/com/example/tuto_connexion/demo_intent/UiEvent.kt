package com.example.tuto_connexion.demo_intent

// Permet de gérer plusieurs events pour une activité
sealed class UiEvent {
    object OnInit : UiEvent()
    object OnGenerateClick : UiEvent()
    object OnGenerateRandomName : UiEvent()
}