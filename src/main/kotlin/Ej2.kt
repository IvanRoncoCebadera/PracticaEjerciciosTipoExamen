fun main(){
    val tropasDario = 18000
    val tropasAlejandro = 12000
    var contD = 0
    var contA = 0
    println("Las banderas de Dario III son:")
    var tropasMandadasDario: IntArray = divisionTropasDarioIIISegunColocacionBanderas(tropasDario)
    println()
    println("En el flanco izquierdo se enviaron: ${tropasMandadasDario[0]}")
    println("En el flanco central se enviaron: ${tropasMandadasDario[1]}")
    println("En el flanco derecho se enviaron: ${tropasMandadasDario[2]}")
    var tropasMandadasAlejandro: IntArray = divisionTropasAlejandro(tropasAlejandro)
    println()
    println("En el flanco izquierdo se enviaron: ${tropasMandadasAlejandro[0]}")
    println("En el flanco central se enviaron: ${tropasMandadasAlejandro[1]}")
    println("En el flanco derecho se enviaron: ${tropasMandadasAlejandro[2]}")
    var resultadoFlancoIzquierdo = generarResultadoPelea(tropasMandadasDario[0], tropasMandadasAlejandro[0])
    var resultadoFlancoCentral = generarResultadoPelea(tropasMandadasDario[1], tropasMandadasAlejandro[1])
    var resultadoFlancoDerecho = generarResultadoPelea(tropasMandadasDario[2], tropasMandadasAlejandro[2])
    calcularGanador(resultadoFlancoIzquierdo, contA, contD, resultadoFlancoCentral, resultadoFlancoDerecho)
}

private fun calcularGanador(
    resultadoFlancoIzquierdo: Int,
    contA: Int,
    contD: Int,
    resultadoFlancoCentral: Int,
    resultadoFlancoDerecho: Int
) {
    var contA1 = contA
    var contD1 = contD
    if (resultadoFlancoIzquierdo == 1) {
        contA1++
    } else {
        contD1++
    }
    if (resultadoFlancoCentral == 1) {
        contA1++
    } else {
        contD1++
    }
    if (resultadoFlancoDerecho == 1) {
        contA1++
    } else {
        contD1++
    }
    if(contD > contA){
        println("Dario ganó.")
    }else{
        println("Alejandro ganó.")
    }
}

fun generarResultadoPelea(tropasDario: Int, tropasAlejandro: Int): Int{
    var caso = 0
    var ganar = 0
    var tropasD = tropasDario
    var tropasA = tropasAlejandro
    if(tropasA == 0){
        println("Dario ganó la pelea.")
        caso = 2
    }else{
        if(tropasD == 0){
            println("Alejandro ganó la pelea.")
            caso = 1
        }else{
            if(tropasD < tropasA){
                ganar = (1 .. 100).random()
                if(ganar <= 70){
                    println("Alejandro ganó la pelea.")
                    caso = 1
                }else{
                    println("Dario ganó la pelea.")
                    caso = 2
                }
                println("Tras la batalla, ambos ejercitos han quedado con:")
                println("${tropasA*0.7} tropas de Alejandro, y ${tropasD*0.4} tropas de Dario.")
            }else{
                ganar = (1 .. 100).random()
                if(ganar <= 50){
                    println("Alejandro ganó la pelea.")
                    caso = 1
                }else{
                    println("Dario ganó la pelea.")
                    caso = 2
                }
                println("Tras la batalla, ambos ejercitos han quedado con:")
                println("${tropasA*0.4} tropas de Alejandro, y ${tropasD*0.5} tropas de Dario.")
            }
        }
    }
    return caso
}
fun divisionTropasAlejandro(tropasAlejandro: Int): IntArray{
    var tropas = tropasAlejandro
    var cant = 0
    var cantTropas: IntArray = IntArray(3)
    println("Sabiendo las banderas de DarioIII, y por ende su distribución, divida su ejercito lo mejor posible para ganar.")
    println("Primero coloque el número de tropas que consideres en el flanco izquierdo:")
    do{
        cant = readln().toInt()
        if(cant < 0 || cant > tropasAlejandro){
            println("Ese valor de cantidad no sirve, por favor introduzcalo de nuevo:")
        }
    }while(cant < 0 || cant > tropasAlejandro)
    cantTropas[0] = cant
    tropas = tropas - cant
    println()
    println("Te quedan $tropas tropas.")
    println("Ahora, coloque el número de tropas que consideres en el flanco central:")
    do{
        cant = readln().toInt()
        if(cant < 0 || cant > tropasAlejandro){
            println("Ese valor de cantidad no sirve, por favor introduzcalo de nuevo:")
        }
    }while(cant < 0 || cant > tropasAlejandro)
    cantTropas[1] = cant
    tropas = tropas - cant
    println()
    println("Te quedan $tropas tropas.")
    println("Ahora, coloque el número de tropas que consideres en el flanco izquierdo:")
    do{
        cant = readln().toInt()
        if(cant < 0 || cant > tropasAlejandro){
            println("Ese valor de cantidad no sirve, por favor introduzcalo de nuevo:")
        }
    }while(cant < 0 || cant > tropasAlejandro)
    cantTropas[2] = cant
    tropas = tropas - cant
    println()
    println("Te quedan $tropas tropas.")
    return cantTropas
}
fun divisionTropasDarioIIISegunColocacionBanderas(tropasDario: Int): IntArray{
    var tropas = tropasDario
    var flanco = ""
    var bandera = ""
    var cantTropas = ""
    var tropasEnviadas: IntArray = IntArray(3)
    do {
        println("""Tienes $tropas tropas, seleccione a que flanco quieres enviar tropas ("izq","der" o "central"):""")
        if (tropas > 0) {
            do {
                flanco = readln()
                if (flanco == "izq") {
                    println("Ahora indique, que cantidad de las tropas totales quieres enviar (1/3 o 1/2 o 1).")
                    do {
                        cantTropas = readln()
                        if (cantTropas == "1/3") {
                            tropasEnviadas[0] = tropas / 3
                            tropas = tropas - tropas / 3
                            bandera = "aa"
                        } else {
                            if (cantTropas == "1/2") {
                                tropasEnviadas[0] = tropas / 2
                                tropas = tropas - tropas / 2
                                bandera = "ar"
                            } else {
                                if (cantTropas == "1") {
                                    tropasEnviadas[0] = tropas
                                    tropas = tropas - tropas
                                    bandera = "av"
                                } else {
                                    println("Ese no es un cantidad de tropas válida. Vuelva a introducirlo.")
                                }
                            }
                        }
                    } while (cantTropas != "1/3" && cantTropas != "1/2" && cantTropas != "1")
                } else {
                    if (flanco == "der") {
                        println("Ahora indique, que cantidad de las tropas totales quieres enviar (1/3 o 1/2 o 1).")
                        do {
                            cantTropas = readln()
                            if (cantTropas == "1/3") {
                                tropasEnviadas[2] = tropas / 3
                                tropas = tropas - tropas / 3
                                bandera = "ra"
                            } else {
                                if (cantTropas == "1/2") {
                                    tropasEnviadas[2] = tropas / 2
                                    tropas = tropas - tropas / 2
                                    bandera = "rr"
                                } else {
                                    if (cantTropas == "1") {
                                        tropasEnviadas[2] = tropas
                                        tropas = tropas - tropas
                                        bandera = "rv"
                                    } else {
                                        println("Ese no es un cantidad de tropas válida. Vuelva a introducirlo.")
                                    }
                                }
                            }
                        } while (cantTropas != "1/3" && cantTropas != "1/2" && cantTropas != "1")
                    } else {
                        if (flanco == "central") {
                            println("Ahora indique, que cantidad de las tropas totales quieres enviar (1/3 o 1/2 o 1).")
                            do {
                                cantTropas = readln()
                                if (cantTropas == "1/3") {
                                    tropasEnviadas[1] = tropas / 3
                                    tropas = tropas - tropas / 3
                                    bandera = "va"
                                } else {
                                    if (cantTropas == "1/2") {
                                        tropasEnviadas[1] = tropas / 2
                                        tropas = tropas - tropas / 2
                                        bandera = "vr"
                                    } else {
                                        if (cantTropas == "1") {
                                            tropasEnviadas[1] = tropas
                                            tropas = tropas - tropas
                                            bandera = "vv"
                                        } else {
                                            println("Ese no es un cantidad de tropas válida. Vuelva a introducirlo.")
                                        }
                                    }
                                }
                            } while (cantTropas != "1/3" && cantTropas != "1/2" && cantTropas != "1")
                        } else {
                            println("Ese no es un flanco válido. Vuelva a introducirlo.")
                        }
                    }
                }
            } while (flanco != "izq" && flanco != "der" && flanco != "central")
        } else {
            println("Lo siento, no tienes más tropas para enviar.")
            bandera = ""
        }
        println("Bandera: $bandera")
    }while(tropas > 0)
    return tropasEnviadas
}