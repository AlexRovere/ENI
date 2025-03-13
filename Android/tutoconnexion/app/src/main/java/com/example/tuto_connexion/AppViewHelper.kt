package com.example.tuto_connexion

import android.content.Context
import android.content.Intent
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