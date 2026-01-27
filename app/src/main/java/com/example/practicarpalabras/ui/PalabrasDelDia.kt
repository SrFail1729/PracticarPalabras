package com.example.practicarpalabras.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.practicarpalabras.ui.components.TopBar
import com.example.practicarpalabras.ui.components.menulateral.MenuLateralLayout

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun PantallaPrincipal(
    viewModel: PalabrasDelDiaViewModel = viewModel()
){

    val state by viewModel.uiState.collectAsState()

    val navController = rememberNavController()

    LaunchedEffect(Unit) {
        viewModel.generarPalabraDelDia()
    }
    MenuLateralLayout(navController = navController) {
        onMenuAbierto ->

        Scaffold(
            topBar = {
                TopBar("Pantalla principal"){}
            }
        ) {
            //Padding proporcionado por el Scaffold
            innerPadding ->
            Column(modifier = Modifier.fillMaxSize()
                .padding(innerPadding)
                .background(color = Color.White),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {

                //Empuja hacia abajo el contenido haciendolo mas geometrico
                Spacer(modifier = Modifier.weight(1f))

                Text(
                    text = "Palabra del día",
                    style = MaterialTheme.typography.titleLarge,
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = state.palabra,
                    style = MaterialTheme.typography.titleMedium,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.padding(10.dp),
                    text = state.definicion,
                    style = MaterialTheme.typography.bodyMedium,
                )

                Spacer(modifier = Modifier.height(10.dp))

                Button(
                    onClick = {
                        viewModel.palabraRandom()
                    }
                ) {
                    Text("Prácticar nuevas palabras")
                }

                //La función de este spacer es hacer como un muelle o caja
                //Empujando el contendio para hacerlo mas geometrico "porque sino colapso"
                Spacer(modifier = Modifier.weight(1.6f))
            }
        }
    }
}