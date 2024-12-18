class Krokomierz {

    companion object {
        var liczbaKrokow: Int = 0
    }

    fun zrobKrok() {
        liczbaKrokow++
        println("Liczba krokow: $liczbaKrokow")
    }

    fun resetujLicznik() {
        liczbaKrokow = 0
        println("Licznik kroków zostal zresetowany.")
    }
}
fun main() {
    val krokomierz = Krokomierz()

    while (true) {
        println("\nCo chcesz zrobic?")
        println("1. Zrob krok")
        println("2. Zresetuj licznik krokow")
        println("3. Zakoncz")

        print("Wybór: ")
        val wybor = readLine()?.toIntOrNull()

        when (wybor) {
            1 -> krokomierz.zrobKrok()
            2 -> krokomierz.resetujLicznik()
            3 -> {
                println("Dziekujemy za uzywanie aplikacji!")
                break
            }
            else -> println("Niepoprawny wybor, sprobuj ponownie.")
        }
    }
}