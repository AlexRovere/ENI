package com.example.tuto_connexion.demo_intent

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tuto_connexion.AppViewHelper
import com.example.tuto_connexion.MainActivity
import com.example.tuto_connexion.demo_intent.data.DataSrc
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoText

class DemoPage1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoPage1(DemoViewModel(dataSrc = DataSrc()))
        }
    }
}

@Composable
fun DemoPage1(viewModel: DemoViewModel) {
    val context = LocalContext.current
    val clickNumber = viewModel.clickNumber
    val uiState = viewModel.uiState

    TutoBasePage {
        TutoBoxCenter {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 30.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TutoButton(
                    title = "GO PAGE d'accueil",
                    onClick = {
                        AppViewHelper.openActivity(context = context, target = MainActivity::class)
                    },
                )
                TutoButton(
                    title = "Incrementer state simple",
                    onClick = {
                        clickNumber.value++
                    },
                )
                TutoText(title = "Nombre de click state simple =  ${clickNumber.value}")

                TutoButton(
                    title = "Generate random name UiState",
                    onClick = {
                        viewModel.onUiEvent(UiEvent.OnGenerateRandomName)
                    },
                )
                TutoText(title = "Nom random UiState = ${uiState.value.currentName}")

                TutoButton(
                    title = "Increment number UiState",
                    onClick = {
                        viewModel.onUiEvent(UiEvent.OnGenerateClick)
                    },
                )
                TutoText(title = "Nombre de click  UiState = ${uiState.value.currentNumber}")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Home() {
    DemoPage1(DemoViewModel(dataSrc = DataSrc()))
}