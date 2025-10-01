package com.example.practicas.templates

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicas.model.Game
import com.example.practicas.model.Player

@Composable
fun TeamTemplate(
    navController: NavController,
    teamName: String,
    teamLogo: Int,
    primaryColor: Color,
    deepColor: Color,
    tableHeaderColor: Color,
    cardColor: Color,
    games: List<Game>,
    players: List<Player>,
    popToScreen: String
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        //Botón regresar
        item {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable {
                        navController.navigate(popToScreen) {
                            popUpTo(popToScreen) { inclusive = false }
                        }
                    }
                    .padding(4.dp, 30.dp)
            ) {
                Icon(
                    painter = painterResource(id = teamLogo),
                    contentDescription = "Regresar",
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(6.dp))
                Text(
                    text = "Regresar",
                    color = Color.Red,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        //Encabezado
        item {
            Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = teamLogo),
                    contentDescription = "$teamName Logo",
                    modifier = Modifier.size(100.dp)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = teamName,
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = primaryColor
                )
            }
        }

        //Últimos partidos
        item {
            Text("📅 Últimos Partidos", color=Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(games) { juego ->
                    Card(
                        modifier = Modifier
                            .width(220.dp)
                            .height(130.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = primaryColor),
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

        //Tabla de resultados
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = deepColor),
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
                                .background(tableHeaderColor)
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Rival", color = Color.White, fontWeight = FontWeight.Bold)
                            Text("Marcador", color = Color.White, fontWeight = FontWeight.Bold)
                            Text("Resultado", color = Color.White, fontWeight = FontWeight.Bold)
                        }

                        games.forEach { j ->
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

        //Resumen temporada
        item {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp),
                colors = CardDefaults.cardColors(containerColor = primaryColor),
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

        //Jugadores destacados
        item {
            Spacer(modifier = Modifier.height(4.dp))
            Text("⭐ Jugadores Destacados", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White, modifier = Modifier.padding(start = 4.dp))
            Spacer(modifier = Modifier.height(8.dp))

            LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                items(players) { jugador ->
                    Card(
                        modifier = Modifier
                            .width(220.dp)
                            .height(130.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(containerColor = cardColor),
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

        //Disclaimer
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
