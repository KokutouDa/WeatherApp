package com.kokutouda.weatherapp.domain.commands

import com.kokutouda.weatherapp.domain.model.ForecastList

/**
 * Created by apple on 2017/5/31.
 */

class RequestForecastCommand (val zipCode: Long,
                              val forecastProvider: ForecastProvider = ForecastProvider()) : Command<ForecastList> {

    companion object {
        val DAYS = 7
    }

    override fun execute() = forecastProvider.requestByZipCode(zipCode, DAYS)

}