package br.com.ulbra.exemplorecycler.commons.utils

sealed class Resultado<out T> {
    data object Loading: Resultado<Nothing>()
    data class Success<out T>(val data: T): Resultado<T>()

    data class Error(val e: Exception): Resultado<Nothing>()
}