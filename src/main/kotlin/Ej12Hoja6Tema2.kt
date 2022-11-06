fun main(){
    val fechaActual: IntArray = escribirFecha("Por favor, debes escrbir la fecha de hoy:")
    do {
        var fechaNacimiento: IntArray = escribirFecha("Por favor, introduzca la fecha de nacimiento del cliente:")
        var edad = calcularEdad(fechaActual, fechaNacimiento)
        var precio = escribirPercioProducto("Por favor, introduce el precio del producto a pagar:")
        println("El artículo, cuesta $precio euros.")
        var descuento = conseguirDescuento(edad)
        var precioFinal = precio*descuento
        println("El artículo, cuesta $precioFinal euros, aplicando el máximo descuento  posible..")
    }while(deseasContinuar("¿Quedan más clientes por atender?(s/n)"))
}

private fun conseguirDescuento(edad: Int): Double {
    var descuento = 0.0
    if (edad > 65) {
        descuento = 1 - 0.15
    } else {
        if (edad < 25) {
            descuento = 1 - 0.1
        } else {
            descuento = 1.0
        }
    }
    return descuento
}

fun escribirPercioProducto(mensaje: String): Double{
    println(mensaje)
    var precio = 0.0
    do{
        precio = readln().toDouble()
        if(precio < 0){
            println("Ese precio, no es válido. Vuelva a introducirlo:")
        }
    }while(precio < 0)
    return precio
}

fun calcularEdad(fechaActual: IntArray, fechaNacimiento: IntArray): Int{
    var edad = 0
    if(fechaActual[1] >= fechaNacimiento[1]){
        edad = fechaActual[0] - fechaNacimiento[0]
    }else{
        if(fechaActual[1] == fechaNacimiento[1]){
            if(fechaActual[2] >= fechaNacimiento[2]) {
                edad = fechaActual[0] - fechaNacimiento[0]
            }else{
                edad = fechaActual[0] - fechaNacimiento[0] + 1
            }
        }else{
            edad = fechaActual[0] - fechaNacimiento[0] + 1
        }
    }
    return edad
}

fun deseasContinuar(mensaje: String): Boolean{
    println(mensaje)
    var texto = readln().lowercase()
    return if(texto == "s"){
        true
    }else{
        false
    }
}

fun escribirFecha(mensaje: String): IntArray{
    var fecha: IntArray = IntArray(3)
    println(mensaje)
    var año = escribirAño()
    fecha[0] = año
    var mes = escribirMes()
    fecha[1] = mes
    var dia = escribirDia(mes, año)
    fecha[2] = dia
    return fecha
}

private fun escribirDia(mes: Int, año: Int): Int {
    println("Por último, introduzca el día:")
    var dia = 0
    if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
        do {
            dia = readln().toInt()
            if (dia < 0 || dia > 31) {
                println("Ese dia no es correcto. Prueba de nuevo:")
            }
        } while (dia < 0 || dia > 31)
    } else {
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            do {
                dia = readln().toInt()
                if (dia < 0 || dia > 30) {
                    println("Ese dia no es correcto. Prueba de nuevo:")
                }
            } while (dia < 0 || dia > 30)
        } else {
            if (año % 4 == 0 && año % 100 != 0 || año % 400 == 0) {
                do {
                    dia = readln().toInt()
                    if (dia < 0 || dia > 29) {
                        println("Ese dia no es correcto. Prueba de nuevo:")
                    }
                } while (dia < 0 || dia > 29)
            } else {
                do {
                    dia = readln().toInt()
                    if (dia < 0 || dia > 28) {
                        println("Ese dia no es correcto. Prueba de nuevo:")
                    }
                } while (dia < 0 || dia > 28)
            }
        }
    }
    return dia
}

private fun escribirMes(): Int {
    println("Ahora, introduzca el mes:")
    var mes = 0
    do {
        mes = readln().toInt()
        if (mes < 0 || mes > 12) {
            println("Ese mes no es correcto. Prueba de nuevo:")
        }
    } while (mes < 0 || mes > 12)
    return mes
}

private fun escribirAño(): Int {
    println("Primero introduzcame el año:")
    var año = 0
    do {
        año = readln().toInt()
        if (año < 0) {
            println("Ese año no es correcto. Prueba de nuevo:")
        }
    } while (año < 0)
    return año
}