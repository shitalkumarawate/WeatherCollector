import android.content.Context
import com.example.weatherdemo.network.WeatherResponseListener

class WeatherPage(private val api: WeatherApi) {
  fun get(context: Context, weatherResponseListener: WeatherResponseListener) = api.getWeatherInfo(context, weatherResponseListener)
}