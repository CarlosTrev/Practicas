package com.example.practicas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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

@Composable
fun PantallaPrincipal() {
    var expression by remember { mutableStateOf("") }
    var result by remember { mutableStateOf("") }

    val buttons = listOf(
        listOf("7", "8", "9", "/"),
        listOf("4", "5", "6", "*"),
        listOf("1", "2", "3", "-"),
        listOf("0", ".", "=", "+"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Pantalla
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Black),
            horizontalAlignment = Alignment.End,
            verticalArrangement = Arrangement.Bottom
        ) {
            Text(
                text = expression,
                fontSize = 28.sp,
                color = Color.Red,
                maxLines = 3
            )
            Text(
                text = result,
                fontSize = 36.sp,
                color = Color.White
            )
        }

        // Botones borrar y limpiar
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(
                onClick = { if (expression.isNotEmpty()) expression = expression.dropLast(1) },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = Modifier.weight(1f).padding(4.dp)
            ) {
                Text("⌫", fontSize = 22.sp, color = Color.White)
            }
            Button(
                onClick = {
                    expression = ""
                    result = ""
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
                modifier = Modifier.weight(1f).padding(4.dp)
            ) {
                Text("C", fontSize = 22.sp, color = Color.White)
            }
        }

        // Teclado
        buttons.forEach { row ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                row.forEach { label ->
                    Button(
                        onClick = {
                            when (label) {
                                "=" -> {
                                    try {
                                        val evalResult = eval(expression)
                                        result = evalResult.toString()
                                    } catch (e: Exception) {
                                        result = "Error"
                                    }
                                }
                                else -> expression += label
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = if (label in listOf("/", "*", "-", "+", "=")) Color.Red else Color.DarkGray
                        ),
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp)
                    ) {
                        Text(label, fontSize = 22.sp, color = Color.White)
                    }
                }
            }
        }
    }
}

// Evaluador matemático (respeta jerarquía de operaciones)
fun eval(expr: String): Double {
    return object {
        var i = -1
        var ch = 0

        fun nextChar() { ch = if (++i < expr.length) expr[i].code else -1 }
        fun eat(charToEat: Int): Boolean {
            while (ch == ' '.code) nextChar()
            if (ch == charToEat) {
                nextChar()
                return true
            }
            return false
        }

        fun parse(): Double {
            nextChar()
            val x = parseExpression()
            if (i < expr.length) throw RuntimeException("Unexpected: " + expr[i])
            return x
        }

        fun parseExpression(): Double {
            var x = parseTerm()
            while (true) {
                when {
                    eat('+'.code) -> x += parseTerm()
                    eat('-'.code) -> x -= parseTerm()
                    else -> return x
                }
            }
        }

        fun parseTerm(): Double {
            var x = parseFactor()
            while (true) {
                when {
                    eat('*'.code) -> x *= parseFactor()
                    eat('/'.code) -> x /= parseFactor()
                    else -> return x
                }
            }
        }

        fun parseFactor(): Double {
            if (eat('+'.code)) return parseFactor() // unario +
            if (eat('-'.code)) return -parseFactor() // unario -

            var x: Double
            val startPos = i
            if (eat('('.code)) {
                x = parseExpression()
                eat(')'.code)
            } else if (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) {
                while (ch >= '0'.code && ch <= '9'.code || ch == '.'.code) nextChar()
                x = expr.substring(startPos, i).toDouble()
            } else {
                throw RuntimeException("Unexpected: " + ch.toChar())
            }
            return x
        }
    }.parse()
}
