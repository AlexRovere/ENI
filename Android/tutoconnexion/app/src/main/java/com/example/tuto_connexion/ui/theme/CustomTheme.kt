package com.example.tuto_connexion.ui.theme

import ProgressDialog
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.tuto_connexion.R

@Composable
fun TutoInput(placeholderText: String, icone: ImageVector? = null, value: MutableState<String> = mutableStateOf("") ) {
    Box(modifier = Modifier.padding(vertical = 10.dp)) {
        TextField(
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color(0x55000000),
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color(0xDDFFFFFF)
            ),
            shape = RoundedCornerShape(40.dp),
            value = value.value,
            onValueChange = { newText ->
                value.value = newText
            },
            leadingIcon = {
                icone?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = "Icône",
                        tint = Color(0xAAFFFFFF)
                    )
                }
            },
            placeholder = {
                Text(text = placeholderText, color = Color(0xAAFFFFFF))
            })
    }
}

@Composable
fun TutoBasePage(content: @Composable ColumnScope.() -> Unit) {
    TutoconnexionTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Image(
                painter = painterResource(R.drawable.fond_tuto),
                contentDescription = "back-ground",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    verticalArrangement = Arrangement.spacedBy(
                        space = 10.dp
                    )
                ) {
                    content()
                    ProgressDialog()
                }
            }
        }
    }
}

@Composable
fun TutoButton(title: String, modifier: Modifier = Modifier, onClick: (() -> Unit)? = null) {
    Button(
        modifier = modifier
            .width(200.dp)
            .height(40.dp),
        border = BorderStroke(0.1.dp, Color(0xDD95248C)),
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        onClick = { onClick?.invoke() }
    ) {
        Box(
            contentAlignment = Alignment.Center, modifier = Modifier
                .background(
                    brush = Brush.linearGradient(
                        listOf(Color(0xDDd13059), Color(0xAA5D52A0))
                    )
                )
                .fillMaxSize()
        ) {
            Text(text = title, color = Color.White)
        }
    }
}

@Composable
fun TutoBoxCenter(content: @Composable () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center
    ) {
        content()
    }
}

@Composable
fun TutoH1(title: String) {
    Text(
        text = title,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 30.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        style = TextStyle(
            shadow = Shadow(
                Color.Black,
                offset = Offset(5f, 5f),
                blurRadius = 1f
            )
        )
    )
}

@Composable
fun TutoH2(title: String) {
    Text(
        text = title,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    )
}

@Composable
fun TutoText(title: String) {
    Text(
        text = title,
        modifier = Modifier.fillMaxWidth(),
        fontSize = 20.sp,
        textAlign = TextAlign.Center,
        color = Color.White
    )
}

