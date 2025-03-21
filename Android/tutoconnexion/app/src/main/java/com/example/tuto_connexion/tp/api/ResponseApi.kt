package com.example.tuto_connexion.tp.api

class ResponseApi<T>(var code : String = "", var message : String = "", var data : T?) {
}