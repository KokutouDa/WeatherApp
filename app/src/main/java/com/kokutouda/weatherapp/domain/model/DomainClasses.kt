package com.kokutouda.weatherapp.domain.model


/**
 * Created by apple on 2017/5/30.
 */

data class ForecastList(var city: String, var country: String, var dailyForecast: List<Forecast>) {

    //重载数组的 get 操作符
    operator fun get(position: Int): Forecast = dailyForecast[position]

    fun size(): Int = dailyForecast.size
}

data class Forecast(var date: String, var description: String, var high: Int, var low: Int)