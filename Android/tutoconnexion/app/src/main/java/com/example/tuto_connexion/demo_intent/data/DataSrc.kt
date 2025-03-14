package com.example.tuto_connexion.demo_intent.data

class DataSrc : RandomName {
    private var names : List<String> = listOf("bob", "jean", "stephane", "alice")
    override fun getRandomName() = names.random()
}