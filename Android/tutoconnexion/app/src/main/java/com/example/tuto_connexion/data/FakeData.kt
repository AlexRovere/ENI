package com.example.tuto_connexion.data

import com.example.tuto_connexion.R
import com.example.tuto_connexion.demo.model.Article

val article1 = Article(
    id = 1,
    title = "PC gamer",
    description = "Ceci est le contenu détaillé de l'article.",
    imagePath = R.drawable.pc
)

val article2 = Article(
    id = 2,
    title = "Bureau gamer",
    description = "Ceci est le contenu détaillé de l'article.",
    imagePath = R.drawable.bureau
)

val article3 = Article(
    id = 3,
    title = "Article inconnu",
    description = "Ceci est le contenu détaillé de l'article.",
    imagePath = R.drawable.default_product
)
val articles = listOf<Article>(article1, article2, article3)
