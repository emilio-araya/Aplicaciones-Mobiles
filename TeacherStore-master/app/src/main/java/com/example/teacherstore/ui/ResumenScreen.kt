package com.example.teacherstore.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.teacherstore.viewmodel.UsuarioViewModel
import kotlinx.coroutines.flow.collectAsState

@Composable
fun ResumenScreen(navController: NavController, viewModel: UsuarioViewModel) {
    val usuario = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text("Resumen del usuario", style = MaterialTheme.typography.headlineMedium)

        Text("Nombre: ${usuario.value.nombre}")
        Text("Correo: ${usuario.value.correo}")
        Text("Dirección: ${usuario.value.direccion}")

        Spacer(Modifier.height(20.dp))

        Button(onClick = { navController.navigate("registro") }) {
            Text("Volver")
        }
    }
}
