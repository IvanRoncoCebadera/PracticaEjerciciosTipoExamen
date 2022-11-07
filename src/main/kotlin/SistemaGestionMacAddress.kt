import kotlin.system.exitProcess

fun main(){
    var almacenMacs: Array<String> = Array<String>(5){""}
    do {
        var opcion: Int = menuOpciones()
        when (opcion) {
            1 -> println(mostrarListaMacs(almacenMacs, "Actualmente, tu lista de Macs se encuentra asi:"))
            2 -> almacenMacs = añadirMac(almacenMacs)
            3 -> almacenMacs = añadirMacs(almacenMacs)
            4 -> println(informarExistenciaMacEnAlmacen(almacenMacs))
            5 -> almacenMacs = actualizarAlmacen(almacenMacs)
            6 -> almacenMacs = eliminarMacDeAlmacen(almacenMacs)
            0 -> exitProcess(0)
        }
    }while(opcion != 0)
}

fun eliminarMacDeAlmacen(vector: Array<String>): Array<String>{
    var auxiliar = vector
    var mac = introducirMac("Por favor, introduzca la Mac que quiere buscar en el almacen, para eliminar:")
    var posicion = buscarMac(vector, mac)
    if(posicion != -1){
        auxiliar[posicion] = ""
        println(mostrarListaMacs(auxiliar, "Actualmente, tu lista de Macs se encuentra asi:"))
    }else{
        println("Esa Mac no existe, por lo que no hay Mac a eliminar.")
    }
    println("Como has borrado una Mac, voy a redimensionar el array reduciendo su tamaño:")
    auxiliar = disminuirAlmacenMac(auxiliar)
    println(mostrarListaMacs(auxiliar, "Tras la redimensión, tu lista de Macs se encuentra asi:"))
    return auxiliar
}

fun disminuirAlmacenMac(vector: Array<String>): Array<String>{
    var auxiliar: Array<String> = Array<String>( contarMacsEnAlmacen(vector)){""}
    var cont = 0
    for(i in vector.indices){
        if(vector[i] != ""){
            auxiliar[cont] = vector[i]
            cont++
        }
    }
    return auxiliar
}

private fun contarMacsEnAlmacen(vector: Array<String>): Int {
    var contMacs = 0
    for (i in vector.indices) {
        if (vector[i] == "") {
            contMacs++
        }
    }
    return contMacs
}

fun actualizarAlmacen(vector: Array<String>): Array<String>{
    var auxiliar = vector
    var mac = introducirMac("Por favor, introduzca la Mac que quiere buscar en el almacen, para actualizar:")
    var posicion = buscarMac(vector, mac)
    if(posicion != -1){
        mac = introducirMac("Por favor, introduzca la nueva Mac que guardar en el almacen:")
        auxiliar[posicion] = mac
        println(mostrarListaMacs(auxiliar, "Actualmente, tu lista de Macs se encuentra asi:"))
    }else{
        println("Esa Mac no existe, por lo que no hay Mac a actualizar.")
    }
    return auxiliar
}

fun informarExistenciaMacEnAlmacen(vector: Array<String>): String{
    var mac = introducirMac("Por favor, introduzca la Mac que quiere buscar en el almacen:")
    var posicion = buscarMac(vector, mac)
    return if(posicion != -1){
        "La Mac que busca, si se encuentra en el almacén, está en la posición ${posicion + 1}."
    }else{
        "Por desgracia, no se ha encontrado la Mac que busca."
    }
}

fun buscarMac(vector: Array<String>, mac: String): Int{
    for(i in vector.indices){
        if(vector[i] == mac){
            return i
        }
    }
    return -1
}

fun añadirMacs(macs: Array<String>): Array<String>{
    var vector = macs
    var numeroMacs = escribirCantidadMacsAIntroducir("Por favor, introduzca el número de Macs que deseas introducir (mínimo 2 y máximo 20):")
    for(i in 1..numeroMacs) {
        var cont = 0
        var mac: String = introducirMac("Por favor, introduzca la Mac que quiere añadir:")
        do {
            for (i in vector.indices) {
                if (vector[i] == "" && cont == 0) {
                    vector[i] = mac
                    cont++
                }
            }
            if (cont == 0) {
                darElPegoDeEstarCargando()
                vector = ampliarAlmacenMac(vector)
            }
        } while (cont == 0)
    }
    println(mostrarListaMacs(vector, "Actualmente, tu lista de Macs se encuentra asi:"))
    return vector
}

private fun darElPegoDeEstarCargando() {
    println("Esa última Mac, ha superado el límite de almacenamiento del array, espera un momento mientras lo aumento...")
    Thread.sleep(2250)
    println("Ya está listo, puedes continuar insertando Macs.")
}

fun escribirCantidadMacsAIntroducir(mensaje: String): Int{
    println(mensaje)
    var cantidad = 0
    do{
        cantidad = readln().toIntOrNull() ?: -1
        if(cantidad < 2 || cantidad > 20){
            println("Ese valor de cantidad no es válido, por favor, vuelva a introducir una cantidad:")
        }
    }while(cantidad < 2 || cantidad > 20)
    return cantidad
}

fun añadirMac(macs: Array<String>): Array<String>{
    var vector = macs
    var cont = 0
    var mac: String = introducirMac("Por favor, introduzca la Mac que quiere añadir:")
    do {
        for (i in vector.indices) {
            if (vector[i] == "" && cont == 0) {
                vector[i] = mac
                cont++
            }
        }
        if (cont == 0) {
            darElPegoDeEstarCargando()
            vector = ampliarAlmacenMac(vector)
        }
    }while(cont == 0)
    println(mostrarListaMacs(vector, "Actualmente, tu lista de Macs se encuentra asi:"))
    return vector
}

fun ampliarAlmacenMac(vector: Array<String>):Array<String>{
    var auxiliar: Array<String> = Array<String>(vector.size + 5){""}
    auxiliar = copiarVector(auxiliar, vector)
    return auxiliar
}

fun copiarVector(auxiliar: Array<String>, vector: Array<String>): Array<String>{
    for(i in vector.indices){
        auxiliar[i] = vector[i]
    }
    return auxiliar
}

private fun introducirMac(mensaje: String): String {
    var mac = ""
    println(mensaje)
    val regex = Regex("^([0-9a-fA-F]{2}[:-]){5}([0-9a-fA-F]{2})\$")
    do {
        mac = readln()
        if (!regex.matches(mac)) {
            println("Esa dirección de Mac no es válida, por favor, vuelva a introducirla:")
        }
    } while (!regex.matches(mac))
    return mac
}

fun mostrarListaMacs(macs: Array<String>, mensaje: String): String{
    println(mensaje)
    var lista = StringBuilder()
    for(i in macs.indices){
        if(i == 0){
            lista.append("[${macs[i]}, ")
        }else{
            if(i == macs.size - 1){
                lista.append("${macs[i]}]")
            }else{
                lista.append("${macs[i]}, ")
            }
        }

    }
    return lista.toString()
}

fun menuOpciones(): Int{
    var opcion = 0
    do{
        println("[1] Mostrar listado de Macs")
        println("[2] Añadir una Mac")
        println("[3] Añadir varias Macs")
        println("[4] Buscar existencia de Mac")
        println("[5] Actualizar una Mac")
        println("[6] Eliminar una Mac")
        println("[0] Finalizar")
        opcion = readln().toIntOrNull() ?: -1
        if(opcion in (0..6)){
            return opcion
        }else{
            println("Esa no es una opción válida. Prueba de nuevo:")
        }
    }while(true)
}