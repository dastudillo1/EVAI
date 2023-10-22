package com.example.evai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.evai.empleados.EmpleadoRegular

class Pantalla2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //cargamos la interfaz de usuario que definimos en el archivo XML activity_pantalla2
        setContentView(R.layout.activity_pantalla2)

        //obtenemos el id del boton calcular y le agregamos un listener.
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener {
            //variable utilizada para mostrar el resultado del calculo
            val resultado = findViewById<TextView>(R.id.tvResultado)
            //variable utlizada para ingresar el sueldo bruto
            val sueldo = findViewById<EditText>(R.id.etSueldo)
            //obtenemos el texto ingresado y lo convertimos a un valor numerico
            val a = sueldo.text.toString().toDoubleOrNull() ?: 0.0
            //creamos una instancia de la clase EmpleadoRegular y le pasamos el sueldo como parametro al constructor
            val empleadoReg = EmpleadoRegular(a)
            //llamada al metrodo calcularLiquido()
            val sueldoCalc = empleadoReg.calcularLiquido()

            resultado.text = "El sueldo liquido es de ${sueldoCalc}"
        }
    }
    //función para el boton que nos permitira volver a la pantalla principal
    fun volverAtras(view:View) {
        finish()
    }
}