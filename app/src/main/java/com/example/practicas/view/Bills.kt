package com.example.practicas.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import com.example.practicas.R
import com.example.practicas.model.Game
import com.example.practicas.model.Player
import com.example.practicas.templates.TeamTemplate

@Composable
fun Bills(navController: NavController) {
    val juegos = listOf(
        Game("Dolphins", "24 - 21", "Victoria"),
        Game("Patriots", "17 - 27", "Derrota"),
        Game("Jets", "31 - 28", "Victoria"),
        Game("Chiefs", "21 - 30", "Derrota")
    )

    val jugadores = listOf(
        Player("Josh Allen", "QB", "320 Yds, 3 TD"),
        Player("Stefon Diggs", "WR", "110 Yds, 1 TD"),
        Player("Von Miller", "LB", "2 Tackles, 1 Sack"),
        Player("Dawson Knox", "TE", "65 Yds, 1 TD")
    )

    TeamTemplate(
        navController = navController,
        teamName = "Buffalo Bills",
        teamLogo = R.drawable.bills,
        primaryColor = Color(0xFF00338D),
        deepColor = Color(0xFF001F5B),
        tableHeaderColor = Color(0xFF0B2265),
        cardColor = Color(0xFFB0B0B0),
        games = juegos,
        players = jugadores,
        popToScreen = "APantalla"
    )
}
