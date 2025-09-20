package com.example.practicas.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.example.practicas.R
import androidx.compose.material3.Text
import androidx.compose.ui.unit.dp

@Composable
fun HomeView(navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .clickable { navController.navigate("apantalla") },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.a),
                contentDescription = "Imagen A",
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = "Equipos Americanos",
                color = Color.Red,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.BottomCenter).padding(50.dp)
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxSize()
                .clickable { navController.navigate("npantalla") },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.n),
                contentDescription = "Imagen N",
                modifier = Modifier.fillMaxSize()
            )
            Text(
                text = "Equipos Nacionales",
                color = Color.Blue,
                fontSize = 24.sp,
                modifier = Modifier.align(Alignment.BottomCenter).padding(50.dp)
            )
        }
    }
}
