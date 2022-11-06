fun main(){
    val tamaño = 20
    val valorMax = 20
    val panel: IntArray = generarPanelAleatorio(tamaño, valorMax)
    println(panel.joinToString())
    var posicion = leerPosicionElegida(tamaño)
    var contador = 0
    operar(panel, posicion, tamaño, contador)
}

private fun operar(panel: IntArray, posicion: Int, tamaño: Int, contador: Int) {
    var posicion1 = posicion
    var contador1 = contador
    do {
        var informante = "izquierda"
        var sumaEIzq = sumarElementos(panel, posicion1, informante, tamaño)
        informante = "derecha"
        var sumaEDer = sumarElementos(panel, posicion1, informante, tamaño)
        println("Las suma de los elementos de la izquierda a la posicion es: $sumaEIzq, y los de la derecha es: $sumaEDer.")
        informante = "izquierda"
        var relacion = "mayores"
        var sumaEIzqMayores = cuentaElementosMayoresMenores(panel, posicion1, informante, tamaño, relacion)
        relacion = "menores"
        var sumaEIzqMenores = cuentaElementosMayoresMenores(panel, posicion1, informante, tamaño, relacion)
        informante = "derecha"
        relacion = "mayores"
        var sumaEDerMayores = cuentaElementosMayoresMenores(panel, posicion1, informante, tamaño, relacion)
        relacion = "menores"
        var sumaEDerMenores = cuentaElementosMayoresMenores(panel, posicion1, informante, tamaño, relacion)
        println("Las suma de los elementos de la izquierda mayores a la posicion hay: $sumaEIzqMayores, los menores hay: $sumaEIzqMenores, y los de la derecha, los mayores hay: $sumaEDerMayores, y menores hay: $sumaEDerMenores.")
        println()
        println(
            "La posicion elegida tiene asociado el número: ${panel[posicion1]}. De manera que ahora se repite el trabajo con la posicion como pivote ${
                escribirNuevoPivote(
                    panel[posicion1]
                )
            }"
        )
        posicion1 = escribirNuevoPivote(panel[posicion1])
        contador1++
        println()
        Thread.sleep(4000)
    } while (contador1 <= 1)
}

fun escribirNuevoPivote(numero: Int): Int{
    var posicion = 0
    if(numero > 0){
        posicion = numero - 1
    }else{
        posicion = (numero + 1) * -1
    }
    return posicion
}
fun cuentaElementosMayoresMenores(panel: IntArray, posicion: Int, informante: String, tamaño: Int, relacion: String): Int{
    var contador = 0
    if(informante == "izquierda"){
        if(relacion == "mayores") {
            for (i in 0 until posicion) {
                if(panel[i] > panel[posicion]){
                 contador++
                }
            }
        }else{
            for (i in 0 until posicion) {
                if(panel[i] < panel[posicion]){
                    contador++
                }
            }
        }
    }else{
        if(relacion == "mayores") {
            for (i in posicion + 1 until tamaño) {
                if(panel[i] > panel[posicion]){
                    contador++
                }
            }
        }else{
            for (i in posicion + 1 until tamaño) {
                if(panel[i] < panel[posicion]){
                    contador++
                }
            }
        }
    }
    return contador
}
fun sumarElementos(panel: IntArray, posicion: Int, informante: String, tamaño: Int): Int{
    var suma = 0
    if(informante == "izquierda"){
        for(i in 0 until posicion){
            suma = suma + panel[i]
        }
    }else{
        for(i in posicion + 1 until tamaño){
            suma = suma + panel[i]
        }
    }
    return suma
}
fun leerPosicionElegida(tamaño: Int): Int{
    println("Por favor, introduzca la posición entre 1 y $tamaño, que se establecera como pivote para los siguientes procesos:")
    var posicion = 0
    do{
        posicion = readln().toInt() - 1
        if(posicion < 0 || posicion > tamaño){
            println("Ese valor de posición no vale. Prueba de nuevo:")
        }
    }while(posicion < 0 || posicion > tamaño)
    return posicion
}
fun generarPanelAleatorio(tamaño: Int, valorMax: Int): IntArray{
    var vector = IntArray(tamaño)
    for(i in vector.indices){
        vector[i] = (-valorMax .. valorMax).random()
    }
    return vector
}