class Krokomierz {

    companion object {
        var liczbaKrokow: Int = 0
    }

    fun zrobKrok() {
        liczbaKrokow++
        println("Liczba kroków: $liczbaKrokow")
    }

    fun resetujLicznik() {
        liczbaKrokow = 0
        println("Licznik kroków został zresetowany.")
    }
}