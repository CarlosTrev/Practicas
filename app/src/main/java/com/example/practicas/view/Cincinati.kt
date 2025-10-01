package com.example.practicas.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import com.example.practicas.R
import com.example.practicas.model.Game
import com.example.practicas.model.Player
import com.example.practicas.templates.TeamTemplate

@Composable
fun Cincinati(navController: NavController) {
    val juegos = listOf(
        Game("Browns", "24 - 17", "Victoria"),
        Game("Ravens", "21 - 28", "Derrota"),
        Game("Steelers", "31 - 14", "Victoria"),
        Game("Bengals", "27 - 20", "Victoria")
    )

    val jugadores = listOf(
        Player("Joe Burrow", "QB", "350 Yds, 3 TD"),
        Player("Ja'Marr Chase", "WR", "120 Yds, 1 TD"),
        Player("Tee Higgins", "WR", "95 Yds, 1 TD"),
        Player("Joe Mixon", "RB", "110 Yds, 1 TD")
    )

    TeamTemplate(
        navController = navController,
        teamName = "Cincinnati Bengals",
        teamLogo = R.drawable.cincinati,
        primaryColor = Color(0xFFFB4F14),
        deepColor = Color(0xFFCC3300),
        tableHeaderColor = Color(0xFF8B0000),
        cardColor = Color(0xFFB0B0B0),
        games = juegos,
        players = jugadores,
        popToScreen = "APantalla"
    )
}
