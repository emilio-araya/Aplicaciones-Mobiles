package com.example.teacherstore.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.teacherstore.ui.RegistroScreen
import com.example.teacherstore.ui.ResumenScreen
import com.example.teacherstore.viewmodel.UsuarioViewModel

@Composable
fun AppNavigation(navController: NavHostController, viewModel: UsuarioViewModel) {
    NavHost(navController = navController, startDestination = "registro") {
        composable("registro") { RegistroScreen(navController, viewModel) }
        composable("resumen") { ResumenScreen(navController, viewModel) }
    }
}
