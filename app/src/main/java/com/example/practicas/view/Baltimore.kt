package com.example.practicas.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import com.example.practicas.R
import com.example.practicas.model.Game
import com.example.practicas.model.Player
import com.example.practicas.templates.TeamTemplate

@Composable
fun Baltimore(navController: NavController) {
    val juegos = listOf(
        Game("Steelers", "21 - 14", "Victoria"),
        Game("Bengals", "17 - 28", "Derrota"),
        Game("Cowboys", "24 - 20", "Victoria"),
        Game("Ravens", "30 - 27", "Victoria")
    )

    val jugadores = listOf(
        Player("Lamar Jackson", "QB", "310 Yds, 2 TD"),
        Player("Mark Andrews", "TE", "85 Yds, 1 TD"),
        Player("Calais Campbell", "DL", "3 Tackles, 1 Sack"),
        Player("Marquise Brown", "WR", "110 Yds, 1 TD")
    )

    TeamTemplate(
        navController = navController,
        teamName = "Baltimore Ravens",
        teamLogo = R.drawable.baltimore,
        primaryColor = Color(0xFF241773),
        deepColor = Color(0xFF1B0F52),
        tableHeaderColor = Color(0xFF4B0082),
        cardColor = Color(0xFFB0B0B0),
        games = juegos,
        players = jugadores,
        popToScreen = "APantalla"
    )
}
