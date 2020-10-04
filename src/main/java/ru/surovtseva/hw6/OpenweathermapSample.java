package ru.surovtseva.hw6;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OpenweathermapSample {

    public static void main(String[] args) throws IOException {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(10, TimeUnit.SECONDS)
                .followRedirects(true)
                .retryOnConnectionFailure(true)
                .build();

        HttpUrl urlString = new HttpUrl.Builder()
                .scheme("https")
                .host("api.openweathermap.org")
                .addPathSegments("data/2.5/onecall")
                .addQueryParameter("lat","59.894444")
                .addQueryParameter("lon","30.264168")
                .addQueryParameter("exclude","daily")
                .addQueryParameter("units","metric")
                .addQueryParameter("lang","ru")
                .addQueryParameter("appid","2df1a767f1b102b39d7c973e586cf411")
                .build();

        Request request = new Request.Builder()
                .url(urlString)
                .build();

        Response response = client.newCall(request).execute();

        String responseBody = response.body().string();
        System.out.println(responseBody);
    }
}
