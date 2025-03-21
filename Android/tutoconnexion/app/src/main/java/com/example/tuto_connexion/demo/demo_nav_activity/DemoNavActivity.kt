package com.example.tuto_connexion.demo.demo_nav_activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter


class DemoNavActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoNavActivityPage()
        }
    }
}

@Composable
fun DemoNavActivityPage() {
    TutoBasePage {
        TutoBoxCenter {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoNavActivityPagePreview() {
    DemoNavActivityPage()
}