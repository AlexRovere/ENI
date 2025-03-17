package com.example.tuto_connexion.tp.article

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuto_connexion.tp.Routes
import com.example.tuto_connexion.tp.data.articles
import com.example.tuto_connexion.tp.model.Article
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoH1

@Composable
fun PageArticleDetail(navController: NavController, article: Article?) {
    TutoBasePage {

        TutoH1(title = "Page detail article")
        TutoBoxCenter {
            TutoButton(title = "Retour à la liste", onClick = { navController.navigate(Routes.ARTICLES) })
        }
        LazyColumn {
            item {
                Column {
                    Text(text = "${article?.id} ${article?.title}")
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PageArticleDetailPreview() {
    val navController = rememberNavController()
    val article : Article? = articles.firstOrNull()
    PageArticleDetail(navController = navController, article = article)
}