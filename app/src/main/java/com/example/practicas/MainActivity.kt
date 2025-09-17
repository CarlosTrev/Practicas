package com.example.practicas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PantallaPrincipal()
        }
    }
}

// Datos ISR quincenal oficiales
data class RangoISR(
    val limiteInferior: Double,
    val limiteSuperior: Double,
    val cuotaFija: Double,
    val porcentajeExcedente: Double
)

val rangosISR = listOf(
    RangoISR(0.01, 368.10, 0.00, 1.92),
    RangoISR(368.11, 3124.35, 7.05, 6.40),
    RangoISR(3124.36, 5490.75, 183.45, 10.88),
    RangoISR(5490.76, 6382.80, 441.00, 16.00),
    RangoISR(6382.81, 7641.90, 583.65, 17.92),
    RangoISR(7641.91, 15412.80, 809.25, 21.36),
    RangoISR(15412.81, 24292.65, 2469.15, 23.52),
    RangoISR(24292.66, 46378.50, 4557.75, 30.00),
    RangoISR(46378.51, 61838.10, 11183.40, 32.00),
    RangoISR(61838.11, 185514.30, 16130.55, 34.00),
    RangoISR(185514.31, Double.MAX_VALUE, 58180.35, 35.00)
)

fun calcularISR(sueldo: Double, rangos: List<RangoISR>): Double {
    val rango = rangos.firstOrNull { sueldo in it.limiteInferior..it.limiteSuperior }
    return if (rango != null) {
        rango.cuotaFija + (sueldo - rango.limiteInferior) * (rango.porcentajeExcedente / 100)
    } else 0.0
}

@Composable
fun PantallaPrincipal() {
    var sueldo by remember { mutableStateOf("") }
    var isr by remember { mutableStateOf("") }
    var neto by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF0F0F0)) // Fondo claro estilo SAT
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.padding(50.dp))

        Row {
            Image(
                painter = painterResource(id = R.drawable.logopractica3),
                contentDescription = null
            )

        }
        // Primer renglón: Sueldo editable y Botón
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = sueldo,
                onValueChange = { sueldo = it },
                label = { Text("Sueldo quincenal", color = Color(0xFF0A3D62)) },
                singleLine = true,
                modifier = Modifier.weight(1f),
                readOnly = false
            )

            Button(
                onClick = {
                    val sueldoNum = sueldo.replace(",", "").toDoubleOrNull() ?: 0.0
                    val isrCalc = calcularISR(sueldoNum, rangosISR)
                    val netoCalc = sueldoNum - isrCalc

                    isr = String.format("%.2f", isrCalc)
                    neto = String.format("%.2f", netoCalc)
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0072C6)),
                modifier = Modifier.height(50.dp)
            ) {
                Text("Calcular", color = Color.White, fontSize = 16.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        //ISR y Sueldo Neto (solo lectura)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = isr,
                onValueChange = {},
                label = { Text("ISR", color = Color(0xFF0A3D62)) },
                readOnly = true,
                modifier = Modifier.weight(1f)
            )

            OutlinedTextField(
                value = neto,
                onValueChange = {},
                label = { Text("Sueldo neto", color = Color(0xFF0A3D62)) },
                readOnly = true,
                modifier = Modifier.weight(1f)
            )
        }
    }
}