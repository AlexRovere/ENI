package com.example.tuto_connexion.tp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTools {
    companion object{
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/Chocolaterie/EniWebService/refs/heads/main/api/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }
}