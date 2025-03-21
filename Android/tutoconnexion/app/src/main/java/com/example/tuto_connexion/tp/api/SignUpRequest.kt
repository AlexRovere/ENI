package com.example.tuto_connexion.tp.api

data class SignUpRequest(
    val email: String = "",
    val password: String = "",
    val passwordConfirm: String = "",
    val pseudo: String = "",
    val cityCode: String = "",
    val city: String = "",
    val phone: String = "",
    )
