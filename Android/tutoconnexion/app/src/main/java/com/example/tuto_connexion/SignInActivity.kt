package com.example.tuto_connexion

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tuto_connexion.ui.theme.TutoBasePage
import com.example.tuto_connexion.ui.theme.TutoBoxCenter
import com.example.tuto_connexion.ui.theme.TutoButton
import com.example.tuto_connexion.ui.theme.TutoH1
import com.example.tuto_connexion.ui.theme.TutoH2
import com.example.tuto_connexion.ui.theme.TutoInput


class SignInActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PageSignIn()
        }
    }
}

@Composable
fun PageSignIn() {
    TutoBasePage {
        Spacer(modifier = Modifier.weight(1f))
        TutoH1(title= stringResource(R.string.app_title_sign_in))
        TutoBoxCenter {
            Icon(
                imageVector = Icons.Default.AccountCircle,
                contentDescription =  stringResource(R.string.app_icon_label_default),
                tint = Color.White,
                modifier = Modifier.size(80.dp)
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Column {
            TutoInput(
                placeholderText = stringResource(R.string.app_field_email_hint),
                icone = Icons.Outlined.Email
            )
            TutoInput(
                placeholderText =  stringResource(R.string.app_field_password_hint),
                icone = Icons.Outlined.Lock
            )
        }

        TutoButton("Connexion", Modifier.fillMaxWidth())
        Spacer(modifier = Modifier.weight(3f))
        TutoH2(title = stringResource(R.string.app_msg_ask_reset_password))
        TutoBoxCenter {
            TutoButton(title= stringResource(R.string.app_btn_reset_password))
        }
        TutoH2(title = stringResource(R.string.app_msg_ask_have_account))
        TutoBoxCenter {
            TutoButton(title = stringResource(R.string.app_btn_sign_up))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SignInPreview() {
    PageSignIn()
}