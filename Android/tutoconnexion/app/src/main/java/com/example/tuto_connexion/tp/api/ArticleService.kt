package com.example.tuto_connexion.tp.api

import com.example.tuto_connexion.tp.model.Article
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ArticleService {

    @GET("articles")
    suspend fun getArticles(): ResponseApi<List<Article>>

    @GET("articles/{id}")
    suspend fun getArticle(@Path("id") id: String): ResponseApi<Article>

    @DELETE("articles/{id}")
    suspend fun deleteArticle(@Path("id") id: String): ResponseApi<Article>

    @POST("articles/save")
    suspend fun saveArticle(article: Article): ResponseApi<Article>


    object ArticleAPI {
        val articleService : ArticleService by lazy { RetrofitTools.Companion.retrofit.create(ArticleService::class.java) }
    }
}