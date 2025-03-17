package com.example.tuto_connexion.tp.article.viewModel

import com.example.tuto_connexion.tp.RetrofitTools.Companion.retrofit
import com.example.tuto_connexion.demo.model.ArticleFromApi
import com.example.tuto_connexion.tp.model.Article
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import kotlin.getValue

interface ArticleService {

    @GET("android-articles.json")
    suspend fun getArticles(): List<Article>

    object ArticleAPI {
        val articleService : ArticleService by lazy { retrofit.create(ArticleService::class.java) }
    }
}