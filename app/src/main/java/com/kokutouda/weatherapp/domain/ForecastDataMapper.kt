package com.kokutouda.weatherapp.domain

import com.kokutouda.weatherapp.data.Forecast
import com.kokutouda.weatherapp.domain.model.Forecast as  ModelForecast
import java.text.DateFormat
import java.util.*

/**
 * Created by apple on 2017/5/31.
 */

public class ForecastDataMapper {

    private fun convertForecastItemToDomain(list: List<Forecast>) : List<ModelForecast> {
        return list.map{ convertForecastItemToDomain(it) }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description,
                forecast.temp.max.toInt(), forecast.temp.min.toInt())
    }

    private fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }
}