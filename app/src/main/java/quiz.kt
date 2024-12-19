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
        return "$question (Prawda/Fałsz)"
    }

    override fun checkAnswer(answer: String): Boolean {
        return (answer.equals("prawda", ignoreCase = true) && correctAnswer) ||
                (answer.equals("fałsz", ignoreCase = true) && !correctAnswer)
    }
}
