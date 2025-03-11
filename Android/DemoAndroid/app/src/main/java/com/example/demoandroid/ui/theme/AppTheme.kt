package com.example.demoandroid.ui.theme

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoandroid.R

@Composable
fun EniTextField(modifier: Modifier = Modifier, placeholder: String = "") {
    TextField(
        value = "",
        onValueChange = {},
        modifier = modifier.fillMaxWidth(),
        colors = TextFieldDefaults.colors(
            unfocusedIndicatorColor = Color.Transparent,
            unfocusedContainerColor = Color(0x99FFFFFF),
            focusedIndicatorColor = Color.Transparent,
            focusedContainerColor = Color(0xDDFFFFFF)
        ),
        shape = RoundedCornerShape(40.dp),
        placeholder = {
            Text(text = placeholder)
        })
}

@Composable
fun EniButton(modifier: Modifier = Modifier, text: String = "") {
    Button(
        border = BorderStroke(0.1.dp, Color(0xDD95248C)),
        modifier = modifier.fillMaxWidth(),
        onClick = {},
        contentPadding = PaddingValues(),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        )
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.background(brush = Brush.linearGradient(
                listOf(Color(0xDD95248C), Color(0xAA0084e2))
            )).fillMaxWidth().padding(vertical = 10.dp)
        ) {
            Text(text = text)
        }
    }
}

@Composable
fun WrapPadding(content: @Composable () -> Unit) {
    Box(modifier = Modifier.padding(10.dp)) {
        content()
    }
}

@Composable
fun RowScope.WrapPaddingRowWeight(weight: Float = 1f, content: @Composable () -> Unit) {
    Box(
        modifier = Modifier
            .padding(10.dp)
            .weight(weight)
    ) {
        content()
    }
}

@Composable
fun EniPage (content: @Composable () -> Unit) {
    DemoAndroidTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Box (modifier = Modifier.padding(innerPadding)){
                Image(
                    painter = painterResource(R.drawable.fond),
                    contentDescription = "back-ground",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
                content()
            }
        }
    }
}