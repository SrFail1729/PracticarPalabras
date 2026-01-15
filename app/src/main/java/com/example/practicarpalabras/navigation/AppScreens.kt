package com.example.practicarpalabras.navigation

sealed class AppScreens (val route: String){
    object Login : AppScreens("login_route")
    object PantallarPrincial: AppScreens("pantalla_princial_route")
}