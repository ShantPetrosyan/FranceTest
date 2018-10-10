package com.shant.test.data.repository.datasource;

import com.shant.test.data.entity.currentweather.CurrentWeatherMainEntity;
import com.shant.test.data.entity.forcastweather.ForcastWeatherMainEntity;
import com.shant.test.data.net.BuildTypeApiConstants;
import com.shant.test.data.net.WeatherApi;
import com.shant.test.data.vo.currentweathervo.CurrentWeatherMainVo;
import com.shant.test.data.vo.currentweathervo.WeatherVo;
import com.shant.test.data.vo.forcastweathervo.ForCastByHoursVo;
import com.shant.test.data.vo.forcastweathervo.ForcastWeatherMainVo;
import com.shant.test.data.vo.mapper.CurWeatherVoMapper;
import com.shant.test.data.vo.mapper.ForcastVoMapper;
import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;

import android.content.Context;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import io.reactivex.functions.Consumer;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.exceptions.RealmMigrationNeededException;
import retrofit2.Retrofit;

/**
 * {@link CloudWeatherDataStore} implementation based on connections to the api (Cloud).
 */
class CloudWeatherDataStore extends CommonCloudDataStore implements WeatherDataStore {

    private final WeatherApi restApi;
    public RealmConfiguration realmConfiguration;

    private CurWeatherVoMapper curWeatherVoMapper;
    private ForcastVoMapper forcastVoMapper;

    public CloudWeatherDataStore(CurWeatherVoMapper curWeatherVoMapper,
            ForcastVoMapper forcastVoMapper, Context context) {
        super(context);
        this.curWeatherVoMapper = curWeatherVoMapper;
        this.forcastVoMapper = forcastVoMapper;

        Retrofit retrofit = buildRetrofit();
        restApi = retrofit.create(WeatherApi.class);

        /*realmConfiguration = new RealmConfiguration
                .Builder(context)
                .deleteRealmIfMigrationNeeded()
                .name("myRealmFile")
                .build();*/
    }

    private Consumer<? super ForcastWeatherMainEntity> saveForcastToDb = weatherMainEntity -> {
        if (weatherMainEntity != null && weatherMainEntity.getCod().equals("200")) {
            ForcastWeatherMainVo forcastWeatherMainVo = forcastVoMapper.toVo(weatherMainEntity);
            for (ForCastByHoursVo item : forcastWeatherMainVo.getForCastByHoursVos()) {
                System.out.println(item.getForcastSysVo().getPod());
            }
            // Save data in db
            Realm realm = Realm.getInstance(context);
            //Realm realm = createRealm();
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(forcastWeatherMainVo);
            realm.commitTransaction();
            realm.close();
        }
    };

    private Consumer<? super CurrentWeatherMainEntity> saveCurrentToDb = currentWeatherMainEntity -> {
        if (currentWeatherMainEntity != null && currentWeatherMainEntity.getCod() == 200) {
            CurrentWeatherMainVo weatherMainVo = curWeatherVoMapper.toVo(currentWeatherMainEntity);

            // Save data in db
            Realm realm = Realm.getInstance(context);
            //Realm realm = createRealm();
            realm.beginTransaction();
            realm.copyToRealmOrUpdate(weatherMainVo);
            realm.commitTransaction();
            realm.close();
        }
    };

    public Realm createRealm() {
        Realm realm = null;

        try {
            realm = Realm.getInstance(realmConfiguration);
        } catch (RealmMigrationNeededException e) {
            try {
                Realm.deleteRealm(realmConfiguration);
                //Realm file has been deleted.
                realm = Realm.getInstance(realmConfiguration);
            } catch (Exception ex) {
                throw ex;
                //No Realm file to remove.
            }
        }
        return realm;
    }

    @Override
    protected Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put(BuildTypeApiConstants.CONTENT_TYPE_LABEL, BuildTypeApiConstants.CONTENT_TYPE_VALUE_JSON);
        return headers;
    }

    @Override
    public Observable<ForcastWeatherMainEntity> getForcastWeatherInfo(WeatherRequestBo requestBo) {
        return this.restApi.getForcastData(requestBo.getCity() + "," + requestBo.getCountryCode(),
                requestBo.getTemperatureType(),
                requestBo.getAppId()).doOnNext(saveForcastToDb);
    }

    @Override
    public Observable<CurrentWeatherMainEntity> getCurrentDayInfo(WeatherRequestBo requestBo) {
        return this.restApi
                .getCurrentDayData(requestBo.getCity() + "," + requestBo.getCountryCode(),
                        requestBo.getTemperatureType(),
                        requestBo.getAppId()).doOnNext(saveCurrentToDb);
    }
}