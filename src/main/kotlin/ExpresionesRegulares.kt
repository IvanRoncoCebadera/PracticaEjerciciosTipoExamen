import Utils.*

fun main(){
    var mensaje = "  joder viva cristo rey.  "
    println(mensaje)
    var mensajeLimpio = trim(mensaje.lowercase())
    println(mensajeLimpio)
    val vectorPalabras: Array<String> = split(mensajeLimpio)
    println(contentToString(vectorPalabras))
    println(joinToString(vectorPalabras, " "))
    println("La frase al reves se lee: ${joinToString(reversed(vectorPalabras), " ")}")
    var palabra = "hola"
    if(contains(vectorPalabras, palabra)){
        println("La palabra $palabra, si está dentro del texto.")
    }else{
        println("La palabra $palabra, no está dentro del texto.")
    }
}