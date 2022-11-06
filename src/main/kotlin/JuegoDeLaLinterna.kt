fun main(){
    var primos: Int = escribirNumeroPrimos("Por favor, introduzca cuantos primos hay (como mínimo 3 y como máximo 20):")
    do {
        var colocacion: IntArray = escribirColocacionPrimos(primos)
        println(colocacion.joinToString())
        var condicion = true
        if ((comprobacionVictoria(colocacion, primos))) {
            println("Esta colocacion es win seguro.")
        } else {
            println("Esa colocación no nos servirá, vamos a reacerla.")
            condicion = false
        }
        Thread.sleep(2000)
    }while(condicion == false)
}

fun comprobacionVictoria(colocacion: IntArray, primos: Int): Boolean{
    var auxiliarMayor = primos
    var auxiliarPosMax = 0
    var auxiliarMinimo = 1
    var auxiliarPosMin = 0
    for(i in colocacion.indices){
        if(colocacion[i] == auxiliarMinimo){
            auxiliarPosMin = i
        }
        if(colocacion[i] == auxiliarMayor){
            auxiliarPosMax = i
        }
    }
    return if(auxiliarPosMax < auxiliarPosMin){
        true
    }else{
        false
    }
}

fun escribirColocacionPrimos(primos: Int): IntArray{
    var colocacion: IntArray = IntArray(primos)
    var posicion = 0
    for(i in 1 .. primos){
        do{
            posicion= (0 until primos).random()
        }while(colocacion[posicion] != 0)
        colocacion[posicion] = i
    }
    return colocacion
}

fun escribirNumeroPrimos(mensaje: String): Int{
    println(mensaje)
    var primos = 0
    do{
        primos = readln().toInt()
        if(primos < 3 || primos > 20){
            println("Ese número de primos no es válido. Prueba de nuevo.")
        }
    }while(primos < 3 || primos > 20)
    return primos
}