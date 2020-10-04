package ru.surovtseva.hw6;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AccuweatherSample {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

        HttpUrl weatherUrlString = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addPathSegments("forecasts/v1/daily/5day")
                .addPathSegments("295212")
                .addQueryParameter("apikey","OqDAGGpcmGMA759gTpKJDQfjCaruGv2y")
                .addQueryParameter("language","ru")
                .addQueryParameter("details","false")
                .addQueryParameter("metric","true")
                .build();

        //Отдельный запрос для получения названия местности по коду локаци,
        //убедимся, что код "295212" - соотвествует Санкт-Петербургу
        HttpUrl locationUrlString = new HttpUrl.Builder()
                .scheme("https")
                .host("dataservice.accuweather.com")
                .addPathSegments("locations/v1")
                .addPathSegments("295212")
                .addQueryParameter("apikey","OqDAGGpcmGMA759gTpKJDQfjCaruGv2y")
                .addQueryParameter("language","ru")
                .addQueryParameter("details","false")
                .build();

        Request requestLocation = new Request.Builder()
                .url(locationUrlString)
                .build();

        Response responseLocation = client.newCall(requestLocation).execute();

        ObjectMapper mapper = new ObjectMapper();
        Map<String,String> map = mapper.readValue(responseLocation.body().string(),Map.class);

        Request requestWeather = new Request.Builder()
                .url(weatherUrlString)
                .build();

        Response responseWeather = client.newCall(requestWeather).execute();

        System.out.println(map.get("LocalizedName"));
        System.out.println(responseWeather.body().string());
    }
}
