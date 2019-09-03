package com.example.weatherdemo.ui.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherdemo.ui.WeatherDisplayActivity
import com.example.weatherdemo.utils.start

class SplashScreen : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    WeatherDisplayActivity::class.start(this, true)
  }
}