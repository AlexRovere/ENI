package com.example.demoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.demoandroid.ui.theme.DemoAndroidTheme
import com.example.demoandroid.ui.theme.EniButton
import com.example.demoandroid.ui.theme.EniPage
import com.example.demoandroid.ui.theme.EniTextField
import com.example.demoandroid.ui.theme.WrapPadding
import com.example.demoandroid.ui.theme.WrapPaddingRowWeight

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstDemo()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FirstDemo()
}

@Composable
fun FirstDemo() {
    DemoAndroidTheme {
        EniPage() {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(
                    space = 16.dp, alignment = Alignment.Top
                ),
            ) {
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Personal details",
                    fontSize = 26.sp,
                    color = Color.White,
                    fontWeight = FontWeight.Bold
                )
                WrapPadding {
                    EniTextField(placeholder = "FistName")
                }
                WrapPadding {
                    EniTextField(placeholder = "LastName")
                }
                WrapPadding {
                    EniTextField(placeholder = "Email")
                }
                Row {
                    WrapPaddingRowWeight {
                        EniTextField()
                    }
                    WrapPaddingRowWeight(2f) {
                        EniTextField()
                    }
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    WrapPaddingRowWeight {
                        EniTextField(placeholder = "dd")
                    }
                    WrapPaddingRowWeight {
                        EniTextField(placeholder = "mm")
                    }
                    WrapPaddingRowWeight {
                        EniTextField(placeholder = "yy")
                    }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 10.dp),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 16.dp, alignment = Alignment.CenterHorizontally
                    )
                ) {
                    WrapPaddingRowWeight {
                        EniButton(text = "Back")
                    }
                    WrapPaddingRowWeight {
                        EniButton(text = "Next Page")
                    }
                }
                Spacer(modifier = Modifier.weight(1f))
            }
        }
    }

}