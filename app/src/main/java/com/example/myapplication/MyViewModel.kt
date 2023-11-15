package com.example.myapplication

import android.util.Log
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {

    private val TAG_LOG: String = "mensaje ViewModel"

    var randomNumber = mutableStateOf(0)
    val randomNumbersList = mutableStateListOf<Int>()
    var counter = mutableStateOf(0)
    var name = mutableStateOf("")

    init {
        Log.d(TAG_LOG, "Inicializamos ViewModel")
    }

    fun crearRandom() {
        randomNumber.value = (0..3).random()
        randomNumbersList.add(randomNumber.value)
        Log.d(TAG_LOG, "Añado el número: ${randomNumber.value}")

        for (numero in randomNumbersList) {
            Log.d(TAG_LOG, " Lista de números aleatorios: $numero")
        }
    }

    fun getNumero() = randomNumber.value
    fun getListaRandom() = randomNumbersList.toList()
    fun getContador() = counter.value
    fun getString() = name.value

    fun contador() {
        counter.value++
    }

    companion object {
        private const val MAX_LIST_SIZE = 100
    }
}
