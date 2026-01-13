    package com.example.practicarpalabras.ui.home

    import android.widget.Toast
    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.Arrangement
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.Spacer
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.width
    import androidx.compose.material3.Button
    import androidx.compose.material3.MaterialTheme
    import androidx.compose.material3.Text
    import androidx.compose.material3.TextField
    import androidx.compose.material3.TextFieldDefaults
    import androidx.compose.runtime.Composable
    import androidx.compose.runtime.LaunchedEffect
    import androidx.compose.runtime.collectAsState
    import androidx.compose.runtime.getValue
    import androidx.compose.runtime.mutableStateOf
    import androidx.compose.runtime.remember
    import androidx.compose.runtime.setValue
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.unit.dp
    import androidx.lifecycle.viewmodel.*
    import androidx.lifecycle.viewmodel.compose.viewModel
    import kotlin.coroutines.coroutineContext

    @Composable
    fun InicioSesion(

        viewModel: LoginViewModel = viewModel()

    ){
        val state by viewModel.uiState.collectAsState()
        val context = LocalContext.current

        LaunchedEffect(state.mensaje) {
            Toast.makeText(context,state.mensaje,Toast.LENGTH_SHORT).show()
        }

        Column(modifier = Modifier.fillMaxSize()
            .padding(5.dp)
            .background(color = Color.LightGray),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){

            Text(
                text = "Inicio de sesión",
                style = MaterialTheme.typography.titleMedium,
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
               value = state.usuario,
               onValueChange = {
                   viewModel.onUsuarioChanged(it)
               },
               label = {Text(text = "Usuairo")},
               modifier = Modifier.fillMaxWidth()
                   .padding(start = 25.dp, end = 25.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Blue,
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(20.dp))

            TextField(
                value = state.contrasenya,
                onValueChange = {
                    viewModel.onContrasenyaChanged(it)
                },
                label = {Text(text = "Contraseña")},
                modifier = Modifier.fillMaxWidth()
                    .padding(start = 25.dp, end = 25.dp),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.LightGray,
                    unfocusedContainerColor = Color.LightGray,
                    focusedIndicatorColor = Color.Blue,
                ),
                singleLine = true
            )

            Spacer(modifier = Modifier.height(25.dp))

            Button(modifier = Modifier.width(150.dp),
                onClick = {
                    viewModel.onLogin()
                },
            ) {
                Text("Inicio sesion")
            }

        }
    }