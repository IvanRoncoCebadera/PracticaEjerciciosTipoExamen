fun main(){
    var suma = 0
    var turno = "jugador"
    var dado = (1..6).random()
    suma = dado
    println("En el primer turno (el del jugador), se tiran los dados y sale $dado, por ende actaulmente tenemos $suma puntos en total.")
    do {
        turno = escribirTurnoCorrespondiente(turno)
        dado = aumentarPuntuacion(dado)
        println("En la siguiente jugada (le toca al $turno), a salido el número $dado.")
        suma = suma + dado
        println("Actualmente, hay $suma puntos.")
    }while(suma < 100)
    println("Se acabó el juego el $turno, fue quien llegó a los 100 puntos, y por ende perdió.")
}

fun escribirTurnoCorrespondiente(turnoAc: String): String{
    var turno = ""
    if(turnoAc == "jugador"){
        turno = "ordenador"
    }else{
        turno = "jugador"
    }
    return turno
}

fun aumentarPuntuacion(dado: Int): Int{
    var valorDado = 0
    var num = (1..4).random()
    if(dado == 1 || dado == 6){
        if(num == 1){
            valorDado = 2
        }else{
            if(num == 2){
                valorDado = 3
            }else{
                if(num == 3){
                    valorDado = 4
                }else{
                    valorDado = 5
                }
            }
        }
    }else{
        if(dado == 2 || dado == 5){
            if(num == 1){
                valorDado = 1
            }else{
                if(num == 2){
                    valorDado = 3
                }else{
                    if(num == 3){
                        valorDado = 4
                    }else{
                        valorDado = 6
                    }
                }
            }
        }else{
            if(num == 1){
                valorDado = 1
            }else{
                if(num == 2){
                    valorDado = 2
                }else{
                    if(num == 3){
                        valorDado = 5
                    }else{
                        valorDado = 6
                    }
                }
            }
        }
    }
    return valorDado
}