package com.example.practicas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicas.R


@Composable
fun Baltimore(navController: NavController) {
    data class Game(val rival: String, val marcador: String, val resultado: String)
    data class Player(val nombre: String, val posicion: String, val stats: String)

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

    val primaryPurple = Color(0xFF241773)
    val deepPurple = Color(0xFF1B0F52)
    val tableHeader = Color(0xFF4B0082)
    val cardSilver = Color(0xFFB0B0B0)

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        navController.navigate("APantalla") {
                            popUpTo("APantalla") { inclusive = false }
                        }
                    }
                    .padding(4.dp, 30.dp)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.baltimore), // Cambia si tienes un icono de flecha
                    contentDescription = "Regresar",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Regresar",
                    color = Color.Black,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        item {
            Spacer(modifier = Modifier.height(28.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.baltimore),
                    contentDescription = "Baltimore Logo",
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Baltimore Ravens",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryPurple
                )
            }
        }

        item {
            Text("📅 Últimos Partidos", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(juegos) { juego ->
                    Card(
                        modifier = Modifier
                            .width(220.dp)
                            .height(130.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = primaryPurple),
                        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(12.dp)
                                .fillMaxSize(),
                            verticalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Vs ${juego.rival}", color = Color.White, fontWeight = FontWeight.Bold)
                            Text(juego.marcador, color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Text(
                                juego.resultado,
                                color = if (juego.resultado == "Victoria") Color(0xFF3DDC84) else Color(0xFFEF5350),
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = deepPurple),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(modifier = Modifier.padding(12.dp)) {
                    Text("📊 Tabla de Resultados", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Spacer(modifier = Modifier.height(12.dp))

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(width = 1.dp, color = Color.White, shape = RoundedCornerShape(8.dp))
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(tableHeader)
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Rival", color = Color.White, fontWeight = FontWeight.Bold)
                            Text("Marcador", color = Color.White, fontWeight = FontWeight.Bold)
                            Text("Resultado", color = Color.White, fontWeight = FontWeight.Bold)
                        }

                        juegos.forEach { j ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(j.rival, color = Color.White)
                                Text(j.marcador, color = Color.White)
                                Text(
                                    j.resultado,
                                    color = if (j.resultado == "Victoria") Color(0xFF3DDC84) else Color(0xFFEF5350),
                                    fontWeight = FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }

        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = primaryPurple),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("🏆 Resumen Temporada", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Victorias", color = Color(0xFF3DDC84), fontWeight = FontWeight.Bold)
                            Text("3", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("Derrotas", color = Color(0xFFEF5350), fontWeight = FontWeight.Bold)
                            Text("1", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        }
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("P/Favor", color = Color.White, fontWeight = FontWeight.Bold)
                            Text("106", color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(4.dp))
            Text("⭐ Jugadores Destacados", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(jugadores) { jugador ->
                    Card(
                        modifier = Modifier
                            .width(220.dp)
                            .height(130.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = cardSilver),
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.SpaceBetween) {
                            Text(jugador.nombre, color = Color.White, fontWeight = FontWeight.Bold)
                            Text(jugador.posicion, color = Color.LightGray)
                            Text(jugador.stats, color = Color.White, fontSize = 13.sp)
                        }
                    }
                }
            }
        }

        item {
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "⚠️ Nota: Los datos mostrados en esta pantalla podrían no ser del todo correctos.",
                color = Color.Gray,
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.height(28.dp))
        }
    }
}
