import kotlin.random.Random

fun main() {
    val n1: Int = 1 //numero iniziale range
    val n2: Int = 101 //numero finale range (escluso)
    var nTentativi: Int = 10 //numero tentativi rimanenti all'utente

    //$n1 => operatore dollaro per recuperare il valore dalla variabile
    //${n2 -1} => operatore dollaro + graffe per eseguire un'azione al suo interno
    println("Benvenuto, sei pronto ad indovinare un numero casuale tra $n1 e ${n2-1} in $nTentativi tentativi?")


    val valoreGenerato: Int = Random.nextInt(n1, n2) //valore generato dal computer
    var valore: String? //valore inserito dall'utente (alfanumerico)
    var valoreToInt: Int? //valore inserito dall'utente convertito in intero

    var vittoria: Boolean = false //variabile per condizione uscita dal ciclo

    do {
        print("$nTentativi) Inserisci un valore: ")
        valore = readlnOrNull() //recupero valore dalla console (inserito dall'utente)

        valoreToInt = valore?.toIntOrNull() //conversione valore inserito dall'utente da stringa ad intero
        valoreToInt?.let {

            when {
                it < valoreGenerato -> {
                    println("Il valore inserito è minore di quello generato.")
                    nTentativi--
                }
                it > valoreGenerato -> {
                    println("Il valore inserito è maggiore di quello generato.")
                    nTentativi--
                }
                //controllo che il valore non sia nel range previsto
                it !in n1 until n2 -> println("Il valore inserito non è nel range previsto.")
                else -> vittoria = true

            }

        } ?: println("Il valore da te inserito non è valido")
    } while (nTentativi > 0 && !vittoria)

    if (vittoria) println("Hai vinto! Uno spritz in arrivo per te!")
    else println("Hai perso. Ritenta!")

}