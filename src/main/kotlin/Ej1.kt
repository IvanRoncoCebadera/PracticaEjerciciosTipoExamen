fun main(){
    val maximosDigitos = 5
    val digito1 = generarNumeroMaximo5Digitos("Por favor, introduzca el primer número de como máximo 5 digitos y positivo, al que después le sumaremos el suiguiente que introduzcas:", maximosDigitos)
    val digito2 = generarNumeroMaximo5Digitos("Ahora, introduce el segundo numero, siguiendo las mismas normas que cunado introduciste el primero:", maximosDigitos)
    representacionPasoAPaso(digito1, digito2)
}
fun representacionPasoAPaso(digito1: IntArray, digito2: IntArray){
    var resultado = ""
    var acarreo = ""
    for(i in digito1.size - 1 downTo 0){
        if((digito1[i] + digito2[i]) > 10) {
            acarreo = "1$acarreo"
            resultado = "${digito1[i] + digito2[i] - 10}$resultado"
        }else{
            acarreo = " $acarreo"
            resultado = "${digito1[i] + digito2[i]}$resultado"
        }
        println("")
        println("  $acarreo")
        println("  ${digito1.joinToString("")}")
        println("+ ${digito2.joinToString("")}")
        println("----------")
        println("  $resultado")
        Thread.sleep(5000)
    }
}

private fun numeroVecesRepetirProceso(digitos1: Int, digitos2: Int): Int {
    var numeroVeces = 0
    if (digitos1 > digitos2) {
        numeroVeces = digitos1
    } else {
        if (digitos1 < digitos2) {
            numeroVeces = digitos2
        } else {
            numeroVeces = digitos2
        }
    }
    return numeroVeces
}

fun numeroDigitos(digito1: Int): Int {
    var numDividir = 0
    var contador = 0
    numDividir = digito1
    while (numDividir > 1) {
        numDividir = numDividir / 10
        contador++
    }
    return contador
}

fun generarNumeroMaximo5Digitos(mensaje: String, digitos: Int): IntArray{
    println(mensaje)
    var numero = 0.0
    var contador = 0
    var numDividir = 0
    var resultado = 0.0
    do{
        contador = 0
        numero = readln().toDouble()
        numDividir = numero.toInt()
        while(numDividir > 1){
            numDividir = numDividir / 10
            contador++
        }
        if(contador > digitos || numero < 0){
            println("El numero introducido no es valido, vuleva a meterlo:")
        }
    }while(contador > digitos || numero < 0)
    var array = IntArray(contador)
    for(i in array.size - 1 downTo 0){
        numero = numero / 10
        numDividir = numero.toInt()
        resultado = (numero - numDividir)*10
        array[i] = resultado.toInt()
    }
    return array
}