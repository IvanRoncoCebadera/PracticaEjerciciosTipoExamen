import Utils.escribirMatriz

fun main(){
    var tamaño = 8
    var coordenadas = generarCoordenadasPieza("""Tienes que ingresar las cordenadas donde quieras colocar tu pieza, con el formato "f,c".""", tamaño)
    var posicion: IntArray = tomarPosicionFilaColumna(coordenadas)
    val tablero: Array<IntArray> = mostrarPosiblesMovimientosPieza(tamaño, posicion, generarPiezaParaJugar("""Introduce si quieres jugar con la "torre", "alfil", "dama" o "caballo"."""))
    println("Las posibles posiciones a las que se puede mover la pieza(se representa con un '9'), son(las marcadas en '1'):")
    println(escribirMatriz(tablero))

}

/**
 * funcion par guardar las coordenadas de fila y columna como valor numerico en un vector
 * @param coordenadas el mensaje con las coordenadas que vamos a guardar
 * @return el vector donde guardamos como valor numerico la fila y columna seleccionada para colocar la pieza en el tablero
 */
fun tomarPosicionFilaColumna(coordenadas: String): IntArray{
    var posiciones = IntArray(2)
    posiciones[0] = coordenadas[0].digitToInt() - 1
    posiciones[1] = coordenadas[2].digitToInt() - 1
    return posiciones
}
/**
 * funcion que implementa con 1 las posibles casillas a las que se puede mover la pieza que se representa con un 9, en las coordenadas seleccionadas
 * @param tamaño es el tamaño de filas y columnas del panel de ajedrez
 * @param posicion es el vector con la fila y columna sobre las que pondremos la pieza
 * @param pieza es un valor numerico que representa la pieza elegida
 * @return el tablero de ajedrez mostrando la posicion de la pieza y las posibles posicones a las que se puede mover
 */
fun mostrarPosiblesMovimientosPieza(tamaño: Int, posicion: IntArray, pieza: Int): Array<IntArray>{
    var tablero = Array(tamaño){IntArray(tamaño)}
    val fila = posicion[0]
    val columna = posicion[1]
    if(pieza == 1){
        escribirPosiblesPosicionesTorres(fila, columna, tablero, tamaño)
    }else{
        if(pieza == 2){
            escribirPosiblesPosicionesAlfil(fila, columna, tablero, tamaño)
        }else{
            if(pieza == 3){
                escribirPosiblesPosicionesTorres(fila, columna, tablero, tamaño)
                escribirPosiblesPosicionesAlfil(fila, columna, tablero, tamaño)
            }else{
                escribirPosiblesPosicionesCaballo(fila, columna, tablero, tamaño)
            }
        }
    }
    tablero[fila][columna] = 9
    return tablero
}

/**
 * funcion que escribe con 1 las posibles casillas a las que se puede mover el caballo
 * @param fila es la posicion de fila seleccionada
 * @param columna es el valor de columna seleccionado
 * @param tablero la matriz sobre la que escribiresmos los 1
 * @param tamaño el tamaño maximos de filas y columnas
 */
private fun escribirPosiblesPosicionesCaballo(fila: Int, columna: Int, tablero: Array<IntArray>, tamaño: Int) {
    if(fila - 2 >= 0 && fila - 2 < tamaño && columna - 1 >= 0 && columna - 1 < tamaño) {
        tablero[fila - 2][columna - 1] = 1
    }
    if(fila - 2 >= 0 && fila - 2 < tamaño && columna + 1 >= 0 && columna + 1 < tamaño) {
        tablero[fila - 2][columna + 1] = 1
    }
    if(fila - 1 >= 0 && fila - 1 < tamaño && columna - 2 >= 0 && columna - 2 < tamaño) {
        tablero[fila - 1][columna - 2] = 1
    }
    if(fila - 1 >= 0 && fila - 1 < tamaño && columna + 2 >= 0 && columna + 2 < tamaño) {
        tablero[fila - 1][columna + 2] = 1
    }
    if(fila + 2 >= 0 && fila + 2 < tamaño && columna - 1 >= 0 && columna - 1 < tamaño) {
        tablero[fila + 2][columna - 1] = 1
    }
    if(fila + 2 >= 0 && fila + 2 < tamaño && columna + 1 >= 0 && columna + 1 < tamaño) {
        tablero[fila + 2][columna + 1] = 1
    }
    if(fila + 1 >= 0 && fila + 1 < tamaño && columna - 2 >= 0 && columna - 2 < tamaño) {
        tablero[fila + 1][columna - 2] = 1
    }
    if(fila + 1 >= 0 && fila + 1 < tamaño && columna + 2 >= 0 && columna + 2 < tamaño) {
        tablero[fila + 1][columna + 2] = 1
    }
}
/**
 * funcion que escribe con 1 las posibles casillas a las que se puede mover el alfil
 * @param fila es la posicion de fila seleccionada
 * @param columna es el valor de columna seleccionado
 * @param tablero la matriz sobre la que escribiresmos los 1
 * @param tamaño el tamaño maximos de filas y columnas
 */
private fun escribirPosiblesPosicionesAlfil(fila: Int, columna: Int, tablero: Array<IntArray>, tamaño: Int) {
    var contF = 1
    var contC = 1
    for(filas in -(tamaño - 1)..tamaño - 1){
        for(columnas in -(tamaño - 1)..tamaño - 1){
            if(fila + contF >= 0 && fila + contF <= tamaño - 1 && columna + contC >= 0 && columna + contC <= tamaño - 1) {
                tablero[fila + contF][columna + contC] = 1
            }
            if(fila - contF >= 0 && fila - contF <= tamaño - 1 && columna - contC >= 0 && columna - contC <= tamaño - 1) {
                tablero[fila - contF][columna - contC] = 1
            }
            if(fila - contF >= 0 && fila - contF <= tamaño - 1 && columna + contC >= 0 && columna + contC <= tamaño - 1) {
                tablero[fila - contF][columna + contC] = 1
            }
            if(fila + contF >= 0 && fila + contF <= tamaño - 1 && columna - contC >= 0 && columna - contC <= tamaño - 1) {
                tablero[fila + contF][columna - contC] = 1
            }
        }
        contF++
        contC++
    }
}
/**
 * funcion que escribe con 1 las posibles casillas a las que se puede mover la torre
 * @param fila es la posicion de fila seleccionada
 * @param columna es el valor de columna seleccionado
 * @param tablero la matriz sobre la que escribiresmos los 1
 * @param tamaño el tamaño maximos de filas y columnas
 */
private fun escribirPosiblesPosicionesTorres(fila: Int, columna: Int, tablero: Array<IntArray>, tamaño: Int) {
    for(filas in -(tamaño - 1)..tamaño - 1){
        for(columnas in -(tamaño - 1)..tamaño - 1){
            if(fila + filas >= 0 && fila + filas <= tamaño - 1 && columna + columnas >= 0 && columna + columnas <= tamaño - 1) {
                tablero[fila][columna + columnas] = 1
                tablero[fila + filas][columna] = 1
            }
        }
    }
}
/**
 * función para ecribir las coordenadas sobre las que pondremos la pieza, usando patrones/ expresiones regulares.
 * @param mensaje un texto informativo de la accion a realizar
 * @param tamaño es el tamaño de filas y columnas del panel de ajedrez
 * @return el mensaje con la coordenadas escritas como indica el patrón
 */
fun generarCoordenadasPieza(mensaje: String, tamaño: Int): String{
    println(mensaje)
    var coordenadas = ""
    val regex = Regex("[1-8],[1-8]")
    do{
        coordenadas = readln()
        if(!regex.matches(coordenadas)){
            println("Esas coordenadas no son válidas, por favor, vuelva a introducir las coordenadas:")
        }
    }while(!regex.matches(coordenadas))
    return coordenadas
}
/**
 * funcion que selecciona un valor numerico a devolver segun la pieza seleccionada
 * @param mensaje un texto informativo donde se muestran los pasos a aseguir
 * @return el valor asociado a la pieza seleccionada
 */
fun generarPiezaParaJugar(mensaje: String): Int{
    println(mensaje)
    var caso = 0
    var pieza = ""
    do{
        pieza = readln()
        if(pieza == "torre"){
            caso = 1
        }else{
            if(pieza == "alfil"){
                caso = 2
            }else{
                if(pieza == "dama"){
                    caso = 3
                }else{
                    if(pieza == "caballo"){
                        caso = 4
                    }else{
                        println("La pieza introducida no existe, por favor, prueba de nuevo:")
                    }
                }
            }
        }
    }while(pieza != "torre" && pieza != "alfil" && pieza != "dama" && pieza != "caballo")
    return caso
}