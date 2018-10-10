package com.shant.test.data.repository.datasource;

import com.shant.test.data.entity.currentweather.CurrentWeatherMainEntity;
import com.shant.test.data.entity.forcastweather.ForcastWeatherMainEntity;
import com.shant.test.data.vo.currentweathervo.CurrentWeatherMainVo;
import com.shant.test.data.vo.forcastweathervo.ForcastWeatherMainVo;
import com.shant.test.data.vo.mapper.CurWeatherVoMapper;
import com.shant.test.data.vo.mapper.ForcastVoMapper;
import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;

import android.content.Context;

import io.reactivex.Observable;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import lombok.NonNull;

public class WeatherDbDataStore implements WeatherDataStore {

    private Context context;

    private CurWeatherVoMapper curWeatherVoMapper;
    private ForcastVoMapper forcastVoMapper;
    public RealmConfiguration realmConfiguration;

    public WeatherDbDataStore(CurWeatherVoMapper curWeatherVoMapper,
            ForcastVoMapper forcastVoMapper, @NonNull Context context) {
        this.context = context;
        this.curWeatherVoMapper = curWeatherVoMapper;
        this.forcastVoMapper = forcastVoMapper;

        realmConfiguration = new RealmConfiguration
                .Builder(context)
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    @Override
    public Observable<ForcastWeatherMainEntity> getForcastWeatherInfo(WeatherRequestBo requestBo) {
        return getForcastWeatherFromDB(requestBo);
    }

    @Override
    public Observable<CurrentWeatherMainEntity> getCurrentDayInfo(WeatherRequestBo requestBo) {
        return getCurrentDayInfoFromDB(requestBo);
    }

    /**
     * Getting current day saved data from DB
     *
     * @return current day data of type {@link CurrentWeatherMainEntity}
     */
    public Observable<CurrentWeatherMainEntity> getCurrentDayInfoFromDB(WeatherRequestBo requestBo) {
        CurrentWeatherMainEntity responseEntity = null;

        Realm realm = Realm.getInstance(context);
        //Realm realm = Realm.getInstance(realmConfiguration);
        try {
            CurrentWeatherMainVo storeVos = realm.where(CurrentWeatherMainVo.class).findFirst();
            if (storeVos != null) {
                responseEntity = curWeatherVoMapper.toEntity(storeVos);
            }
        } finally {
            if (realm != null) {
                realm.close();
            }
        }

        return responseEntity != null ? Observable.just(responseEntity) : Observable.empty();
    }

    /**
     * getting last week weather info from DB
     *
     * @return last week weather of type {@link ForcastWeatherMainEntity}
     */
    public Observable<ForcastWeatherMainEntity> getForcastWeatherFromDB(WeatherRequestBo requestBo) {
        ForcastWeatherMainEntity responseEntity = null;

        Realm realm = Realm.getInstance(context);
        //Realm realm = Realm.getInstance(realmConfiguration);
        try {
            ForcastWeatherMainVo storeVos = realm.where(ForcastWeatherMainVo.class).findFirst();
            if (storeVos != null) {
                responseEntity = forcastVoMapper.toEntity(storeVos);
            }
        } finally {
            if (realm != null) {
                realm.close();
            }
        }

        return responseEntity != null ? Observable.just(responseEntity) : Observable.empty();
    }
}
