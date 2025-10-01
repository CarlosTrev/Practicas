package com.example.practicas.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import com.example.practicas.R
import com.example.practicas.model.Game
import com.example.practicas.model.Player
import com.example.practicas.templates.TeamTemplate

@Composable
fun Bears(navController: NavController) {
    val juegos = listOf(
        Game("Packers", "21 - 24", "Derrota"),
        Game("Vikings", "27 - 17", "Victoria"),
        Game("Lions", "28 - 31", "Derrota"),
        Game("Cowboys", "20 - 21", "Derrota")
    )

    val jugadores = listOf(
        Player("Justin Fields", "QB", "250 Yds, 2 TD"),
        Player("Darnell Mooney", "WR", "95 Yds, 1 TD"),
        Player("Roquan Smith", "LB", "8 Tackles, 1 Sack"),
        Player("Cole Kmet", "TE", "60 Yds, 1 TD")
    )

    TeamTemplate(
        navController = navController,
        teamName = "Chicago Bears",
        teamLogo = R.drawable.cb,
        primaryColor = Color(0xFF0B162A),
        deepColor = Color(0xFF051027),
        tableHeaderColor = Color(0xFF0B162A),
        cardColor = Color(0xFF444444),
        games = juegos,
        players = jugadores,
        popToScreen = "NPantalla"
    )
}
