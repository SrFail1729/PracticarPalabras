package com.example.practicarpalabras.ui.home

import androidx.lifecycle.ViewModel
import com.example.practicarpalabras.data.GestorPrimitivo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel: ViewModel(){

    private val _uiState = MutableStateFlow(LoginUiState())

    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    //Escribe el usuario
    fun onUsuarioChanged(nuevoUsuario: String){
        _uiState.update { it.copy(usuario = nuevoUsuario) }
    }

    //Se escribe una nueva contraseña
    fun onContrasenyaChanged(nuevaContrsenya: String){
        _uiState.update { it.copy(contrasenya = nuevaContrsenya) }
    }

    fun onLogin(){
        val usuario = _uiState.value.usuario

        val contrasenya = _uiState.value.contrasenya

        if (!GestorPrimitivo.verificarUsuario(usuario)){
            _uiState.update {
                it.copy(
                    isExitoso = false,
                    mensaje = "El usuario no existe"
                )
            }
        }else if (GestorPrimitivo.verificarContrasenya(usuario,contrasenya)){
            _uiState.update {
                it.copy(
                    isExitoso = true,
                    mensaje = "¡Bienvenido $usuario!"
                )
            }
        }else{
            _uiState.update {
                it.copy(
                    isExitoso = false,
                    mensaje = "Contraseña incorrecta"
                )
            }
        }
    }

}