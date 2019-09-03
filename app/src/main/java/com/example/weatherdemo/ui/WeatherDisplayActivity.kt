package com.example.weatherdemo.ui

import WeatherPagePresenter
import WeatherPagePresenterImpl
import android.app.DatePickerDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.weatherdemo.R
import com.example.weatherdemo.model.WeatherInfo
import com.example.weatherdemo.utils.errorDialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_weather_display.*
import java.text.SimpleDateFormat
import java.util.*

class WeatherDisplayActivity : AppCompatActivity(), WeatherPageView {

    private val mCalendar = Calendar.getInstance()
    val mPresenter: WeatherPagePresenter = WeatherPagePresenterImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather_display)

        mPresenter.setView(this)

        linLayDatePicker.setOnClickListener {

            /**
             * Click to open calender
             */
            DatePickerDialog(this, R.style.DatePickerDialogTheme, mDateSetListener, mCalendar.get(Calendar.YEAR),
                mCalendar.get(Calendar.MONTH), mCalendar.get(Calendar.DAY_OF_MONTH)).show()
        }
    }

    /**
     * Date picker
     */
    private val mDateSetListener = DatePickerDialog.OnDateSetListener { view, year, monthOfYear, dayOfMonth ->
        try
        {
            mCalendar.set(Calendar.YEAR, year)
            mCalendar.set(Calendar.MONTH, monthOfYear)
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth)

            val myFormat = "dd-MM-yyyy"
            val sdf = SimpleDateFormat(myFormat, Locale.ENGLISH)

            textViewDateValue.text = sdf.format(mCalendar.time)

            /**
             * Check if day is prime or not;
             * If prime load the weather info else show message
             */
            if (!mPresenter.isPrimeDay(dayOfMonth))
                Snackbar.make(linLayDatePicker, getString(R.string.date_is_not_prime), Snackbar.LENGTH_SHORT).show()
            else
                mPresenter.loadWeatherPage(dayOfMonth, monthOfYear, this)

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Update the UI after successful respons
     */
    private fun updateUI(weatherInfo: WeatherInfo)
    {
        Log.e("ERROR", weatherInfo.toString())
        textViewTempValue.text = "${weatherInfo.main.temp} ℉"
        textViewTempMinValue.text ="${weatherInfo.main.temp_min} ℉"
        textViewTempMaxValue.text = "${weatherInfo.main.temp_max} ℉"
    }

    /**
     * Override methods
     */
    override fun displayLoading() {
        waitProgressBar.visibility = View.VISIBLE
    }

    override fun dismissLoading() {
        waitProgressBar.visibility = View.GONE
    }

    override fun displayHomepage(result: WeatherInfo) {
        dismissLoading()
        updateUI(result)
    }

    override fun displayError(error: String?) {
        Log.e("ERROR", error)
        dismissLoading()
        R.string.error.errorDialog(this)
    }
}
