data class MatchResult(var score: Int)

class SportsResultsAnalyzer {
    private val results = mutableListOf<MatchResult>()

    fun addMatchResult(score: Int) {
        results.add(MatchResult(score))
    }

    fun filterResultsAboveThreshold(threshold: Int): List<MatchResult> {
        return results.filter { it.score > threshold }
    }

    fun addBonusPoints(bonus: Int) {
        results.replaceAll { it.copy(score = it.score + bonus) }
    }
    fun sumResults(): Int {
        return results.sumOf { it.score }
    }

    fun maxResult(): Int? {
        return results.maxOfOrNull { it.score }
    }

    fun scoreDifference(): Int? {
        val max = maxResult()
        val min = results.minOfOrNull { it.score }
        return if (max != null && min != null) max - min else null
    }

    fun countMatchesAboveThreshold(threshold: Int): Int {
        return results.count { it.score > threshold }
    }

    fun printResults() {
        if (results.isEmpty()) {
            println("Brak zapisanych wynikow.")
        } else {
            println("Wyniki meczow:")
            results.forEach { println("Wynik: ${it.score}") }
        }
    }
}
