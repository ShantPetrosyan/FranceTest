package com.shant.test.data.repository.datasource;

import com.shant.test.data.vo.mapper.CurWeatherVoMapper;
import com.shant.test.data.vo.mapper.ForcastVoMapper;

import android.content.Context;
import android.support.annotation.NonNull;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Factory that creates different implementations of {@link WeatherDataStore}.
 */
@Singleton
public class WeatherDataStoreFactory {

    private final Context context;
    private final CurWeatherVoMapper curWeatherVoMapper;
    private final ForcastVoMapper forcastVoMapper;

    @Inject
    WeatherDataStoreFactory(@NonNull Context context) {
        this.context = context.getApplicationContext();
        curWeatherVoMapper = new CurWeatherVoMapper();
        forcastVoMapper = new ForcastVoMapper();
    }

    public WeatherDataStore create(boolean isOffline) {
        if (isOffline) {
            return createLocalDataStore();
        }

        return createCloudDataStore();
    }

    /**
     * Create {@link WeatherDataStore} to retrieve data from the Cloud.
     */
    public WeatherDataStore createCloudDataStore() {
        CurWeatherVoMapper curWeatherVoMapper = new CurWeatherVoMapper();
        ForcastVoMapper forcastVoMapper = new ForcastVoMapper();

        return new CloudWeatherDataStore(curWeatherVoMapper, forcastVoMapper, this.context);
    }

    public WeatherDbDataStore createLocalDataStore() {
        return new WeatherDbDataStore(curWeatherVoMapper, forcastVoMapper, this.context);
    }
}
