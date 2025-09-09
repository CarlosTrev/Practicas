package com.example.practicas

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.TextField
import androidx.compose.material3.Text
import androidx.compose.runtime.currentCompositionLocalContext

import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.practicas.ui.theme.PracticasTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PracticasTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaPrincipal(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun PantallaPrincipal(name: String, modifier: Modifier = Modifier) {
val context: Context = LocalContext.current
    var valora by remember { mutableStateOf("") }
    var valorb by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("Carlos Adrian Treviño")}
    Column (modifier = modifier
        .fillMaxSize()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center){
        TextField(
            value = nombre,
            onValueChange = { nombre = it },
            modifier = Modifier
                .fillMaxWidth(0.8f), // 80% del ancho de la pantalla
            textStyle = androidx.compose.ui.text.TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { /* TODO */ },
            shape = CutCornerShape(40.dp),
            border = BorderStroke(3.dp, Color.Black),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Red,
                contentColor = Color.White
            ),
            modifier = Modifier
                .width(150.dp)
                .height(50.dp)
        ) {
            Text(text = "Enviar", fontSize = 18.sp)
        }
        Row(modifier.padding(16.dp)) {
            OutlinedTextField(
                value = valora,
                label = {Text("Primer valor")},
                onValueChange = {valora = it}
            )
        }
        Row(modifier.padding(16.dp)) {
            OutlinedTextField(
                value = valorb,
                label = {Text("Segundo valor")},
                onValueChange = {valorb = it}
            )
        }
        Row(Modifier.align(Alignment.CenterHorizontally)
        ){
            OutlinedButton(onClick = {/*TODO*/
            val a =  valora.toInt()
            val b = valorb.toInt()
            val c = a+b
            resultado = c.toString()
            }) {
                Text(text = "Enviar")
            }
        }
        Row(modifier.padding(16.dp)) {
            OutlinedTextField(
                value = resultado,
                label = {Text("Resultado")},
                onValueChange = {resultado = it}
            )
        }
    }
}