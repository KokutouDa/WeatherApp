package com.kokutouda.weatherapp

import com.google.gson.Gson
import com.kokutouda.weatherapp.data.ForecastResult
import java.net.URL

/**
 * Created by apple on 2017/5/29.
 */

public class ForecastRequest(val zipCode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPELTE_URL = "&URL&APPID=&APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPELTE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}

