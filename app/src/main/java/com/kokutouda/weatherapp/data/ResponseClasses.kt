package com.kokutouda.weatherapp.data

/**
 * Created by apple on 2017/5/30.
 */

//所有 json 需要解析的数据的类

data class  ForecastResult(val city: City, val list: List<Forecast>)

data class City(val id: Long, val name: String, val coord: Coordinates,
                val contry: String, val population: String)

data class Coordinates(val lon: Float, val lat: Float)

data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float, val humidity: Int,
                    val weather: List<Weather>, val speed: Float, val deg: Int,
                    val clouds: Int, val rain: Float)

data class Temperature(val day: Int, val min: Float, val max: Float,
                       val morning: Float, val eve: Float, val night: Float)

data class Weather(val id: Long, val main: String, val description: String, val icon: String)

