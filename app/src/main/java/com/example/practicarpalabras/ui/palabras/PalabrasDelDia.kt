package com.example.practicarpalabras.ui.palabras

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
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

@Composable
fun pantallaPrincipal(
    viewModel: PalabrasDelDiaViewModel = viewModel()
){
    val state by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.generarPalabraDelDia()
    }

    Column(modifier = Modifier.fillMaxSize()
        .padding(5.dp)
        .background(color = Color.LightGray),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

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
    }
}