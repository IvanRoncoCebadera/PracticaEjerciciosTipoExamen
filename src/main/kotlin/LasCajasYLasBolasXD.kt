fun main(){
    val cantidad = 50
    var cont = 0
    var condicion = false
    println("Hay un total de $cantidad cajas.")
    var cajas = escribirCajas(cantidad)
    println(escribirVector(cajas))
    var cantBolasCajas = IntArray(cantidad)
    do {
        var bolas = leerCantidadBolas(
            "Que cantidad de bolas quieres meter en las cajas (mínmo 1 bola y máximo $cantidad bolas.",
            cantidad
        )
        cantBolasCajas = consecuenciaBolas(cajas, cantBolasCajas, bolas)
        println("Por ahora la caja está así:")
        println(escribirVector(cantBolasCajas))
        cont++
        if(cantBolasCajas contentEquals(cajas)){
            condicion = true
        }else{
            condicion = false
        }
    }while(condicion == false)
    println("Has tardado un total de $cont paseos.")
}

fun consecuenciaBolas(cajas: IntArray, vector: IntArray, bolas: Int): IntArray{
    for(i in cajas.indices){
        if(vector[i] + bolas <= cajas[i]){
            vector[i] = vector[i] + bolas
        }
    }
    return vector
}

fun leerCantidadBolas(mensaje: String, cantidad: Int): Int{
    println(mensaje)
    var bolas = 0
    do{
        bolas = readln().toInt()
        if(bolas < 1 || bolas > cantidad){
            println("Ese número de bolas par meter no tiene sentido, por favor vuelva a introducirlo:")
        }
    }while(bolas < 1 || bolas > cantidad)
    return bolas
}

fun escribirCajas(cantidad: Int): IntArray{
    var vector = IntArray(cantidad)
    var cont = 1
    for(i in vector.indices){
        vector[i] = cont
        cont++
    }
    return vector
}

private fun escribirVector(vision: IntArray): String{
    var vJugador = StringBuilder()
    for(i in vision.indices){
        if(i == 0){
            vJugador.append("[${vision[i]}|")
        }else{
            if(i == vision.size - 1){
                vJugador.append("${vision[i]}]")
            }else{
                vJugador.append("${vision[i]}|")
            }
        }
    }
    return vJugador.toString()
}