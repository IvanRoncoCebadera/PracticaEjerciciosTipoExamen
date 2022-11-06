fun main(){
    var mensajeAbuelo = escribirMensajeDelAbuelo()
    var intervalo = escribirIntervaloAMirrar(mensajeAbuelo)
    var vectorLetras = comprobarIntervaloEnMensaje(intervalo,  mensajeAbuelo)
    println(vectorLetras.joinToString())
    comprobacion(vectorLetras)
}

fun comprobacion(vector: CharArray){
    var auxiliar = vector[0]
    var cont = 1
    var contG = 0
    var condicion = true
    for(i in 1 until vector.size){
        if(auxiliar == vector[i]){
            cont++
        }else{
            auxiliar = vector[i]
            if(cont > 1){
                contG++
                condicion = false
            }
        }
    }
    if(condicion == true) {
        if (cont > 1) {
            contG++
        }
    }
    println("Se han repetido $contG letras en ese intervalo del mensaje.")
}

fun comprobarIntervaloEnMensaje(intervalo: String,  mensajeAbuelo: String): CharArray{
    val vectorIntervalo = intArrayOf(intervalo[0].digitToInt(), intervalo[0].digitToInt() + intervalo[2].digitToInt())
    var vector = CharArray(vectorIntervalo[1] - vectorIntervalo[0])
    var cont = 0
    for(i in (vectorIntervalo[0]..vectorIntervalo[1] - 1)){
        vector[cont] = mensajeAbuelo[i]
        cont++
    }
    return vector
}

fun escribirIntervaloAMirrar(mensaje: String): String{
    var regex = Regex("([0-9],[1-4])")
    println("""Intoduzca la posición inicial a mirar y el tamaño del intervalo, según el formato "i,t":""")
    var intervalo = ""
    do {
        intervalo = readln()
        if(!regex.matches(intervalo)){
            println("No nos sirven los parametros introducidos, vuelve a probar:")
        }
    }while(!regex.matches(intervalo))
    return intervalo
}

fun escribirMensajeDelAbuelo(): String{
    println("Escriba el mensaje que le envió el abuelo:")
    var mensaje = readln()
    return mensaje
}