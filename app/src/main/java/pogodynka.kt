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