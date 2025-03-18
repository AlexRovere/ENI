package com.example.tuto_connexion.tp.article.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuto_connexion.tp.model.Article
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {

    var articles = MutableStateFlow<List<Article>>(mutableListOf())

    fun reloadArticles() {
        AppDialogHelpers.get().showDialog(message = "Chargements des articles en cours...")
        viewModelScope.launch {
            delay(1000)
            val apiResponse = ArticleService.ArticleAPI.articleService.getArticles()
            articles.value = apiResponse
            AppDialogHelpers.get().closeDialog()
        }
    }

    fun addArticle () {
       val newArticle : Article = Article(id = 4, title = "nouveau article", desc = "toujours nouveau", imgPath = "" )
        articles.value += newArticle
    }

    fun deleteArticle (article: Article) {
        articles.value -= article
    }

    init {
        reloadArticles()
    }

}