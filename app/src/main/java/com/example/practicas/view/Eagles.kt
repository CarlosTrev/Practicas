package com.example.practicas.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import com.example.practicas.R
import com.example.practicas.model.Game
import com.example.practicas.model.Player
import com.example.practicas.templates.TeamTemplate

@Composable
fun Eagles(navController: NavController) {
    val juegos = listOf(
        Game("Giants", "28 - 14", "Victoria"),
        Game("Cowboys", "24 - 17", "Victoria"),
        Game("49ers", "21 - 27", "Derrota"),
        Game("Commanders", "30 - 10", "Victoria")
    )

    val jugadores = listOf(
        Player("Jalen Hurts", "QB", "320 Yds, 3 TD"),
        Player("AJ Brown", "WR", "135 Yds, 2 TD"),
        Player("DeVonta Smith", "WR", "95 Yds, 1 TD"),
        Player("Darius Slay", "CB", "1 INT, 5 Tacleadas")
    )

    TeamTemplate(
        navController = navController,
        teamName = "Philadelphia Eagles",
        teamLogo = R.drawable.ea,
        primaryColor = Color(0xFF004C54),
        deepColor = Color(0xFF002244),
        tableHeaderColor = Color(0xFF004C54),
        cardColor = Color(0xFF555555),
        games = juegos,
        players = jugadores,
        popToScreen = "NPantalla"
    )
}
