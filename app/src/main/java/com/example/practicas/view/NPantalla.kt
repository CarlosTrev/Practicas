package com.example.practicas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.practicas.R

@Composable
fun NPantalla(navController: NavController) {

    val equipos = listOf(
        Triple("Cowboys", R.drawable.cwb, Color(0xFF003594)),       // Azul Cowboys
        Triple("Chicago Bears", R.drawable.cb, Color(0xFF0B162A)), // Azul oscuro Bears
        Triple("Eagles", R.drawable.ea, Color(0xFF004C54)),        // Verde Eagles
        Triple("New York Giants", R.drawable.nyg, Color(0xFF0B2265)) // Azul Giants
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp, 150.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        equipos.forEach { (nombre, imagen, color) ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(140.dp),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
                colors = CardDefaults.cardColors(containerColor = color)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    Image(
                        painter = painterResource(id = imagen),
                        contentDescription = nombre,
                        modifier = Modifier
                            .size(80.dp)
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = nombre,
                        color = Color.White,
                        fontSize = 22.sp
                    )
                }
            }
        }
    }
}
