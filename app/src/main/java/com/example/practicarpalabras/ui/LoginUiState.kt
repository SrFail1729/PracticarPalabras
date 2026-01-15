package com.example.practicarpalabras.ui

data class LoginUiState (
    val usuario: String = "",
    val contrasenya: String = "",
    val isExitoso: Boolean = false,
    val mensaje: String = ""
)