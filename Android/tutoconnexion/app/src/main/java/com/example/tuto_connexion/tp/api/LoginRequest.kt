package com.example.tuto_connexion.tp.api

data class LoginRequest (val email: String = "", val password: String = "") {
    override fun toString(): String {
        return "$email $password"
    }
}