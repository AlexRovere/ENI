package com.example.tuto_connexion

import android.util.Log
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tuto_connexion.data.articles

object Routes {
    const val SIGN_IN = "sign-in"
    const val SIGN_UP = "sign-up"
    const val FORGOT_PASSWORD = "forgot_passwrd"

    const val ARTICLES = "articles"
    const val ARTICLE_DETAIL = "article/detail/{articleId}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Routes.SIGN_IN,
    ) {
        composable(Routes.SIGN_IN) {
            PageSignIn(navController = navController)
        }
        composable(Routes.SIGN_UP) {
            PageSignUp(navController = navController)
        }
        composable(Routes.FORGOT_PASSWORD) {
            PageForgotPassword(navController = navController)
        }
        composable(Routes.ARTICLES) {
            PageArticles(navController = navController, articles = articles)
        }
        composable(
            Routes.ARTICLE_DETAIL, arguments = listOf(
                navArgument("articleId") { type = NavType.StringType })
        ) { backStateEntry ->

            val articleId = backStateEntry.arguments?.getString("articleId") ?: ""
            val article = articles.find { it.id == articleId.toIntOrNull() }
            Log.d("custom", "je te log la geule !")
            if(article !== null) {
                PageArticleDetail(navController = navController, article = article)
            } else {
                // Si article non trouvé
                navController.navigate(Routes.ARTICLES) {
                    // supprimer l'historique de retour
                    popUpTo(Routes.ARTICLES) { inclusive = true }

                }
            }

        }
    }
}
