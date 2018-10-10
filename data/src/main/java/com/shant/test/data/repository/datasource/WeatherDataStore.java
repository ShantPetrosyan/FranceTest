package com.shant.test.data.repository.datasource;

import com.shant.test.data.entity.currentweather.CurrentWeatherMainEntity;
import com.shant.test.data.entity.forcastweather.ForcastWeatherMainEntity;
import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;

import io.reactivex.Observable;

public interface WeatherDataStore {

    /**
     * Get an {@link Observable} which will emit a ForCastList of {@link ForcastWeatherMainEntity}.
     */
    Observable<ForcastWeatherMainEntity> getForcastWeatherInfo(WeatherRequestBo requestBo);

    /**
     * Get an {@link Observable} which will emit object of {@link CurrentWeatherMainEntity}.
     */
    Observable<CurrentWeatherMainEntity> getCurrentDayInfo(WeatherRequestBo requestBo);
}
