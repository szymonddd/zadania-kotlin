import java.util.Scanner

data class Book(val title: String, val author: String, val year: Int)

class BookTracker {
    private val books = mutableListOf<Book>()


    fun addBook(title: String, author: String, year: Int) = books.add(Book(title, author, year))

    fun displayBooks() =
        if (books.isEmpty()) println("Brak ksiazek w bazie.")
        else books.forEach { println("Tytul: ${it.title}, Autor: ${it.author}, Rok wydania: ${it.year}") }

    fun filterByAuthor(author: String) =
        books.filter { it.author.equals(author, ignoreCase = true) }
            .takeIf { it.isNotEmpty() }
            ?.forEach { println(it) }
            ?: println("Brak ksiazek autora '$author'.")

    fun filterByYear(year: Int) =
        books.filter { it.year == year }
            .takeIf { it.isNotEmpty() }
            ?.forEach { println(it) }
            ?: println("Brak ksiazek wydanych w $year.")

    fun sortBooks() = books.sortedBy { it.title }.forEach { println(it) }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val tracker = BookTracker()

    while (true) {
        println("\nWybierz opcje:")
        println("1. Dodaj ksiazke")
        println("2. Wyswietl wszystkie ksiazki")
        println("3. Filtrowanie ksiazek po autorze")
        println("4. Filtrowanie ksiazek po roku wydania")
        println("5. Sortowanie ksiazek alfabetycznie")
        println("6. Zakoncz")

        when (scanner.nextInt()) {
            1 -> {
                scanner.nextLine()
                println("Podaj tytul ksiazki:")
                val title = scanner.nextLine()
                println("Podaj autora ksiazki:")
                val author = scanner.nextLine()
                println("Podaj rok wydania ksiazki:")
                val year = scanner.nextInt()
                tracker.addBook(title, author, year)
                println("Ksiazka '$title' zostala dodana.")
            }
            2 -> tracker.displayBooks()
            3 -> {
                scanner.nextLine()
                println("Podaj autora ksiazki:")
                val author = scanner.nextLine()
                tracker.filterByAuthor(author)
            }
            4 -> {
                println("Podaj rok wydania ksiazki:")
                val year = scanner.nextInt()
                tracker.filterByYear(year)
            }
            5 -> tracker.sortBooks()
            6 -> {
                println("Zakonczenie programu.")
                break
            }
            else -> println("Niepoprawna opcja. Sprobuj ponownie.")
        }
    }
}
