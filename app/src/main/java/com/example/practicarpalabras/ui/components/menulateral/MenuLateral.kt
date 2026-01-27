package com.example.practicarpalabras.ui.components.menulateral

import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import kotlinx.coroutines.launch

@Composable
fun MenuLateralLayout(
    navController: NavController,
    content: @Composable (onMenuAbierto: () -> Unit) -> Unit
){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    //Se obtine la rutaactual para que el menú sepa que resaltar
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val rutaActual = navBackStackEntry?.destination?.route

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            Contenido(
                rutaActual = rutaActual,
                onNavigate = {
                    ruta ->
                    scope.launch { drawerState.close() }
                    navController.navigate(ruta)
                }
            )
        }
    ) {
        content {scope.launch { drawerState.open() }
        }
    }

}