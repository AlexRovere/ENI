package com.example.tuto_connexion.demo.demo_api

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.tuto_connexion.R
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoH1


class ApiArticlesActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PageApiArticles(apiArticlesViewModel = ApiArticlesViewModel())
        }
    }
}

@Composable
fun PageApiArticles(apiArticlesViewModel: ApiArticlesViewModel) {
    val articlesState by apiArticlesViewModel.articles.collectAsState()
    TutoBasePage {

        TutoH1(title = "Liste des articles")
        TutoButton(title = "Fetch articles", onClick = {apiArticlesViewModel.reloadArticles()})
        LazyColumn(
        ) {
            items(articlesState) { article ->
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
                    Row (
                        modifier = Modifier.padding(10.dp),
                    ) {
                        AsyncImage(
                            model= article.imgPath,
                            contentDescription = "c'est pas la",
                            placeholder = painterResource(R.drawable.default_product),
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.width(50.dp).height(50.dp)
                        )
                        Column {
                            Text(text = article.title, fontSize = 20.sp)
                            Text(text = article.desc)
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PageApiArticlesPreview() {
    PageApiArticles(apiArticlesViewModel = ApiArticlesViewModel())
}