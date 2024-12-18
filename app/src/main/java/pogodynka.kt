interface Weather {
    fun getForecast(): String
}


class Sunny : Weather {
    override fun getForecast(): String {
        return "Dzisiaj będzie słonecznie! Idealny dzień na spacer."
    }
}

class Rainy : Weather {
    override fun getForecast(): String {
        return "Dzisiaj pada deszcz. Zabierz parasol!"
    }
}

class Cloudy : Weather {
    override fun getForecast(): String {
        return "Dzisiaj będzie pochmurno. Może padać deszcz."
    }
}
data class City(val name: String, val weather: Weather)

// Klasa główna aplikacji
class WeatherApp {
    private val cities = listOf(
        City("Warszawa", Sunny()),
        City("Kraków", Rainy()),
        City("Gdańsk", Cloudy()),
        City("Poznań", Sunny()),
        City("Wrocław", Cloudy())
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
            println("Nieprawidłowy wybór miasta.")
        }
    }
}