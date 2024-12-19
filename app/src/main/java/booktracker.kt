data class Book(
    val title: String,
    val author: String,
    val year: Int
)

class BookTracker {
    private val books = mutableListOf<Book>()

    fun addBook(book: Book) {
        books.add(book)
    }

    fun filterByAuthor(author: String): List<Book> {
        return books.filter { it.author.equals(author, ignoreCase = true) }
    }

    fun filterByYear(year: Int): List<Book> {
        return books.filter { it.year == year }
    }

    fun sortBooksAlphabetically(): List<Book> {
        return books.sortedBy { it.title }
    }

    fun displayBooks() {
        if (books.isEmpty()) {
            println("Brak książek w bazie.")
        } else {
            books.forEach {
                println("Tytuł: ${it.title}, Autor: ${it.author}, Rok wydania: ${it.year}")
            }
        }
    }
}