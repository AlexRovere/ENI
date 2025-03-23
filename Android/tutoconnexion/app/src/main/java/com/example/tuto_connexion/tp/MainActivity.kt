package com.example.tuto_connexion.tp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.tuto_connexion.tp.MainActivity.Routes
import com.example.tuto_connexion.tp.auth.PageForgotPassword
import com.example.tuto_connexion.tp.auth.PageSignIn
import com.example.tuto_connexion.tp.auth.PageSignUp
import com.example.tuto_connexion.tp.auth.viewModel.ResetPasswordViewModel
import com.example.tuto_connexion.tp.auth.viewModel.SignUpViewModel

class MainActivity : ComponentActivity() {

    object Routes {
        const val SIGN_IN = "sign-in"
        const val SIGN_UP = "sign-up"
        const val FORGOT_PASSWORD = "forgot_passwrd"

        const val ARTICLES = "articles"
        const val ARTICLE_DETAIL = "article/detail/{articleId}"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainActivityPage()
        }
    }
}

@Composable
fun MainActivityPage() {
    val signUpViewModel = SignUpViewModel()
    val resetPasswordViewModel = ResetPasswordViewModel()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SIGN_IN){

        composable(Routes.SIGN_IN) {
            PageSignIn(navController = navController)
        }

        composable(Routes.SIGN_UP) {
            PageSignUp(navController = navController, signUpViewModel = signUpViewModel)
        }
        composable(Routes.FORGOT_PASSWORD) {
            PageForgotPassword(navController = navController, resetPasswordViewModel = resetPasswordViewModel)
        }
    }
}

@Composable
@Preview
fun MainActivityPagePreview() {

    MainActivityPage()
}