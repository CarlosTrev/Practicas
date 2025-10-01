package com.example.practicas.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import com.example.practicas.R
import com.example.practicas.model.Game
import com.example.practicas.model.Player
import com.example.practicas.templates.TeamTemplate

@Composable
fun Giants(navController: NavController) {
    val juegos = listOf(
        Game("Cowboys", "21 - 28", "Derrota"),
        Game("Eagles", "17 - 24", "Derrota"),
        Game("Bears", "31 - 10", "Victoria"),
        Game("Commanders", "27 - 20", "Victoria")
    )

    val jugadores = listOf(
        Player("Daniel Jones", "QB", "280 Yds, 2 TD"),
        Player("Saquon Barkley", "RB", "110 Yds, 1 TD"),
        Player("Dexter Lawrence", "DL", "3 Tackles, 2 QB Hits"),
        Player("Darren Waller", "TE", "75 Yds, 1 TD")
    )

    TeamTemplate(
        navController = navController,
        teamName = "New York Giants",
        teamLogo = R.drawable.nyg,
        primaryColor = Color(0xFF0B2265),
        deepColor = Color(0xFF1E3A8A),
        tableHeaderColor = Color(0xFF162C6B),
        cardColor = Color(0xFF869397),
        games = juegos,
        players = jugadores,
        popToScreen = "NPantalla"
    )
}
