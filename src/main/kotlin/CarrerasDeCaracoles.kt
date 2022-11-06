fun main(){
    var numeroCaracoles = escribirNumeroCaracoles("Por favor, introduzca el número de caracoles que participaran en la carrera (mínimo 2 y máximo 27):")
    val distincionCaracoles: CharArray = generarDistincionCaracoles(numeroCaracoles)
    println("Los caracoles disponibles para la carrera son:")
    println(escribirArray(distincionCaracoles))
    Thread.sleep(2000)
    println("Los posibles resultados de la carrera son:")
    println(escribirPosiblesGanadores(distincionCaracoles))
    Thread.sleep(2000)
    println(escribirPosiblesEmpates(distincionCaracoles))

}

fun escribirPosiblesEmpates(vector: CharArray): String{
    var mensaje = StringBuilder()
    for(i in vector.indices){
        for(j in 1 + i until vector.size){
            mensaje.append("El caracol ${vector[i]} empato en la carrera con el caracol ${vector[j]} en el primer puesto, y todos los demas perdieron.   ")
        }
    }
    return mensaje.toString()
}

fun escribirPosiblesGanadores(vector: CharArray): String{
    var mensaje = StringBuilder()
    for(i in vector.indices){
        mensaje.append("El caracol ${vector[i]} gana la carrera, y todos los demas pierden.   ")
    }
    return mensaje.toString()
}

fun escribirArray(vector: CharArray): String{
    var mensaje = StringBuilder()
    for(i in vector.indices){
        if(i == 0){
            mensaje.append("[${vector[i]}, ")
        }else{
            if(i == vector.size - 1){
                mensaje.append("${vector[i]}]")
            }else{
                mensaje.append("${vector[i]}, ")
            }
        }
    }
    return mensaje.toString()
}

fun generarDistincionCaracoles(caracoles: Int): CharArray{
    var colocacionCaracoles = CharArray(caracoles)
    val alfabeto = "abcdefghijklmnñopqrstuvwxyz"
    for(i in colocacionCaracoles.indices){
        colocacionCaracoles[i] = alfabeto[i]
    }
    return colocacionCaracoles
}

fun escribirNumeroCaracoles(mensaje: String): Int{
    println(mensaje)
    var caracoles = 0
    do{
        caracoles = readln().toInt()
        if(caracoles < 2){
            println("El numero de caracoles introducido ,es menor del mínimo requerido para la carrera. Vuelva a introducir un valor.")
        }
        if(caracoles > 27){
            println("El numero de caracoles introducido ,es mayor que el máximo posible para la carrera. Vuelva a introducir un valor.")
        }
    }while(caracoles < 2 || caracoles > 27)
    return caracoles
}