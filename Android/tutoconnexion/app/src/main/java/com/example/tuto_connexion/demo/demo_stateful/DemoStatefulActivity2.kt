package com.example.tuto_connexion.demo.demo_stateful

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoText
import kotlinx.coroutines.flow.MutableStateFlow
import androidx.compose.runtime.getValue

class DemoStateful2Activity : ComponentActivity() {
    // Variable écoutable
    var person = MutableStateFlow<Person>(Person(pseudo = "Alex", age = 34))
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoStateful2Page(person)
        }
    }
}

@Composable
fun DemoStateful2Page(person: MutableStateFlow<Person>) {
    // écouter la variable
    val personState by person.collectAsState()
    TutoBasePage {
        TutoBoxCenter {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 30.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TutoText(title = "Nom ${personState.pseudo}, Age ${personState.age}")
                TutoButton(
                    title = "Incrementer",
                    onClick = {person.value = person.value.copy(age = person.value.age + 1)}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoStateful2PagePreview() {
    var person = MutableStateFlow<Person>(Person(pseudo = "Alex", age = 34))
    DemoStateful2Page(person)
}