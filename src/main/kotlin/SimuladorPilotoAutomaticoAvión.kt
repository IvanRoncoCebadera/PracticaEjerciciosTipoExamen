fun main(){
    var parametrosActuales = pasarParamentrosAVector("Ahora debes introducir la altura y velocidad actual y que tenga el siguiente formato: aaaa,vvv")
    var parametrosDeseados = pasarParamentrosAVector("Ahora debes introducir la altura y velocidad deseada y que tenga el siguiente formato: aaaa,vvv")
    simuladorVuelo(parametrosActuales, parametrosDeseados)
}

private fun simuladorVuelo(parametrosActuales: IntArray, parametrosDeseados: IntArray) {
    val PROBABILIDAD_FALLO = 1
    val tiempoEspera: Long = 2000
    val TIEMPO_MAX = 50000
    var tiempo: Long = 0
    var condicion = true
    do {
        tiempo += esperar(tiempoEspera)
        if (!fallo(PROBABILIDAD_FALLO)) {
            parametrosActuales[0] = cambiarParametro(
                comprobarCasoDeAltura(parametrosActuales[0], parametrosDeseados[0]),
                parametrosActuales[0]
            )
            println(mostrarAltura(parametrosActuales[0]))
            parametrosActuales[1] = cambiarParametro(
                comprobarCasoDeVelocidad(parametrosActuales[1], parametrosDeseados[1]),
                parametrosActuales[1]
            )
            println(mostrarVelocidad(parametrosActuales[1]))
            println("La simulación lleva, $tiempo milisegundos")
            println()
            condicion = true
        } else {
            condicion = false
        }
    } while (condicion == true && tiempo < TIEMPO_MAX)
    if (condicion == true) {
        println("Se termino el tiempo de simulación.")
    } else {
        println("Hubo un fallo con el piloto automático, AKA: vamos a morir.")
    }
}

fun mostrarAltura(altura: Int): String{
    return "La altura actual es de: $altura m."
}

fun mostrarVelocidad(velocidad: Int): String{
    return "La velocidad actual es de: $velocidad km/h."
}

fun cambiarParametro(caso: Int, parametro: Int): Int{
    return if(caso == 1){
        aumentar(parametro)
    }else{
        disminuir(parametro)
    }
}

fun aumentar(parametro: Int): Int{
    var parametroCamibado = parametro + 10
    return parametroCamibado
}

fun disminuir(parametro: Int): Int{
    var parametroCamibado = parametro - 10
    return parametroCamibado
}

fun comprobarCasoDeAltura(alturaA: Int, alturaD: Int): Int{
    return if(alturaA < alturaD){
        1
    }else{
        2
    }
}

fun comprobarCasoDeVelocidad(velocidadA: Int, velocidadD: Int): Int{
    return if(velocidadA < velocidadD){
        1
    }else{
        2
    }
}

fun fallo(probabilidad: Int): Boolean{
    var chance = (1..100).random()
    return if(chance <= probabilidad){
        true
    }else{
        false
    }
}

fun esperar(tiempoEspera: Long): Long{
    Thread.sleep(tiempoEspera)
    return tiempoEspera
}

fun pasarParamentrosAVector(mensaje: String): IntArray{
    println(mensaje)
    var parametros = escribirParametros()
    var vector = intArrayOf(parametros.substring(0..3).toInt(), parametros.substring(5..parametros.length - 1).toInt())
    return vector
}

private fun escribirParametros(): String {
    var parametros = ""
    val regex = Regex("[0-9]{4},[0-9]{3}")
    do {
        parametros = readln()
        if (!regex.matches(parametros)) {
            println("Esos parametros de vuelo no son adecuados. Vuelva a introducirlos:")
        }
    } while (!regex.matches(parametros))
    return parametros
}