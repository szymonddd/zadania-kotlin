interface Question {
    fun askQuestion(): String
    fun checkAnswer(answer: String): Boolean
}


class MultipleChoiceQuestion(
    private val question: String,
    private val options: List<String>,
    private val correctAnswer: String
) : Question {
    override fun askQuestion(): String {
        return "$question\nOpcje: ${options.joinToString(", ")}"
    }

    override fun checkAnswer(answer: String): Boolean {
        return answer.equals(correctAnswer, ignoreCase = true)
    }
}


class TrueFalseQuestion(
    private val question: String,
    private val correctAnswer: Boolean
) : Question {
    override fun askQuestion(): String {
        return "$question (Prawda/Falsz)"
    }

    override fun checkAnswer(answer: String): Boolean {
        return (answer.equals("prawda", ignoreCase = true) && correctAnswer) ||
                (answer.equals("falsz", ignoreCase = true) && !correctAnswer)
    }
}
fun main() {
    val scanner = java.util.Scanner(System.`in`)

    val questions = listOf(
        MultipleChoiceQuestion("Jakie jest najwieksze miasto w Polsce?", listOf("Warszawa", "Krakow", "Gdansk", "Poznan"), "Warszawa"),
        TrueFalseQuestion("Ziemia jest plaska?", false),
        MultipleChoiceQuestion("Jaki jest kolor nieba?", listOf("Czerwony", "Niebieski", "Zielony", "Zołty"), "Niebieski"),
        TrueFalseQuestion("Woda wrze w 100°C?", true)
    )

    var score = 0

    for (question in questions) {
        println(question.askQuestion())
        print("Twoja odpowiedz: ")
        val answer = scanner.nextLine()

        if (question.checkAnswer(answer)) {
            println("Poprawna odpowiedz!\n")
            score++
        } else {
            println("Niepoprawna odpowiedz.\n")
        }
    }

    // Wynik
    println("Twój wynik: $score/${questions.size}")
}