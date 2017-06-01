package com.kokutouda.weatherapp.domain.commands

/**
 * Created by apple on 2017/5/30.
 */

//实现这个类，执行操作并返回某种类型的对象。
// 默认一切函数都会返回一个值，如果不想，需要指定为 Unit
public interface Command<T> {
    fun execute(): T
}