package com.example.weatherdemo

import WeatherPagePresenter
import WeatherPagePresenterImpl
import com.example.weatherdemo.ui.WeatherPageView
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.junit.MockitoJUnit

/**
 *
 */
class WeatherPresenterTest
{
    @JvmField @Rule var mockitoRule = MockitoJUnit.rule()
    private lateinit var mPresenter: WeatherPagePresenter
    private lateinit var view : WeatherPageView

    @Before
    fun setup() {
        mPresenter = WeatherPagePresenterImpl()
        view = mock()
        mPresenter.setView(view)
    }

    @Test
    fun search_withNonPrimeDay_CallDisplayError() {
        mPresenter.isPrimeDay(10)
        verify(view).displayError("Non Prime number")
    }

}
