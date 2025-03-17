package com.example.tuto_connexion.tp.data
import com.example.tuto_connexion.tp.model.Article

val article1 = Article(
    id = 1,
    title = "PC gamer",
    desc = "Ceci est le contenu détaillé de l'article.",
    imgPath = ""
)

val article2 = Article(
    id = 2,
    title = "Bureau gamer",
    desc = "Ceci est le contenu détaillé de l'article.",
    imgPath = ""
)

val article3 = Article(
    id = 3,
    title = "Article inconnu",
    desc = "Ceci est le contenu détaillé de l'article.",
    imgPath = ""
)
val articles = listOf<Article>(article1, article2, article3)
