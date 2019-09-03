package com.example.weatherdemo.ui

import com.example.weatherdemo.model.WeatherInfo

interface WeatherPageView {
  fun displayLoading()

  fun dismissLoading()

  fun displayHomepage(result: WeatherInfo)

  fun displayError(error: String?)
}