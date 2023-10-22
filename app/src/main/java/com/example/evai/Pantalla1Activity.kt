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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.evai.empleados.EmpleadoHonorarios

class Pantalla1Activity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pantalla1()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun Pantalla1() {
    //definimos variables para trabajar con el sueldo y el calculo de resultados.
    var sueldo by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf("") }
    val contexto = LocalContext.current as ComponentActivity
/*
Dentro del column vamos a definir la interfaz de usuario que se presentara en esta pantalla
 */
    Column(
        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        //titulo de Text que indicara Sueldo Empleado a Honorario
        Text(
            text = "Sueldo Empleado a Honorario",
            style = TextStyle(fontSize = 30.sp, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.height(20.dp))
        //este texfield le permitira al usuario ingresar el sueldo bruto del empleado
        TextField(
            placeholder = {Text("Sueldo Bruto")},
            value = sueldo,
            onValueChange = {sueldo = it},
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(20.dp))
        //este boton ejecutarpa la acción para calcular el sueldo y mostrarlo en la variable resultado
        Button(onClick = {
            val b = sueldo.toDoubleOrNull() ?: 0.0
            val sueldoCalc = EmpleadoHonorarios(b).calcularLiquido()
            resultado = "El sueldo liquido es de ${sueldoCalc}"
        }) {
            Text("Calcular Sueldo")
        }
        Spacer(modifier = Modifier.height(20.dp))
        //Este Text mostrara el resultado del calculo del sueldo liquido
        Text(resultado)
        Spacer(modifier = Modifier.height(20.dp))
        //boton que nos permitirá regresar a la pantalla principal.
        Button(
        onClick = {
            val intent = Intent(contexto, MainActivity::class.java)
            contexto.startActivity(intent)
        },
        ) {
        Text("Volver")
            }
    }
}