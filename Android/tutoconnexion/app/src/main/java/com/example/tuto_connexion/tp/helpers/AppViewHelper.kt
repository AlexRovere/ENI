package com.example.tuto_connexion.tp.helpers

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.tuto_connexion.tp.api.AuthService
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.reflect.KClass

class AppViewHelper {

    // java static function
    companion object {
        fun openActivity(context: Context, target: KClass<*>) {
            val intent = Intent(context, target.java)
            context.startActivity(intent)
        }
    }
}