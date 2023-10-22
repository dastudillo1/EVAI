package com.example.evai.empleados

abstract class Empleado {
    /*definimos la función abstracta calcularLiquido() no tiene parametros
    y retorna un valor tipo Double*/
    abstract fun calcularLiquido(): Double
}
/*
Clase EmpleadoHonorarios que tiene un constructor que recibe como parametro el montoBruto
esta clase implementa calcularLiquido() y calcula el monto liquido con el 13% de porcentaje de retención
 */
class EmpleadoHonorarios(val montoBruto:Double) : Empleado() {
    override fun calcularLiquido(): Double = montoBruto * (1 - 0.13)
}
/*
Clase EmpleadoRegular que tiene un constructor que recibe como parametro el montoBruto
esta clase implementa calcularLiquido() y calcula el monto liquido con el 20% de porcentaje de retención
 */
class EmpleadoRegular(val montoBruto:Double) : Empleado() {
    override fun calcularLiquido(): Double = montoBruto * (1 - 0.20)
}