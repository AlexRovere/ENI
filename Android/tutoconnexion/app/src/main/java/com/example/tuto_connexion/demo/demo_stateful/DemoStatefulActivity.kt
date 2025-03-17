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

class DemoStatefulActivity : ComponentActivity() {
    // Variable écoutable
    var counter = MutableStateFlow<Int>(0)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoStatefullPage(counter)
        }
    }
}

@Composable
fun DemoStatefullPage(counter: MutableStateFlow<Int> = MutableStateFlow<Int>(0)) {
    // écouter la variable
    val counterState by counter.collectAsState()
    TutoBasePage {
        TutoBoxCenter {
            Column(
                verticalArrangement = Arrangement.spacedBy(
                    space = 30.dp
                ),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                TutoText(title = "${counterState}")
                TutoButton(
                    title = "Incrementer",
                    onClick = {counter.value++}
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DemoStatefullPagePreview() {
    DemoStatefullPage()
}