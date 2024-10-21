import kotlin.random.Random

fun main() {
    val n1: Int = 1
    val n2: Int = 101
    var nTentativi: Int = 10

    println("Benvenuto, sei pronto ad indovinare un numero casuale tra $n1 e ${n2-1} in $nTentativi tentativi?")

    val valoreGenerato: Int = Random.nextInt(n1, n2)
    var valore: String?
    var valoreToInt: Int?

    var vittoria: Boolean = false

    do {
        print("$nTentativi) Inserisci un valore: ")
        valore = readlnOrNull()

        valoreToInt = valore?.toIntOrNull()
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
                it !in n1 until n2 -> println("Il valore inserito non è nel range previsto.")
                else -> {
                    vittoria = true
                }
            }

        } ?: println("Il valore da te inserito non è valido")
    } while (nTentativi > 0 && !vittoria)

    if (vittoria) println("Hai vinto! Uno spritz in arrivo per te!")
    else println("Hai perso. Ritenta!")

}