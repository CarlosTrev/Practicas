package com.example.practicas.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import com.example.practicas.R
import com.example.practicas.model.Game
import com.example.practicas.model.Player
import com.example.practicas.templates.TeamTemplate

@Composable
fun Cowboys(navController: NavController) {
    val juegos = listOf(
        Game("Giants", "28 - 21", "Victoria"),
        Game("Eagles", "17 - 24", "Derrota"),
        Game("Bears", "31 - 10", "Victoria"),
        Game("Packers", "27 - 20", "Victoria")
    )

    val jugadores = listOf(
        Player("Dak Prescott", "QB", "300 Yds, 3 TD"),
        Player("Micah Parsons", "LB", "2 Capturas, 1 FF"),
        Player("CeeDee Lamb", "WR", "120 Yds, 1 TD"),
        Player("Tony Pollard", "RB", "95 Yds, 1 TD")
    )

    TeamTemplate(
        navController = navController,
        teamName = "Dallas Cowboys",
        teamLogo = R.drawable.cwb,
        primaryColor = Color(0xFF003594),
        deepColor = Color(0xFF1D428A),
        tableHeaderColor = Color(0xFF0B2265),
        cardColor = Color(0xFF869397),
        games = juegos,
        players = jugadores,
        popToScreen = "NPantalla"
    )
}
