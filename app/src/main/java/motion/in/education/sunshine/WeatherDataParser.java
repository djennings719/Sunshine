package motion.in.education.sunshine;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherDataParser {

   /**
    * Given a string of the form returned by the api call:
    * http://api.openweathermap.org/data/2.5/forecast/daily?q=94043&mode=json&units=metric&cnt=7
    * retrieve the maximum temperature for the day indicated by dayIndex
    * (Note: 0-indexed, so 0 would refer to the first day).
    */
   public static double getMaxTemperatureForDay(String weatherJsonStr, int dayIndex)
         throws JSONException {
      // TODO: add parsing code here

      JSONObject jsonWeather = new JSONObject(weatherJsonStr);

      JSONArray jsonDays = jsonWeather.getJSONArray("list");

      JSONObject jsonDay = jsonDays.getJSONObject(dayIndex);
      JSONObject jsonTemperature = jsonDay.getJSONObject("temp");

      return Double.parseDouble(jsonTemperature.get("max").toString());
   }

}