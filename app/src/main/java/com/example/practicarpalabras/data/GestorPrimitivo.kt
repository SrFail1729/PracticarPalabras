package com.example.practicarpalabras.data

object GestorPrimitivo {
    private val usuarios = mutableMapOf(
       "robux" to "147fed",
       "admin" to "sudosu",
       "diflon" to "cuniculuspaca"
    )

    fun verificarUsuario(usuario: String): Boolean{

        return usuarios.containsKey(usuario)

    }

    fun verificarContrasenya(usuario: String, contrasenya: String): Boolean{
        return usuarios[usuario] == contrasenya
    }
}