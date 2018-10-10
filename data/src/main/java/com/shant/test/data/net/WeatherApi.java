package com.shant.test.data.net;

import com.shant.test.data.entity.currentweather.CurrentWeatherMainEntity;
import com.shant.test.data.entity.forcastweather.ForcastWeatherMainEntity;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {

    /**
     * Get an {@link Observable} which will emit object of {@link ForcastWeatherMainEntity}.
     */
    @GET("data/2.5/forecast?")
    Observable<ForcastWeatherMainEntity> getForcastData(@Query("q") String cityNameAndCode, @Query("units") String units,
            @Query("appid") String appId);

    /**
     * Get an {@link Observable} which will emit object of {@link CurrentWeatherMainEntity}.
     */
    @GET("data/2.5/weather?")
    Observable<CurrentWeatherMainEntity> getCurrentDayData(@Query("q") String cityNameAndCode, @Query("units") String units,
            @Query("appid") String appId);
}
