import kotlin.random.Random


object Quotes {

    private val quotes = mutableListOf(
        "Nie czekaj. Czas nigdy nie bedzie odpowiedni. - Napoleon Hill",
        "Wszystko, czego potrzebujesz, to juz w Tobie. - Lao Tzu",
        "Sukces to suma malych wysilkow powtarzanych dzien po dniu. - Robert Collier"
    )

    fun getRandomQuote(): String {
        return quotes.random()
    }
    fun addQuote(quote: String) {
        quotes.add(quote)
        println("Nowy cytat zostal dodany do bazy.")
    }
}
fun main() {
    println("Losowy cytat: ${Quotes.getRandomQuote()}")

    val newQuote = "Najwieksza chwala w zyciu nie polega na tym, by nigdy nie upasc, lecz na tym, by po kazdym upadku powstac. - Nelson Mandela"
    Quotes.addQuote(newQuote)

    println("Losowy cytat po dodaniu: ${Quotes.getRandomQuote()}")
}