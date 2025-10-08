package com.example.teacherstore.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.teacherstore.viewmodel.UsuarioViewModel
import kotlinx.coroutines.flow.collectAsState

@Composable
fun RegistroScreen(navController: NavController, viewModel: UsuarioViewModel) {
    val usuario = viewModel.uiState.collectAsState()
    val errores = viewModel.errores.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {

        OutlinedTextField(
            value = usuario.value.nombre,
            onValueChange = viewModel::actualizarNombre,
            label = { Text("Nombre") },
            isError = errores.value.nombreError != null,
            supportingText = {
                errores.value.nombreError?.let { Text(it, color = MaterialTheme.colorScheme.error) }
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = usuario.value.correo,
            onValueChange = viewModel::actualizarCorreo,
            label = { Text("Correo electrónico") },
            isError = errores.value.correoError != null,
            supportingText = {
                errores.value.correoError?.let { Text(it, color = MaterialTheme.colorScheme.error) }
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = usuario.value.clave,
            onValueChange = viewModel::actualizarClave,
            label = { Text("Clave") },
            visualTransformation = PasswordVisualTransformation(),
            isError = errores.value.claveError != null,
            supportingText = {
                errores.value.claveError?.let { Text(it, color = MaterialTheme.colorScheme.error) }
            },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = usuario.value.direccion,
            onValueChange = viewModel::actualizarDireccion,
            label = { Text("Dirección") },
            isError = errores.value.direccionError != null,
            supportingText = {
                errores.value.direccionError?.let { Text(it, color = MaterialTheme.colorScheme.error) }
            },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(20.dp))

        Button(
            onClick = {
                if (viewModel.validarFormulario()) {
                    navController.navigate("resumen")
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Registrar")
        }
    }
}
