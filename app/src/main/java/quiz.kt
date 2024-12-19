interface Question {
    fun askQuestion(): String
    fun checkAnswer(answer: String): Boolean
}