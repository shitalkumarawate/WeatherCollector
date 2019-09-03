package com.example.weatherdemo.model

/**
 *
 */
data class Main(
    var temp: Double,
    var pressure: Int,
    var humidity: Int,
    var temp_min: Double,
    var temp_max: Double)
{
    override fun toString(): String {
        return "Main(temp=$temp, pressure=$pressure, humidity=$humidity, tempMin=$temp_min, tempMax=$temp_max)"
    }
}
