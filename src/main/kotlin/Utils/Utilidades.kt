package Utils

/**
 * funcion para crear una matriz de tamaño el que le demos y con valores aleatorios
 * @param tamaño el tamaño elegido para la matriz, tanto de filas como de columnas
 * @return la matriz con valores aleatorios
 */
fun generarMatrizAleatoria(tamaño: Int): Array<IntArray>{
    var mensaje = ""
    val matriz = Array(tamaño){IntArray(tamaño)}
    for(i in matriz.indices){
        mensaje = ""
        for(j in matriz[i].indices){
            matriz[i][j] = (0 .. 9).random()
            mensaje = "$mensaje ${matriz[i][j]}"
        }
        println(mensaje)
    }
    return matriz
}

/**
 * funcion que pasa de una matriz a un array
 * @param matriz la matriz que queremos pasar a array
 * @param tamaño el tamaño de filas y columnas de la matriz
 * @retrun el array creado en funcion de la matriz
 */
fun generarArray(matriz: Array<IntArray>, tamaño: Int): IntArray{
    val array: IntArray = IntArray(tamaño*tamaño)
    var cont = 0
    for(i in matriz.indices){
        for(j in matriz[i].indices){
            array[cont] = matriz[i][j]
            cont++
        }
    }
    return array
}
/**
 * funcion para representar/escribir una matriz
 * @param matriz es la matriz que deseamos representar
 */
fun escribirMatriz(matriz: Array<IntArray>){
    var mensaje = ""
    for(i in matriz.indices){
        mensaje = ""
        for(j in matriz[i].indices){
            mensaje = "$mensaje ${matriz[i][j]}"
        }
        println(mensaje)
    }
}
/**
 * funcion para introducir las coordenadas fila/columna
 * @param tamaño el tamaño de las filas y columnas
 * @param mensaje un texto informativo con el proceso ha realizar
 * @return la coordenada de la fila/columna
 */
fun generarCoordenadas(tamaño: Int, mensaje: String): Int{
    println(mensaje)
    var coordenada = 0
    do{
        coordenada = readln().toInt() - 1
        if(coordenada < 0 || coordenada >= tamaño){
            println("Esa coordenada no es valida, prueba de nuevo:")
        }
    }while(coordenada < 0 || coordenada >= tamaño)
    return coordenada
}