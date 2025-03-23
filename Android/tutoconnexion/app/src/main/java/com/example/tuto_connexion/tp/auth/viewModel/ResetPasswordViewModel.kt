package com.example.tuto_connexion.tp.auth.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuto_connexion.tp.api.AuthService
import com.example.tuto_connexion.tp.api.ResetPasswordRequest
import com.example.tuto_connexion.tp.helpers.AppAlertDialogHelpers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ResetPasswordViewModel : ViewModel() {
    var email = MutableStateFlow("isaac@gmail.com")

    fun resetPassword(onResetPasswordSuccess: () -> Unit = {}) {
        if (email.value.isNotBlank()) {
            viewModelScope.launch {
                AppDialogHelpers.get().showDialog(message = "Réinitialisation du mdp en cours...")
                delay(1000)
                try {
                    val apiResponse =
                        AuthService.AuthApi.authApi.resetPassword(ResetPasswordRequest(email.value))
                    if (apiResponse.code == "200") {
                        AppAlertDialogHelpers.get().showDialog(
                            message = apiResponse.message, onClose = { onResetPasswordSuccess() })
                    } else {
                        AppAlertDialogHelpers.get().showDialog(
                            message = apiResponse.message)
                    }
                } catch (e: Exception) {
                    Log.d("custom", e.message.toString())
                } finally {
                    AppDialogHelpers.get().closeDialog()
                }
            }
        }
    }
}