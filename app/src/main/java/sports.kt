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
fun main() {
    val analyzer = SportsResultsAnalyzer()

    while (true) {
        println("\nCo chcesz zrobic?")
        println("1. Dodac wynik meczu")
        println("2. Wyswietlic wszystkie wyniki")
        println("3. Filtrowac wyniki powyzej okreslonego progu")
        println("4. Dodac bonusowe punkty do wszystkich wynikow")
        println("5. Obliczyc sume wynikow")
        println("6. Obliczyc maksymalny wynik")
        println("7. Obliczyc roznice miedzy maksymalnym a minimalnym wynikiem")
        println("8. Zliczyc mecze powyzej okreslonego progu")
        println("9. Zakonczyc")
        print("Wybierz opcje (1-9): ")

        when (readLine()?.toIntOrNull()) {
            1 -> {
                print("Podaj wynik meczu: ")
                val score = readLine()?.toIntOrNull()
                if (score != null) {
                    analyzer.addMatchResult(score)
                    println("Wynik $score dodany!")
                } else {
                    println("Niepoprawny wynik. Sprobuj ponownie.")
                }
            }
            2 -> {
                analyzer.printResults()
            }
            3 -> {
                print("Podaj prog: ")
                val threshold = readLine()?.toIntOrNull()
                if (threshold != null) {
                    val filteredResults = analyzer.filterResultsAboveThreshold(threshold)
                    println("\nWyniki powyzej $threshold punktow:")
                    filteredResults.forEach { println("Wynik: ${it.score}") }
                } else {
                    println("Niepoprawna wartosc progu. Sprobuj ponownie.")
                }
            }
            4 -> {
                print("Podaj liczbe bonusowych punktow: ")
                val bonus = readLine()?.toIntOrNull()
                if (bonus != null) {
                    analyzer.addBonusPoints(bonus)
                    println("Dodano $bonus bonusowych punktow do kazdego wyniku!")
                } else {
                    println("Niepoprawna liczba bonusowych punktow. Sprobuj ponownie.")
                }
            }
            5 -> {
                println("Suma wynikow: ${analyzer.sumResults()}")
            }
            6 -> {
                println("Maksymalny wynik: ${analyzer.maxResult()}")
            }
            7 -> {
                val diff = analyzer.scoreDifference()
                if (diff != null) {
                    println("Roznica miedzy maksymalnym a minimalnym wynikiem: $diff")
                } else {
                    println("Brak wystarczajacych danych do obliczenia roznicy.")
                }
            }
            8 -> {
                print("Podaj prog: ")
                val threshold = readLine()?.toIntOrNull()
                if (threshold != null) {
                    println("Liczba meczow powyzej $threshold punktow: ${analyzer.countMatchesAboveThreshold(threshold)}")
                } else {
                    println("Niepoprawna wartosc progu. Sprobuj ponownie.")
                }
            }
            9 -> {
                println("Koniec programu.")
                break
            }
            else -> {
                println("Niepoprawny wybor. Wybierz opcje od 1 do 9.")
            }
        }
    }
}