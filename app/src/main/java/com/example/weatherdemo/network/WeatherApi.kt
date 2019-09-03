
import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.weatherdemo.network.WeatherResponseListener
import org.json.JSONObject

class WeatherApi
{

    /**
     * Returns the
     */
    fun getWeatherInfo(context: Context, weatherResponseListener: WeatherResponseListener)
    {
        //URL
        //https://history.openweathermap.org/data/2.5/aggregated/day?q=Pune&month=8&day=30&appid=b6907d289e10d714a6e88b30761fae22
        val url = "https://samples.openweathermap.org/data/2.5/weather?q=pune&appid=b6907d289e10d714a6e88b30761fae22"

        /**
         * Create request
         */
        val jsonObjectRequest = JsonObjectRequest(Request.Method.GET, url, null,
            Response.Listener { response ->
                weatherResponseListener.onResponse(response)
            },

            /**
             * Error
             */
            Response.ErrorListener { error ->
                weatherResponseListener.onErrorResponse(error)
            }
        )

        /**
         * Put it in volley queue.
         */
        Volley.newRequestQueue(context).add<JSONObject>(jsonObjectRequest)
    }
}