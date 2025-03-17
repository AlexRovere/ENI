package com.example.tuto_connexion.demo.demo_mvvm

import androidx.lifecycle.ViewModel
import com.example.tuto_connexion.demo.demo_stateful.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DemoViewModel : ViewModel() {

    private val _persons = MutableStateFlow(listOf<Person>())
    val persons: StateFlow<List<Person>> = _persons

    fun addPerson() {
        _persons.value += Person(pseudo="titi", age= 69)
    }


}