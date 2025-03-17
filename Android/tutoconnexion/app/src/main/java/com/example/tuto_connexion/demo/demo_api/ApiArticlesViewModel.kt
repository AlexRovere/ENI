package com.example.tuto_connexion.demo.demo_api

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.tuto_connexion.demo.model.ArticleFromApi
import kotlinx.coroutines.flow.MutableStateFlow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiArticlesViewModel : ViewModel() {


    var articles = MutableStateFlow<List<ArticleFromApi>>(mutableListOf())

    fun reloadArticles() {
        sendRequest()
//        articles.value = listOf<ArticleFromApi>(
//            ArticleFromApi(
//                id = 1,
//                title = "PC gamer",
//                desc = "Ceci est le contenu détaillé de l'article.",
//                imgPath = ""
//            )
//        )
    }

    fun sendRequest() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Chocolaterie/EniWebService/refs/heads/main/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val api = retrofit.create(ArticleApi::class.java)

        val call: Call<List<ArticleFromApi>>? = api.getArticles()

        call?.enqueue(object : Callback<List<ArticleFromApi>> {
            override fun onResponse(
                call: Call<List<ArticleFromApi>>, response: Response<List<ArticleFromApi>>
            ) {
                if (response.isSuccessful) {
                    articles.value = response.body()!!
                    Log.d("custom", "Success! Articles: $articles")
                } else {
                    Log.e("custom", "Error response: ${response.errorBody()?.string()}")
                }
            }

            override fun onFailure(call: Call<List<ArticleFromApi>>, t: Throwable) {
                Log.e("custom", "Failed mate: ${t.message}")
            }
        })
    }


}