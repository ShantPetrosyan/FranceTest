package com.shant.test.data.repository;

import com.shant.test.data.entity.mapper.CurWeatherEntitiesDataMapper;
import com.shant.test.data.entity.mapper.ForcastEntityDataMapper;
import com.shant.test.data.repository.datasource.WeatherDataStore;
import com.shant.test.data.repository.datasource.WeatherDataStoreFactory;
import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;
import com.shant.test.domain.bean.boundary.response.currentweather.CurrentWeatherMainResponseBo;
import com.shant.test.domain.bean.boundary.response.forcastweather.ForcastWeatherMainResponseBo;
import com.shant.test.domain.repository.WeatherRepository;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;

/**
 * {@link WeatherRepository} for retrieving Weather data.
 */
@Singleton
public class WeatherDataRepository implements WeatherRepository {

    private final WeatherDataStoreFactory mWeatherDataStoreFactory;
    private CurWeatherEntitiesDataMapper mCurWeatherEntitiesDataMapper;
    private ForcastEntityDataMapper mForcastEntityDataMapper;

    /**
     * Constructs a {@link WeatherDataRepository}.
     *
     * @param weatherDataStoreFactory       A factory to construct different data source implementations.
     * @param mCurWeatherEntitiesDataMapper {@link CurWeatherEntitiesDataMapper}.
     * @param mForcastEntityDataMapper      {@link ForcastEntityDataMapper}.
     */
    @Inject
    public WeatherDataRepository(WeatherDataStoreFactory weatherDataStoreFactory,
            CurWeatherEntitiesDataMapper mCurWeatherEntitiesDataMapper, ForcastEntityDataMapper mForcastEntityDataMapper) {
        this.mWeatherDataStoreFactory = weatherDataStoreFactory;
        this.mCurWeatherEntitiesDataMapper = mCurWeatherEntitiesDataMapper;
        this.mForcastEntityDataMapper = mForcastEntityDataMapper;
    }

    @Override
    public Observable<ForcastWeatherMainResponseBo> getForcastWeatherData(WeatherRequestBo weatherRequestBo) {
        WeatherDataStore weatherDataStore = weatherRequestBo.isLoadFromDB() ? this.mWeatherDataStoreFactory.createLocalDataStore()
                : this.mWeatherDataStoreFactory.createCloudDataStore();
        return weatherDataStore.getForcastWeatherInfo(weatherRequestBo).map(this.mForcastEntityDataMapper::toBo);
    }

    @Override
    public Observable<CurrentWeatherMainResponseBo> getCurrentDayData(WeatherRequestBo weatherRequestBo) {
        WeatherDataStore weatherDataStore = weatherRequestBo.isLoadFromDB() ? this.mWeatherDataStoreFactory.createLocalDataStore()
                : this.mWeatherDataStoreFactory.createCloudDataStore();
        return weatherDataStore.getCurrentDayInfo(weatherRequestBo).map(this.mCurWeatherEntitiesDataMapper::toBo);
    }
}
