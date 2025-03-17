package com.example.tuto_connexion.tp.article.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tuto_connexion.tp.model.Article
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : ViewModel() {

    var articles = MutableStateFlow<List<Article>>(mutableListOf())

    fun reloadArticles() {
        sendRequest()
    }

    fun sendRequest() {
        viewModelScope.launch{
            val apiResponse = ArticleService.ArticleAPI.articleService.getArticles()
            articles.value = apiResponse
        }
    }
}