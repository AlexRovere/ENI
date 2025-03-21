package com.example.tuto_connexion.tp.auth

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuto_connexion.tp.Routes
import com.example.tuto_connexion.tp.auth.viewModel.ResetPasswordViewModel
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoH1
import com.example.tuto_connexion.ui.theme.TutoInput

@Composable
fun PageForgotPassword(
    navController: NavController,
    resetPasswordViewModel: ResetPasswordViewModel
) {
    val email by resetPasswordViewModel.email.collectAsState()
    TutoBasePage() {
//        var email = MutableStateFlow("")
//        val emailState by email.collecAsState()

        Spacer(modifier = Modifier.weight(1f))
        TutoH1("Récupération de mot de passe")
        Spacer(modifier = Modifier.weight(1f))
        TutoInput(
            placeholderText = "Email",
            value = email,
            onValueChange = { resetPasswordViewModel.email.value = it })

        TutoButton(
            title = "ENVOYER LE LIEN DE RECUPRATION", Modifier.fillMaxWidth(),
            onClick = { resetPasswordViewModel.resetPassword(
                onResetPasswordSuccess = {navController.navigate(Routes.SIGN_IN)}
            ) })
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
    val navController = rememberNavController()
    PageForgotPassword(navController, resetPasswordViewModel = ResetPasswordViewModel())
}