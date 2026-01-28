package com.example.practicarpalabras.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicarpalabras.ui.InicioSesion
import com.example.practicarpalabras.ui.PantallaPrincipal

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun AppNavigaton(){

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AppScreens.Login.route
    ){
        composable(AppScreens.Login.route) {
            InicioSesion(
                loginExitoso = {
                    navController.navigate(AppScreens.PantallarPrincial.route){
                        popUpTo(AppScreens.Login.route){inclusive = true}
                    }
                }
            )
        }

        composable (AppScreens.PantallarPrincial.route){
            PantallaPrincipal()
        }
    }
}