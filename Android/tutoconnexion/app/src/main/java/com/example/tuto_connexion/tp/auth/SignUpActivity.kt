package com.example.tuto_connexion.tp.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuto_connexion.R
import com.example.tuto_connexion.tp.MainActivity.Routes
import com.example.tuto_connexion.tp.auth.viewModel.SignUpViewModel
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoH1
import com.example.tuto_connexion.ui.theme.TutoInput


@Composable
fun PageSignUp(navController: NavController, signUpViewModel: SignUpViewModel) {
    TutoBasePage() {
        val signUpRequest by signUpViewModel.signUpRequest.collectAsState()

        Spacer(modifier = Modifier.weight(1f))
        TutoH1(title = stringResource(R.string.app_title_sign_up))
        Spacer(modifier = Modifier.weight(1f))
        Column {
            TutoInput(
                placeholderText = stringResource(R.string.app_field_email_hint),
                value = signUpRequest.email,
                onValueChange = {
                    signUpViewModel.updateSignUpRequest(
                        SignUpViewModel.SignUpField.EMAIL,
                        it
                    )
                })
            TutoInput(
                placeholderText = stringResource(R.string.app_field_password_hint),
                value = signUpRequest.password,
                onValueChange = {
                    signUpViewModel.updateSignUpRequest(
                        SignUpViewModel.SignUpField.PASSWORD,
                        it
                    )
                })
            TutoInput(
                placeholderText = stringResource(R.string.app_field_password_confirmation_hint),
                value = signUpRequest.passwordConfirm,
                onValueChange = {
                    signUpViewModel.updateSignUpRequest(
                        SignUpViewModel.SignUpField.PASSWORD_CONFIRM,
                        it
                    )
                })
            TutoInput(
                placeholderText = stringResource(R.string.app_field_pseudo_hint),
                value = signUpRequest.pseudo,
                onValueChange = {
                    signUpViewModel.updateSignUpRequest(
                        SignUpViewModel.SignUpField.PSEUDO,
                        it
                    )
                })
            TutoInput(
                placeholderText = stringResource(R.string.app_field_city_code_hint),
                value = signUpRequest.cityCode,
                onValueChange = {
                    signUpViewModel.updateSignUpRequest(
                        SignUpViewModel.SignUpField.CITY_CODE,
                        it
                    )
                })
            TutoInput(
                placeholderText = stringResource(R.string.app_field_city_hint),
                value = signUpRequest.city,
                onValueChange = {
                    signUpViewModel.updateSignUpRequest(
                        SignUpViewModel.SignUpField.CITY,
                        it
                    )
                })
            TutoInput(
                placeholderText = stringResource(R.string.app_field_phone_hint),
                value = signUpRequest.phone,
                onValueChange = {
                    signUpViewModel.updateSignUpRequest(
                        SignUpViewModel.SignUpField.PHONE,
                        it
                    )
                })
        }
        TutoButton(
            title = stringResource(R.string.app_title_sign_up),
            Modifier.fillMaxWidth(),
            onClick = {
                signUpViewModel.signUp(onSignUpSuccess = {
                    navController.navigate(Routes.SIGN_IN)
                })
            })
        Spacer(modifier = Modifier.weight(3f))
    }
}

@Preview(showBackground = true)
@Composable
fun SignUpPreview() {
    val navController = rememberNavController()
    PageSignUp(navController, signUpViewModel = SignUpViewModel())
}