import android.content.Context
import com.example.weatherdemo.model.WeatherInfo
import com.example.weatherdemo.network.WeatherResponseListener
import com.example.weatherdemo.ui.WeatherPageView
import com.google.gson.Gson
import org.json.JSONObject

class WeatherPagePresenterImpl : WeatherPagePresenter, WeatherResponseListener
{
  var weatherPageView: WeatherPageView? = null
  private val api: WeatherApi = WeatherApi()
  private val weatherPage: WeatherPage = WeatherPage(api)

  override fun setView(weatherPageView: WeatherPageView) {
    this.weatherPageView = weatherPageView
  }

  /**
   * Check prime day or not
   */
  override fun isPrimeDay(day: Int): Boolean {
    for (i in 2..day/2)
    {
      if (day % i == 0) {
        return false
      }
    }

    return true
  }

  override fun loadWeatherPage(day: Int, month: Int, context: Context)
  {
    weatherPageView?.displayLoading()
    weatherPage.get(context, this)
  }

  override fun onResponse(response: JSONObject) {
    /**
     * Convert to response to data object
     */
    val weatherInfo = Gson().fromJson<WeatherInfo>(response.toString(), WeatherInfo::class.java)

    /**
     * Pass response to view
     */
    weatherPageView?.displayHomepage(weatherInfo)
  }

  override fun onErrorResponse(error: Exception) {
    weatherPageView?.displayError(error.message)
  }
}