fun main(){
    val bits = 8
    var numeroEntero: Int = generarNumeroEntero(bits)
    val numeroBinario: IntArray = generarVectorNumeroBinario(numeroEntero, bits)
    println("El número entero introducido, pasado a binario queda como:")
    println(numeroBinario.joinToString(" "))
    Thread.sleep(2000)
    val numeroCa1: IntArray = generarVectorCa1(numeroBinario, bits)
    println("El número binario, pasado a Ca1 queda como:")
    println(numeroCa1.joinToString(" "))
    println("Y además, representa al número -$numeroEntero.")
    Thread.sleep(2000)
    val numeroCa2: IntArray = generarVectorCa2(numeroCa1, bits)
    println("El número Ca1, pasado a Ca2 queda como:")
    println(numeroCa2.joinToString(" "))
    println("Y además, representa al número -${numeroEntero + 1}.")
}
fun generarVectorCa2(numeroCa1: IntArray, bits: Int): IntArray{
    var numeroCa2: IntArray = IntArray(bits)
    var condicion = true
    for(i in bits - 1 downTo 0){
        if(condicion == true) {
            if (numeroCa1[i] == 1) {
                numeroCa2[i] = 0
            }else{
                numeroCa2[i] = 1
                condicion = false
            }
        }else{
            numeroCa2[i] = numeroCa1[i]
        }
    }
    return numeroCa2
}
fun generarVectorCa1(vectorBinario: IntArray, bits: Int): IntArray{
    var vectorCa1: IntArray = IntArray(bits)
    for(i in vectorCa1.indices){
        if(vectorBinario[i] == 1){
            vectorCa1[i] = 0
        }else{
            vectorCa1[i] = 1
        }
    }
    return vectorCa1
}
fun generarVectorNumeroBinario(numeroEntero: Int, bits: Int): IntArray{
    var vector: IntArray = IntArray(bits)
    var numero = numeroEntero
    var contador = 0
    for(i in (bits - 1 downTo 0)){
        if(numero >= (elevar(i - 1))){
            numero = numero - elevar(i - 1)
            vector[contador] = 1
        }else{
            vector[contador] = 0
        }
        contador++
    }
    return vector
}
fun generarNumeroEntero(bits: Int): Int{
    println("Por favor, introduzca un número entero, puedes elegir del número 0 al numero ${elevar(bits - 2) - 1}")
    var numeroE = 0
    do{
        numeroE = readln().toInt()
        if(numeroE < 0 || numeroE > elevar(bits - 2)){
            println("Ese, no es un posible valor a representar. Prueba de nuevo:")
        }
    }while(numeroE < 0 || numeroE > elevar(bits - 2))
    return numeroE
}
fun elevar(bits: Int): Int{
    val numeroBase = 2
    var resultado = numeroBase
    if(bits >= 0) {
        for (i in 1..bits) {
            resultado = resultado * numeroBase
        }
    }else{
        resultado = 1
    }
    return resultado
}