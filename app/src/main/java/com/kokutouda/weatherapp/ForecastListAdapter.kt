package com.kokutouda.weatherapp

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.kokutouda.weatherapp.domain.model.ForecastList

/**
 * Created by apple on 2017/5/25.
 */

//传入周天气预报
class ForecastListAdapter(val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TextView(parent.context))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //with 可以扩展一个对象的功能
        with(weekForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }

        var myList = listOf("1", "2", "3", "4")

        var x = myList[2]

        //todo 需要重载下构造方法？


    }

    operator fun set(a: String, b: String): String = b

    //每日天气的大小
    override fun getItemCount(): Int  = weekForecast.size()

    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView) {

    }
}



