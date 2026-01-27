package com.example.practicarpalabras.ui

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import com.example.practicarpalabras.data.Palabra
import com.example.practicarpalabras.data.Palabras
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.LocalDate
import kotlin.random.Random

@RequiresApi(Build.VERSION_CODES.O)
class PalabrasDelDiaViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(PalabrasDelDiaUiState())

    private val listaPalabrasAprendidas = mutableListOf<Palabra>()

    val uiState : StateFlow<PalabrasDelDiaUiState> = _uiState.asStateFlow()

    init {
        generarPalabraDelDia()
    }

    fun palabraRandom(){

        //Obtenemos una lista de palabras que aun no han salido
        val palabrasNoAprendidas = Palabras.palabras.filter { it !in listaPalabrasAprendidas }

        val nuevaPalabra = palabrasNoAprendidas.randomOrNull()

        if (nuevaPalabra != null){

            listaPalabrasAprendidas.add(nuevaPalabra)

            _uiState.update {
                    estado -> estado.copy(
                palabra = nuevaPalabra.palabra,
                definicion = nuevaPalabra.definicion)
            }
        }
    }

    fun generarPalabraDelDia(){
        val palabras = Palabras.palabras
        val semillaDia = LocalDate.now().toEpochDay()

        val palabraDelDia = palabras.random(Random(semillaDia))

        listaPalabrasAprendidas.add(palabraDelDia)

        _uiState.update {
                estado -> estado.copy(
            palabra = palabraDelDia.palabra,
            definicion = palabraDelDia.definicion)
        }
    }
}