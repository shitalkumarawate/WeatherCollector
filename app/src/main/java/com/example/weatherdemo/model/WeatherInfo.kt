package com.example.weatherdemo.model

/**
 *
 */
data class WeatherInfo(
    var base: String,
    var main: Main,
    var visibility: Int,
    var dt: Int,
    var id: Int)
{
    override fun toString(): String {
        return "WeatherInfo(base='$base', main=$main., visibility=$visibility, dt=$dt, id=$id)"
    }
}

