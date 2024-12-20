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

