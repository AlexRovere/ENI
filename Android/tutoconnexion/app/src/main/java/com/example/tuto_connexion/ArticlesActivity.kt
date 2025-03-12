package com.example.tuto_connexion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
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
import com.example.tuto_connexion.domain.model.Article
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoH1

val article1 = Article(
    title = "PC gamer",
    description = "Ceci est le contenu détaillé de l'article.",
    imagePath = R.drawable.pc
)

val article2 = Article(
    title = "Bureau gamer",
    description = "Ceci est le contenu détaillé de l'article.",
    imagePath = R.drawable.bureau
)

val article3 = Article(
    title = "Article inconnu",
    description = "Ceci est le contenu détaillé de l'article.",
    imagePath = R.drawable.default_product
)

val articles = listOf<Article>(article1, article2, article3)

class ArticlesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PageArticles(articles)
        }
    }
}

@Composable
fun PageArticles(articles: List<Article>) {
    TutoBasePage {
        TutoH1(title = "Liste des articles")
        LazyColumn(
        ) {
            items(articles) { article ->
                Card(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxWidth(),
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
    PageArticles(articles)
}