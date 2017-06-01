package com.kokutouda.weatherapp.data.db

/**
 * Created by apple on 2017/5/31.
 */

class ForecastDb(val forecastDbHelper: ForecastDhHelper = ForecastDbHelper.instance,
                 val dataMapper: DbDataMapper = DbDataMapper()) : ForecastDataSource {

}
