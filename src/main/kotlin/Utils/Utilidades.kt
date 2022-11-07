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

fun trim(mensaje: String): String{
    var indices1 = 0
    var indices2 = mensaje.length - 1
    while (mensaje[indices1] !in ('a'..'z')) {
        indices1++
    }
    while (mensaje[indices2] !in ('a'..'z')) {
        indices2--
    }
    return  mensaje.substring(indices1 .. indices2)
}

fun split(mensaje: String): Array<String>{
    var tamaño = 0
    for(i in mensaje.indices){
        if(mensaje[i] !in ('a'..'z')){
            tamaño++
        }
    }
    var indice1 = 0
    var indice2 = 0
    var cont = 0
    val vector: Array<String> = Array<String>(tamaño) {""}
    for(j in mensaje.indices){
        if(mensaje[j] !in ('a'..'z')){
            if(cont != tamaño - 1){
                indice2 = j
                vector[cont] = substring(indice1, indice2, mensaje)
                indice1 = indice2 + 1
            }else{
                indice2 = mensaje.length
                vector[cont] = substring(indice1, indice2, mensaje)
            }
            cont++
        }
    }
    return vector
}

fun contentToString(vector: Array<String>): String{
    var mensaje = StringBuilder()
    for(i in vector.indices){
        mensaje.append("${vector[i]}")
    }
    return mensaje.toString()
}

fun joinToString(vector: Array<String>, delimetre: String): String{
    var mensaje = StringBuilder()
    for(i in vector.indices){
        if(i < vector.size - 1) {
            mensaje.append("${vector[i]}$delimetre")
        }else{
            mensaje.append("${vector[i]}")
        }
    }
    return mensaje.toString()
}

fun reversed(vector: Array<String>): Array<String>{
    val vectorReversed: Array<String> = Array<String>(vector.size) {""}
    var cont = vector.size - 1
    for(i in vector.indices){
        vectorReversed[i] = vector[cont]
        cont--
    }
    return vectorReversed
}

fun substring(indice1: Int, indice2: Int, texto: String): String{
    var mensaje = StringBuilder()
    for(i in indice1 until indice2){
        mensaje.append("${texto[i]}")
    }
    return mensaje.toString()
}

fun contains(vector: Array<String>, palabra: String): Boolean{
    for(i in vector.indices){
        if(vector[i] == palabra){
            return true
        }
    }
    return false
}