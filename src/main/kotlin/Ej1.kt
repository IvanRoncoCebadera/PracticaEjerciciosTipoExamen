fun main(){
    val numero1 = generarNumeroMaximo5Digitos("Por favor, introduzca el primer número de como máximo 5 digitos y positivo, al que después le sumaremos el suiguiente que introduzcas:")
    val numero2 = generarNumeroMaximo5Digitos("Ahora, introduce el segundo numero, siguiendo las mismas normas que cunado introduciste el primero:")
    representacionPasoAPaso(numero1, numero2)
}
fun representacionPasoAPaso(numero1: String, numero2: String){
    var resultado = ""
    var numeros1 = ""
    var numeros2 = ""
    var acarreo = "0"
    var cont = 0
    for(i in numero1.length - 1 downTo 0){
        if((numero1[i].digitToInt() + numero2[i].digitToInt()) >= 10) {
            acarreo = "1${acarreo}"
            resultado = "${(numero1[i].digitToInt() + numero2[i].digitToInt()) - 10 + acarreo[acarreo.length - 1 - cont].digitToInt()}$resultado"
            println("Acarreamos un 1")
        }else{
            acarreo = "0${acarreo}"
            resultado = "${(numero1[i].digitToInt() + numero2[i].digitToInt() + acarreo[acarreo.length - 1 - cont].digitToInt())}$resultado"
            println("No se acarrea nada")
        }
        numeros1 = "${numero1[i]}$numeros1"
        numeros2 = "${numero2[i]}$numeros2"
        println("")
        println(" $acarreo")
        println("  $numeros1")
        println("+ $numeros2")
        println("----------")
        println("  $resultado")
        Thread.sleep(2000)
        cont++
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

fun generarNumeroMaximo5Digitos(mensaje: String): String{
    println(mensaje)
    var numero = ""
    do{
        numero = readln()
        if(numero.length < 0 || numero.length > 5){
            println("Ese numero no es válido")
        }
    }while(numero.length < 0 || numero.length > 5)
    return numero
}