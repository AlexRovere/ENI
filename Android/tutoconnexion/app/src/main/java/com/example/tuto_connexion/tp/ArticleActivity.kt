package com.example.tuto_connexion.tp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tuto_connexion.tp.MainActivity.Routes
import com.example.tuto_connexion.tp.article.PageArticleDetail
import com.example.tuto_connexion.tp.article.PageArticles
import com.example.tuto_connexion.tp.article.viewModel.ArticleViewModel
import com.example.tuto_connexion.tp.data.articles

class ArticleActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArticleActivityPage()
        }
    }
}

@Composable
fun ArticleActivityPage() {
    val articleViewModel = ArticleViewModel()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.ARTICLES){

        composable(Routes.ARTICLES) {
            PageArticles(navController = navController, articleViewModel = articleViewModel)
        }
        composable(
            Routes.ARTICLE_DETAIL, arguments = listOf(
                navArgument("articleId") { type = NavType.StringType })
        ) { backStateEntry ->

            val articleId = backStateEntry.arguments?.getString("articleId") ?: ""
//            val isArticleFound = articleViewModel.getArticle(articleId)
//            var article: Article = Article()
//            LaunchedEffect(articleId) {
//                article = articleViewModel.getArticle(articleId)
//            }

            val article = articles.find { it.id == articleId.toIntOrNull() }
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

@Composable
@Preview
fun ArticleActivityPagePreview() {
    ArticleActivityPage()
}