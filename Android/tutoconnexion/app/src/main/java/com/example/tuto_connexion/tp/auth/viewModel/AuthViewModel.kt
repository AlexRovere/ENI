package com.example.tuto_connexion.tp.auth.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuto_connexion.tp.api.AuthService
import com.example.tuto_connexion.tp.api.LoginRequest
import com.example.tuto_connexion.tp.api.SignUpRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlin.reflect.typeOf


class AuthViewModel : ViewModel() {

    private val _email = MutableStateFlow("isaac@gmail.com")
    val email = _email.asStateFlow()

    private val _password = MutableStateFlow("password")
    val password = _password.asStateFlow()

    private val _isConnected = MutableStateFlow(false)
    val isConnected = _isConnected.asStateFlow()

    private val _token = MutableStateFlow("")
    val token = _token.asStateFlow()

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updatePassword(newPassword: String) {
        _password.value = newPassword
    }

    fun logout(onLogoutSuccess: () -> Unit = {}) {
        viewModelScope.launch {
            AppDialogHelpers.get().showDialog(message = "Déconnexion en cours...")
            delay(1000)
            _isConnected.value = false
            _token.value = ""
            AppDialogHelpers.get().closeDialog()
            onLogoutSuccess()
        }
    }

    fun login(onLoginSucess: () -> Unit = {}) {
        if (email.value.isBlank()) {
            println("Email obligatoire")
            return
        }
        if (password.value.isBlank()) {
            println("Password obligatoire")
            return
        }
        val request = LoginRequest(
            email = email.value, password = password.value
        )

        viewModelScope.launch {
            AppDialogHelpers.get().showDialog(message = "Connexion en cours...")
            delay(1000)

            try {
                val apiResponse = AuthService.AuthApi.authApi.login(request)
                if (apiResponse.code == "200") {
                    _isConnected.value = true
                    _token.value = apiResponse.data!!
                    onLoginSucess()
                } else {
                    println(apiResponse.message)
                }
            } catch (e: Exception) {
                Log.d("custom", e.message.toString())
            } finally {
                AppDialogHelpers.get().closeDialog()

            }
        }
    }

}