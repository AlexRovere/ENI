package com.example.tuto_connexion.tp.auth.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuto_connexion.tp.api.AuthService
import com.example.tuto_connexion.tp.api.SignUpRequest
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SignUpViewModel : ViewModel() {

    enum class SignUpField { EMAIL, PASSWORD, PASSWORD_CONFIRM, PSEUDO, CITY_CODE, CITY, PHONE }

    private val _signUpRequest = MutableStateFlow<SignUpRequest>(
        SignUpRequest(
            email = "alex.rovere@hotmail.fr",
            password = "password",
            passwordConfirm = "password",
            pseudo = "ganu",
            cityCode = "66000",
            city = "Perpi",
            phone = "0626262626"
        )
    )
    val signUpRequest = _signUpRequest.asStateFlow()

    fun updateSignUpRequest(key: SignUpField, value: String) {
        when (key) {
            SignUpField.EMAIL -> _signUpRequest.value = _signUpRequest.value.copy(email = value)
            SignUpField.PASSWORD -> _signUpRequest.value =
                _signUpRequest.value.copy(password = value)

            SignUpField.PASSWORD_CONFIRM -> _signUpRequest.value =
                _signUpRequest.value.copy(passwordConfirm = value)

            SignUpField.PSEUDO -> _signUpRequest.value = _signUpRequest.value.copy(pseudo = value)
            SignUpField.CITY_CODE -> _signUpRequest.value =
                _signUpRequest.value.copy(cityCode = value)

            SignUpField.CITY -> _signUpRequest.value = _signUpRequest.value.copy(city = value)
            SignUpField.PHONE -> _signUpRequest.value = _signUpRequest.value.copy(phone = value)
        }
    }

    fun signUp(onSignUpSuccess: () -> Unit = {}) {
        if (signUpRequest.value.email.isBlank()) {
            println("Email obligatoire")
            return
        }
        if (signUpRequest.value.password.isBlank()) {
            println("Password obligatoire")
            return
        }

        viewModelScope.launch {
            AppDialogHelpers.get().showDialog(message = "Création du compte en cours...")
            delay(1000)
            try {
                val apiResponse = AuthService.AuthApi.authApi.signup(signUpRequest.value)
                if (apiResponse.code == "200") {
                    onSignUpSuccess()
                } else {
                    println(apiResponse.message)
                }
            } catch (e: Exception) {
                Log.d("custom", e.message.toString())
            }
            finally {
                AppDialogHelpers.get().closeDialog()
            }
        }
    }
}