package com.example.tuto_connexion.tp.article.viewModel

import AppDialogHelpers
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuto_connexion.tp.api.ArticleService
import com.example.tuto_connexion.tp.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {

    var articles = MutableStateFlow<List<Article>>(mutableListOf())
//    var article = MutableStateFlow(Article())

    fun reloadArticles() {
        viewModelScope.launch {
            AppDialogHelpers.get().showDialog(message = "Chargements des articles en cours...")
            val apiResponse = ArticleService.ArticleAPI.articleService.getArticles()
            println(apiResponse.message)
            if (apiResponse.code == "200") {
                articles.value = apiResponse.data!!
            }
            AppDialogHelpers.get().closeDialog()
        }
    }

    fun addArticle() {
        val newArticle: Article =
            Article(id = 4, title = "nouveau article", desc = "toujours nouveau", imgPath = "")
        articles.value += newArticle
    }

    fun deleteArticle(article: Article) {
        articles.value -= article
    }
//
//    fun getArticle(id: String): Article? {
//        var article : Article = Article()
//        viewModelScope.launch {
//            val apiResponse = ArticleService.ArticleAPI.articleService.getArticle(id)
//            if (apiResponse.code == "200") {
//                article = apiResponse.data!!
//            }
//        }
//        return article
//    }


    init {
        reloadArticles()
    }

}