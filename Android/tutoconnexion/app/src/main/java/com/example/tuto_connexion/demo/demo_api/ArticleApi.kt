package com.example.tuto_connexion.demo.demo_api

import com.example.tuto_connexion.demo.model.ArticleFromApi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface ArticleApi {
    @Headers(
        "Accept: application/json"
    )
    @GET("android-articles.json")
    abstract fun getArticles(): Call<List<ArticleFromApi>>?
}