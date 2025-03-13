package com.example.tuto_connexion

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuto_connexion.data.articles
import com.example.tuto_connexion.domain.model.Article
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoH1

@Composable
fun PageArticles(navController: NavController, articles: List<Article>) {
    TutoBasePage {
        TutoBoxCenter {
            TutoButton(title = "Déconnexion", onClick = { navController.navigate(Routes.SIGN_IN) })
        }
        TutoH1(title = "Liste des articles")
        LazyColumn(
        ) {
            items(articles) { article ->
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth()
                        .clickable(
//                            onClick = { navController.navigate("article/detail/${article.id}" ) }

                            onClick = { navController.navigate(Routes.ARTICLE_DETAIL.replace("{articleId}", article.id.toString())) }
                        ),
                    shape = CardDefaults.outlinedShape,
                    colors = CardDefaults.cardColors(
                        containerColor = Color(0xAAFFFFFF),
                        contentColor = Color.Black
                    )
                ) {
                    Column(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Image(
                            painter = painterResource(id = article.imagePath),
                            contentDescription = article.title,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp),
                            contentScale = ContentScale.Crop
                        )
                        Text(text = article.title, fontSize = 20.sp)
                        Text(text = article.description)
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PageArticlesPreview() {
    val navController = rememberNavController()
    PageArticles(navController = navController, articles = articles)
}