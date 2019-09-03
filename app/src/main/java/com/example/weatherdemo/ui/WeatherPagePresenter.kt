
import android.content.Context
import com.example.weatherdemo.ui.WeatherPageView

interface WeatherPagePresenter
{
  fun setView(weatherPageView: WeatherPageView)
  fun loadWeatherPage(day: Int, month: Int, context: Context)
  fun isPrimeDay(day: Int): Boolean
}