package com.example.tuto_connexion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoH1
import com.example.tuto_connexion.ui.theme.TutoInput

class ForgotPasswordActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PageForgotPassword()
        }
    }
}

@Composable
fun PageForgotPassword() {
    TutoBasePage() {
        Spacer(modifier = Modifier.weight(1f))
        TutoH1("Récupération de mot de passe")
        Spacer(modifier = Modifier.weight(1f))
        TutoInput(placeholderText = "Email")

        TutoButton(title = "ENVOYER LE LIEN DE RECUPRATION", Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.weight(3f))

        TutoBoxCenter {
            Text(
                text = "Le prochaine fois n'oublie pas ton mot de passe mec !",
                textAlign = TextAlign.Center,
                color = Color(0x88FFFFFF),
                fontSize = 20.sp
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ForgotPasswordPreview() {
    PageForgotPassword()
}