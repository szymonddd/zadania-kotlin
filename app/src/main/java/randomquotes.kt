import kotlin.random.Random


object Quotes {

    private val quotes = mutableListOf(
        "Nie czekaj. Czas nigdy nie będzie odpowiedni. - Napoleon Hill",
        "Wszystko, czego potrzebujesz, to już w Tobie. - Lao Tzu",
        "Sukces to suma małych wysiłków powtarzanych dzień po dniu. - Robert Collier"
    )

    fun getRandomQuote(): String {
        return quotes.random()
    }
    fun addQuote(quote: String) {
        quotes.add(quote)
        println("Nowy cytat został dodany do bazy.")
    }
}