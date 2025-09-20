package com.example.practicas.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.practicas.view.*


@Composable
fun NavManager() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "Splash"
    ) {
        composable("Splash") {
            SplashScreen(navController)
        }
        composable("Home") {
            HomeView(navController)
        }
        /*composable("apantalla") {
            APantalla(navController)
        }*/
        composable("npantalla") {
            NPantalla(navController)
        }
    }
}
