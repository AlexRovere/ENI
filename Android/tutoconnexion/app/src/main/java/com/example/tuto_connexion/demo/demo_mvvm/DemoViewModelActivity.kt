package com.example.tuto_connexion.demo.demo_mvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoText


class DemoViewModelActivity : ComponentActivity() {
    var viewModel = DemoViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoViewModelActivityPage(viewModel)
        }
    }
}

@Composable
fun DemoViewModelActivityPage(viewModel: DemoViewModel) {
    // écouter la variable persons
    val personsState by viewModel.persons.collectAsState()
    TutoBasePage {
        TutoBoxCenter {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 30.dp
                ), horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn(
                ) {
                    items(personsState) { person ->
                        TutoText(title = person.pseudo)
                    }
                }
                TutoButton(title="Ajouter une personne", onClick = {
                    viewModel.addPerson()
                })
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoViewModelActivityPagePreview() {
    var viewModel = DemoViewModel()
    DemoViewModelActivityPage(viewModel)
}