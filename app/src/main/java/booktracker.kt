import java.util.Scanner

data class Book(
    val title: String,
    val author: String,
    val year: Int
)

class BookTracker {
    private val books = mutableListOf<Book>()


    fun addBook(title: String, author: String, year: Int) {
        books.add(Book(title, author, year))
    }


    fun displayBooks() {
        if (books.isEmpty()) {
            println("Brak książek w bazie.")
        } else {
            books.forEach { println("Tytuł: ${it.title}, Autor: ${it.author}, Rok wydania: ${it.year}") }
        }
    }
