package com.example.tuto_connexion.tp.helpers

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuto_connexion.tp.api.ResponseApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

open class EniViewModel : ViewModel() {

     fun <T>genericApiCall(progressMessage: String, onExec: suspend () -> ResponseApi<T>, onFinish: (ResponseApi<T>) -> Unit) {
        AppDialogHelpers.get().showDialog(message = progressMessage)
        viewModelScope.launch {
            delay(1000)
            try {
                val apiResponse = onExec()
                onFinish(apiResponse)
            } catch (e: Exception) {
                Log.d("custom", e.message.toString())
            } finally {
                AppDialogHelpers.get().closeDialog()
            }
        }
    }
}