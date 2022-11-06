fun main(){
    var contRGaGaul = 0
    var contRGaPaul = 0
    val pair = jugar(contRGaGaul, contRGaPaul)
    contRGaGaul = pair.first
    contRGaPaul = pair.second
    println("El ganador del juego, a sido: ${comprobarGanadorPartida(contRGaGaul, contRGaPaul)}")
}

/**
 * funcion donde comprobamos quien ha ganado la partida en funcion de las rondas ganadas
 * @param gaul es el numero de rondas que gano Gaul
 * @param paul es el numero de rondas que gano paul
 * @return un mensaje que dice quien gano y con cuantes rondas, tambien dice si se empato
 */
fun comprobarGanadorPartida(gaul: Int, paul: Int): String {
    return if(gaul > paul){
        "Gaul, ganando un total de $gaul rondas."
    }else{
        if(gaul < paul){
            "Paul, ganando un total de $paul rondas."
        }else{
            "ninguno, los dos han empatado con el mismo número de rondas ganadas, $gaul para ser exactos."
        }
    }
}

/**
 * funcion que realiza la simulacion de jugar
 * @param contRGaGaul es el contador de rondas que gana Gaul
 * @param contRGaPaul es el contador de rondas que gana Paul
 * @return los valores de rondas ganada por Gaul y Paul en pareja
 */
private fun jugar(
    contRGaGaul: Int,
    contRGaPaul: Int
): Pair<Int, Int> {
    val MAX_RONDAS = 5
    var puntosGaul = IntArray(MAX_RONDAS)
    val PROBAILIDAD_GAUL = 33
    var puntosPaul = IntArray(MAX_RONDAS)
    val PROBABILIDAD_PAUL = 50
    val MAX_TIROS = 5
    var contRGaGaul1 = contRGaGaul
    var contRGaPaul1 = contRGaPaul
    for (ronda in 0 until MAX_RONDAS) {
        println()
        println("Es turno de Gaul para intentar meter los 5 tiros:")
        puntosGaul = escribirPuntosRondaVectorJugador(puntosGaul, ronda, MAX_TIROS, PROBAILIDAD_GAUL)
        println()
        println("Es turno de Paul para intentar meter los 5 tiros:")
        puntosPaul = escribirPuntosRondaVectorJugador(puntosPaul, ronda, MAX_TIROS, PROBABILIDAD_PAUL)
        val caso = comprobarCaso(puntosGaul, puntosPaul, ronda)
        if (caso == 1) {
            contRGaGaul1++
        } else {
            if (caso == 2) {
                contRGaPaul1++
            }
        }
        println(
            "El ganador de la ronda ${ronda + 1}, es: ${comprobarGanadorRonda(caso)}, con un total de ${devolverPuntosRonda(caso, puntosGaul, puntosPaul, ronda)} puntos."
        )
    }
    return Pair(contRGaGaul1, contRGaPaul1)
}
/**
 * funcion que nos devuelve los puntos de Gaul si el gano, de Paul si el gano o por defecto los de Gaul si quedo en empate, la ronda.
 * @param caso un numero que indica si gano gaul Paul o fue un empate
 * @param gaul vector de puntos por rondas de gaul
 * @param paul vector de puntos por rondas de Paul
 * @param ronda el numero de ronda en el que se esta comparando los puntos
 * @return los puntos de uno u otro segun el caso
 */
fun devolverPuntosRonda(caso: Int, gaul: IntArray, paul: IntArray, ronda: Int): Int {
    return if(caso == 1){
        gaul[ronda]
    }else{
        if(caso == 2) {
            paul[ronda]
        }else{
            gaul[ronda]
        }
    }
}
/**
 * funcion que nos devuelve al gandor o si fue un empate, de la ronda segun el caso
 * @param caso un numero que indica si gano gaul Paul o fue un empate
 * @return el nombre del ganador o un mensaje que dice que quedaron empate
 */
fun comprobarGanadorRonda(caso: Int): String{
    return if(caso == 1){
        "Gaul"
    }else{
        if(caso == 2) {
            "Paul"
        }else{
            "ninguno, a sido un empate"
        }
    }
}
/**
 * funcion que nos devuelve el caso 1 si Gaul gano, 2 si fue Paul o 3 si fue empate. Estoy hablando de las rondas.
 * @param gaul vector de puntos por rondas de gaul
 * @param paul vector de puntos por rondas de Paul
 * @param ronda el numero de ronda en el que se esta comparando los puntos
 * @return el numero del caso
 */

fun comprobarCaso(gaul: IntArray, paul: IntArray, ronda: Int): Int{
    return if(gaul[ronda] > paul[ronda]){
        1
    }else{
        if(gaul[ronda] < paul[ronda]) {
            2
        }else{
            3
        }
    }
}
/**
 * funcion que escribe los puntos de la ronda del jugador correspondiente en la posicion correspondiente del vector de puntos del jugador correspondiente
 * @param jugador es el vector del jugador sobre el que tendremos que añadir los puntos
 * @param ronda el numero de ronda en el que se esta comparando los puntos
 * @param tiros es el maximo numero de tiros posibles por norma
 * @param probabilidad es el valor que nos sirve para determinar si el tiro fue un acierto o no
 * @return el vector de puntos del jugador habiendo añadido los puntos de la nueva ronda
 */
fun escribirPuntosRondaVectorJugador(jugador: IntArray, ronda: Int, tiros: Int, probabilidad: Int): IntArray{
    val puntosJ = jugador
    puntosJ[ronda] = generarPuntosRonda(probabilidad, tiros)
    return puntosJ
}
/**
 * funcion que calcula los puntos obtenidos por un jugador en la ronda
 * @param probabilidad es el valor que nos sirve para determinar si el tiro fue un acierto o no
 * @param tiros es el maximo numero de tiros posibles por norma
 * @return los puntos de la ronda del jugador
 */
private fun generarPuntosRonda(probabilidad: Int, tiros: Int): Int {
    var puntosR = 0
    for (tiro in 1..tiros) {
        val acertarTiro = (1..100).random()
        if (acertarTiro in (1..probabilidad)) {
            if (tiro == tiros) {
                puntosR += 2
            } else {
                puntosR += 1
            }
            println("Acertó el $tiro tiro.")
        } else {
            println("Falló el $tiro tiro")
        }
        println("Lleva un total de $puntosR puntos.")
    }
    return puntosR
}