package com.example.tuto_connexion.demo_intent

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.tuto_connexion.AppNavigation
import com.example.tuto_connexion.AppViewHelper
import com.example.tuto_connexion.MainActivity
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter
import com.example.tuto_connexion.ui.theme.TutoButton

class DemoPage1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoPage1()
        }
    }
}

@Composable
fun DemoPage1() {
    val context = LocalContext.current

    TutoBasePage() {
        TutoBoxCenter {
            TutoButton(
                title = "GO PAGE 2",
                onClick = {
                    AppViewHelper.openActivity(context = context, target = MainActivity::class)
                },
            )
        }
    }

}

@Preview(showBackground = true)
@Composable
fun Home() {
    DemoPage1()
}