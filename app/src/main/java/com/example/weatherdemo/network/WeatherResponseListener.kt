package com.example.weatherdemo.network

import org.json.JSONObject

interface WeatherResponseListener
{
    /**
     * Called when a response is received.*
     */
    fun onResponse(response: JSONObject)

    /**
     * Callback method that an error has been occurred with the provided error code and optional
     * user-readable message.
     */
    fun onErrorResponse(error: Exception)
}