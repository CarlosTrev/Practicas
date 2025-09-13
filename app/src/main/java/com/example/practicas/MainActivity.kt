package com.example.practicas

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaPrincipal()
        }
    }
}

@Composable
fun PantallaPrincipal() {
    val context: Context = LocalContext.current
    var sueldo by remember {mutableStateOf("")}
    var isr by remember {mutableStateOf("")}
    var neto by remember {mutableStateOf("")}
    Column (
        Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Row (){
            Image(
                painter = painterResource(id = R.drawable.logopractica3),
                contentDescription = null
            )
        }
        Row (){
            OutlinedTextField(
                value = sueldo,
                label = {Text("Sueldo quincenal")},
                onValueChange = {sueldo = it}
            )
        }
        Row (){
            Button(onClick = {/*TODO*/}) {
                Text(text = "Calcular")
            }
        }
        Row (){
            OutlinedTextField(
                value = isr,
                label = {Text("ISR")},
                onValueChange = {isr = it}
            )
        }
        Row (){
            OutlinedTextField(
                value = neto,
                label = {Text("Sueldo neto")},
                onValueChange = {neto = it}
            )
        }
    }
}