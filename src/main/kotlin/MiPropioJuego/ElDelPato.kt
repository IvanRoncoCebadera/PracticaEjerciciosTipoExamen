
fun main(){
    var posicionMira = 4
    var disparo = true
    var condicion = false
    var tamañoVision = 9
    var posicion = -4
    var visionJugador = IntArray(9)

    do {
        visionJugador = generarVisionJugador(visionJugador, posicion)
        println(escribirVector(visionJugador))
        println("Recuerda, debes tratar de acertar al pajaro cuando este en la mitad. Para disparar introduce cualquier cosa por teclado y dale al enter, si no quieres disparar, solo dale al enter:")
        disparo = acertarDisparo(visionJugador, posicion, posicionMira)
        if(disparo == false){
            condicion = false
        }else{
            condicion = true
        }
        posicion++
    }while(posicion < tamañoVision && condicion == false)
    if(condicion == true) {
        if (posicion - 1 == posicionMira) {
            println("Felicidades, le diste al pato.")
        } else {
            println("Malgastaste tu único disparo, y por ende se escapó el pato.")
        }
    }else{
        println("Wow, dejaste escapar al pato, Peta estaría agradecido contigo, pero no yo joeputa, tengo hambre.")
    }

}

fun acertarDisparo(visionJugador: IntArray, posicion: Int, posicionMira: Int): Boolean{
    var disparar = readln()
    return if(disparar == ""){
       false
    }else{
        true
    }
}

fun generarVisionJugador(vision: IntArray, posicion: Int): IntArray{
    var visionJugador = vision
    for(i in visionJugador.indices){
        visionJugador[i] = 0
    }
    if(posicion >= 0 && posicion < visionJugador.size) {
        visionJugador[posicion] = 1
    }
    return visionJugador
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