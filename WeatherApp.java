import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class WeatherApp {

    public static void main(String[] args) {

        String url =
            "https://api.open-meteo.com/v1/forecast?latitude=20.2961&longitude=85.8245&current_weather=true";

        try {

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response = client.send(
                    request,
                    HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser
                    .parseString(response.body())
                    .getAsJsonObject();

            JsonObject currentWeather =
                    jsonObject.getAsJsonObject("current_weather");

            double temperature =
                    currentWeather.get("temperature").getAsDouble();

            double windspeed =
                    currentWeather.get("windspeed").getAsDouble();

            System.out.println("===== WEATHER REPORT =====");
            System.out.println("Location: Bhubaneswar");
            System.out.println("Temperature: " + temperature + " °C");
            System.out.println("Wind Speed: " + windspeed + " km/h");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}