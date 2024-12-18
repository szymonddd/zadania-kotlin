interface Weather {
    fun getForecast(): String
}


class Sunny : Weather {
    override fun getForecast(): String {
        return "Dzisiaj be2dzie slonecznie! Idealny dzien na spacer."
    }
}

class Rainy : Weather {
    override fun getForecast(): String {
        return "Dzisiaj pada deszcz. Zabierz parasol!"
    }
}

class Cloudy : Weather {
    override fun getForecast(): String {
        return "Dzisiaj bedzie pochmurno. Moze padac deszcz."
    }
}
data class City(val name: String, val weather: Weather)


class WeatherApp {
    val cities = listOf(
        City("Warszawa", Sunny()),
        City("Krakow", Rainy()),
        City("Gdansk", Cloudy()),
        City("Poznan", Sunny()),
        City("Wroclaw", Cloudy())
    )


    fun displayCities() {
        println("Wybierz miasto:")
        cities.forEachIndexed { index, city ->
            println("${index + 1}. ${city.name}")
        }
    }


    fun showWeather(cityIndex: Int) {
        if (cityIndex in 1..cities.size) {
            val city = cities[cityIndex - 1]
            println("Prognoza pogody dla miasta ${city.name}: ${city.weather.getForecast()}")
        } else {
            println("Nieprawidlowy wybor miasta.")
        }
    }
}
fun main() {
    val app = WeatherApp()


    app.displayCities()


    println("\nWybierz numer miasta (1-${app.cities.size}):")
    val userChoice = readLine()?.toIntOrNull() ?: 0


    app.showWeather(userChoice)
}