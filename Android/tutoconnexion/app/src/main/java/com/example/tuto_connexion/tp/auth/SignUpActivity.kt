package com.example.tuto_connexion.tp.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuto_connexion.R
import com.example.tuto_connexion.tp.Routes
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoH1
import com.example.tuto_connexion.ui.theme.TutoInput

@Composable
fun PageSignUp(navController: NavController) {
    TutoBasePage() {
        var pseudo = remember { mutableStateOf("") }
        var email = remember { mutableStateOf("") }
        var password = remember { mutableStateOf("") }
        var passwordConfirmation = remember { mutableStateOf("") }
        var cityCode = remember { mutableStateOf("") }
        var city = remember { mutableStateOf("") }
        var phoneNumber = remember { mutableStateOf("") }

        Spacer(modifier = Modifier.weight(1f))
        TutoH1(title = stringResource(R.string.app_title_sign_up))
        Spacer(modifier = Modifier.weight(1f))
        Column {
            TutoInput(placeholderText = stringResource(R.string.app_field_pseudo_hint), value = pseudo)
            TutoInput(placeholderText = stringResource(R.string.app_field_email_hint), value = email)
            TutoInput(placeholderText = stringResource(R.string.app_field_password_hint), value = password)
            TutoInput(placeholderText = stringResource(R.string.app_field_password_confirmation_hint), value = passwordConfirmation)
            TutoInput(placeholderText = stringResource(R.string.app_field_city_code_hint), value = cityCode)
            TutoInput(placeholderText = stringResource(R.string.app_field_city_hint), value = city)
            TutoInput(placeholderText = stringResource(R.string.app_field_phone_number_hint), value = phoneNumber)
        }
        TutoButton(title = stringResource(R.string.app_title_sign_up), Modifier.fillMaxWidth(),
            onClick = { navController.navigate(Routes.SIGN_IN)})
        Spacer(modifier = Modifier.weight(3f))
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    val navController = rememberNavController()
    PageSignUp(navController)
}