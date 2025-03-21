package com.example.tuto_connexion.tp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTools {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("http://165.232.147.139:3000/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}