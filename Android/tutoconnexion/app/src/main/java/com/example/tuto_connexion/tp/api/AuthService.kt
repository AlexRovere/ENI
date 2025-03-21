package com.example.tuto_connexion.tp.api

import com.example.tuto_connexion.tp.model.Article
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface AuthService {

    @POST("login")
    suspend fun login(@Body login: LoginRequest): ResponseApi<String>

    @POST("signup")
    suspend fun signup(@Body login: SignUpRequest): ResponseApi<SignUpRequest>

    @POST("reset-password")
    suspend fun resetPassword(@Body email: ResetPasswordRequest): ResponseApi<String>

    @GET("check")
    suspend fun check(): ResponseApi<String>

    object AuthApi {
        val authApi: AuthService by lazy { RetrofitTools.Companion.retrofit.create(AuthService::class.java) }
    }
}