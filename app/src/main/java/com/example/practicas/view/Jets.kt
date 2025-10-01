package com.example.practicas.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.compose.ui.graphics.Color
import com.example.practicas.R
import com.example.practicas.model.Game
import com.example.practicas.model.Player
import com.example.practicas.templates.TeamTemplate

@Composable
fun Jets(navController: NavController) {
    val juegos = listOf(
        Game("Bills", "28 - 31", "Derrota"),
        Game("Dolphins", "24 - 21", "Victoria"),
        Game("Patriots", "17 - 27", "Derrota"),
        Game("Ravens", "21 - 20", "Victoria")
    )

    val jugadores = listOf(
        Player("Zach Wilson", "QB", "250 Yds, 2 TD"),
        Player("Sauce Gardner", "CB", "3 Tackles, 1 INT"),
        Player("Breece Hall", "RB", "95 Yds, 1 TD"),
        Player("Tyler Conklin", "TE", "70 Yds, 1 TD")
    )

    TeamTemplate(
        navController = navController,
        teamName = "New York Jets",
        teamLogo = R.drawable.jets,
        primaryColor = Color(0xFF125740),
        deepColor = Color(0xFF0A3C2D),
        tableHeaderColor = Color(0xFF0B2265),
        cardColor = Color(0xFFB0B0B0),
        games = juegos,
        players = jugadores,
        popToScreen = "APantalla"
    )
}
