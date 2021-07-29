package com.example.ohridcityguide;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.ohridcityguide.api.WeatherResponse;
import com.example.ohridcityguide.api.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherFragment extends Fragment {
    public static String BaseUrl = "http://api.openweathermap.org/";
    public static String AppId = "86ec51e68b7ea656503c2fc963a15620";
    public static String lat = "41.116872";
    public static String lon = "20.801827";
    public static String city = "Ohrid";
    public static String units = "metric";
    private TextView weatherData;
    private ImageView ivWeather;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        weatherData = view.findViewById(R.id.tvWeather);
        ivWeather = view.findViewById(R.id.ivWeather);

//        Typeface typeface = Typeface.createFromAsset(getAssets(), "Lato-Bold.ttf");
//        FontUtils fontUtils = new FontUtils();
//        fontUtils.applyFontToView(weatherData, typeface);
//
//        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                getCurrentData();
//            }
//        });

        getCurrentData();

    }

    private void getCurrentData() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        WeatherService service = retrofit.create(WeatherService.class);
        Call<WeatherResponse> call = service.getCurrentWeatherData(/*lat, lon,*/ city, units, AppId);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(@NonNull Call<WeatherResponse> call, @NonNull Response<WeatherResponse> response) {
                if (response.code() == 200) {
                    WeatherResponse weatherResponse = response.body();
                    assert weatherResponse != null;

                    String stringBuilder =
                            "Current temperature in Ohrid: " +
                            (int) weatherResponse.main.temp + "°" +
                            "\n" +
                            "Humidity: " +
                            (int) weatherResponse.main.humidity + "%" +
                            "\n" +
                            "Cloud cover: " +
                            (int) weatherResponse.clouds.all + "%" +
                            "\n" +
                            "Wind speed: " +
                            (int) weatherResponse.wind.speed + " m/s";
                    weatherData.setText(stringBuilder);

                    String icon = weatherResponse.weather.get(0).icon;
                    String iconUrl = "https://openweathermap.org/img/w/" + icon + ".png";
                    Glide.with(getContext()).load(iconUrl).into(ivWeather);
                }
                else {
                    weatherData.setText(R.string.weather_not_available);
                }
            }

            @Override
            public void onFailure(@NonNull Call<WeatherResponse> call, @NonNull Throwable t) {
                weatherData.setText(t.getMessage());
            }
        });
    }
}