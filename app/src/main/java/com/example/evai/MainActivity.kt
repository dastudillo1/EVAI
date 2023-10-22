package com.example.evai

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PantallaInicio()
        }
    }
}
/*
Función PantallaInicio() donde definimos la interfaz de la pantalla principal
con dos botones, los que me van a refirigir hacia el calulo de sueldo para empleados a honorario
o a empleados regulares con contrato
 */
@Preview
@Composable
fun PantallaInicio() {
    val contexto = LocalContext.current as ComponentActivity

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Calcular Sueldos Liquidos",
            style = TextStyle(
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(30.dp))
        //boton que me va a redirigir a la pantalla para calcular sueldo de empleados a honorarios
        Button(modifier = Modifier.height(60.dp).width(250.dp) , onClick = {
            val intent:Intent = Intent(contexto, Pantalla1Activity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Empleado a Honorario")
        }
        Spacer(modifier = Modifier.height(10.dp))
        //boton que me va a redirigir a la pantalla para calcular sueldo de empleados regulares con contrato
        Button(modifier = Modifier.height(60.dp).width(250.dp), onClick = {
            val intent:Intent = Intent(contexto, Pantalla2Activity::class.java)
            contexto.startActivity(intent)
        }) {
            Text("Empleado regular con contrato")
        }
    }
}