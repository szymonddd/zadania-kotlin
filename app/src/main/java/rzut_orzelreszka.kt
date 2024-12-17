import kotlin.random.Random

interface RollingTool {
    fun roll(): String
}

class Coin : RollingTool {
    override fun roll(): String {
        return if (Random.nextBoolean()) "Heads" else "Tails"
    }
}
class Dice : RollingTool {
    override fun roll(): String {
        return (1..6).random().toString()
    }
}
fun main() {
    while (true) {
        println("Choose an option:")
        println("1. Flip a coin")
        println("2. Roll a dice")
        println("3. Exit")

        val choice = readLine()
        val tool: RollingTool? = when (choice) {
            "1" -> Coin()
            "2" -> Dice()
            "3" -> {
                println("Thanks for using the simulator! Goodbye!")
                return
            }
            else -> {
                println("Invalid choice, please try again.")
                null
            }
        }

        tool?.let {
            println("Result: ${it.roll()}")
        }

        println()
    }
}
