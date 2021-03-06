package com.example.pripachkin.kotlinproject.domain

import com.example.pripachkin.kotlinproject.data.Forecast
import com.example.pripachkin.kotlinproject.domain.Forecast as ModelForecast
import com.example.pripachkin.kotlinproject.data.ForecastResult
import java.text.DateFormat
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Created by Pripachkin on 06.11.2017.
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast: ForecastResult): ForecastList =
            ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list: List<Forecast>): List<ModelForecast> {
        return list.mapIndexed { i, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(i.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(icon: String): String = "http://openweathermap.org/img/w/$icon.png"

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }
}