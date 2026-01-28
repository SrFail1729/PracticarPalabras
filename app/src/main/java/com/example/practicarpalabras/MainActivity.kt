package com.example.practicarpalabras

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.practicarpalabras.navigation.AppNavigaton
import com.example.practicarpalabras.ui.InicioSesion
import com.example.practicarpalabras.ui.PantallaPrincipal


class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AppNavigaton()
        }
    }
}


@Preview
@Composable
fun GreetingPreview() {
}