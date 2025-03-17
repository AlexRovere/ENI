package com.example.tuto_connexion.demo_mvvm

import androidx.lifecycle.ViewModel
import com.example.tuto_connexion.demo_stateful.Person
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class DemoViewModel : ViewModel() {
//    var persons = MutableStateFlow<List<Person>>(
//        mutableListOf(
//            Person(pseudo="Alex", age = 34),
//            Person(pseudo="Marine", age= 40)
//        )
//    )

    private val _persons = MutableStateFlow(listOf<Person>())
    val persons: StateFlow<List<Person>> = _persons

    fun addPerson() {
//        persons.value += Person(pseudo="titi", age= 69)
        _persons.value = _persons.value.add(Person(pseudo="titi", age= 69))
    }


}