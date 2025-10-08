package com.example.teacherstore.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import com.example.teacherstore.data.UsuarioUiState
import com.example.teacherstore.data.UsuarioErrores

class UsuarioViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(UsuarioUiState())
    val uiState: StateFlow<UsuarioUiState> = _uiState

    private val _errores = MutableStateFlow(UsuarioErrores())
    val errores: StateFlow<UsuarioErrores> = _errores

    fun actualizarNombre(nombre: String) {
        _uiState.value = _uiState.value.copy(nombre = nombre)
    }

    fun actualizarCorreo(correo: String) {
        _uiState.value = _uiState.value.copy(correo = correo)
    }

    fun actualizarClave(clave: String) {
        _uiState.value = _uiState.value.copy(clave = clave)
    }

    fun actualizarDireccion(direccion: String) {
        _uiState.value = _uiState.value.copy(direccion = direccion)
    }

    fun validarFormulario(): Boolean {
        val state = _uiState.value
        var valido = true

        val nombreError = if (state.nombre.isBlank()) "El nombre no puede estar vacío" else null
        val correoError = if (!state.correo.contains("@")) "Correo inválido" else null
        val claveError = if (state.clave.length < 6) "La clave debe tener al menos 6 caracteres" else null
        val direccionError = if (state.direccion.isBlank()) "La dirección no puede estar vacía" else null

        if (nombreError != null || correoError != null || claveError != null || direccionError != null) {
            valido = false
        }

        _errores.value = UsuarioErrores(nombreError, correoError, claveError, direccionError)
        return valido
    }
}
