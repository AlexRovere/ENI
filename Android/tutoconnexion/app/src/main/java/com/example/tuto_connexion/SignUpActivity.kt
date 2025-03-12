package com.example.tuto_connexion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoH1
import com.example.tuto_connexion.ui.theme.TutoInput

class SignUpActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PageSignUp()
        }
    }
}

@Composable
fun PageSignUp() {
    TutoBasePage() {
        Spacer(modifier = Modifier.weight(1f))
        TutoH1("Sign In")
        Spacer(modifier = Modifier.weight(1f))
        Column {
            TutoInput(placeholderText = "Pseudo")
            TutoInput(placeholderText = "Email")
            TutoInput(placeholderText = "Password")
            TutoInput(placeholderText = "Password Confirmation")
            TutoInput(placeholderText = "City Code")
            TutoInput(placeholderText = "City")
            TutoInput(placeholderText = "Phone Number")
        }
        TutoButton(title ="SIGN IN", Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.weight(3f))
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    PageSignUp()
}