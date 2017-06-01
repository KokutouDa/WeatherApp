package com.kokutouda.weatherapp

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.support.annotation.IdRes
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.Toast
import com.kokutouda.weatherapp.data.Forecast
import com.kokutouda.weatherapp.domain.commands.RequestForecastCommand
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.async
import java.util.*
import javax.xml.datatype.Duration

//需要 kotlin-android-extensions
class MainActivity : AppCompatActivity() {

    //创建list
    private val items = listOf("Mon 6/23 - Sunny - 31/17",
            "Tue 6/24 - Foggy - 21/8",
            "Wed 6/25 - Cloudy - 22/17",
            "Thurs 6/26 - Rainy - 18/11",
            "Fri 6/27 - Foggy - 21/10",
            "Sat 6/28 - TRAPPED IN WEATHERSTATION - 23/18",
            "Sun 6/29 - Sunny - 20/7")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val forecastList: RecyclerView = find(R.id.forecast_list)
        //layoutManager 就是 setLayoutManager
        //LinearLayoutManager(this) 就是 new LinearLayoutManager(this)
        forecastList.layoutManager = LinearLayoutManager(this)
        forecastList.adapter = ForecastListAdapter(items)

        doAsync {
            val result = RequestForecastCommand(94043).execute()
            uiThread { forecastList.adapter = ForecastListAdapter(result) }
        }


    }

    //Toast 不是 Context 的方法，但是可以定义一个方法，第一个 context 参数直接传入 this。
    // 它可以被任务 Context 或它的子类调用
    // 使用扩展函数代替 Java 中的工具类。
//    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_SHORT) {
//        Toast.makeText(this, message, duration).show()
//    }

}
