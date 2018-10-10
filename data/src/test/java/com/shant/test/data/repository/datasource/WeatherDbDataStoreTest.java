package com.shant.test.data.repository.datasource;

import com.shant.test.data.vo.mapper.CurWeatherVoMapper;
import com.shant.test.data.vo.mapper.ForcastVoMapper;
import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.robolectric.RuntimeEnvironment;

import android.content.Context;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WeatherDbDataStoreTest {

    private static final String FAKE_APP_ID = "fake_id";
    private static final String FAKE_CITY = "fake_city";
    private static final String FAKE_COUNTRY_CODE = "fake_country_code";
    private static final String FAKE_TEMPERATURE_TYPE = "fake_temp_Type";

    private WeatherDbDataStore mockedWeatherDbDataStore;

    @Mock
    CurWeatherVoMapper mockedCurWeatherVoMapper;
    @Mock
    ForcastVoMapper mockedForcastVoMapper;

    @Before
    public void setUp() {
        mockedWeatherDbDataStore = new WeatherDbDataStore(mockedCurWeatherVoMapper,
                mockedForcastVoMapper, RuntimeEnvironment.application);
    }

    @Test
    public void testGetCurrentDayInfoFromDb() {
        WeatherRequestBo mcokedRequestBo = new WeatherRequestBo();
        mcokedRequestBo.setAppId(FAKE_APP_ID);
        mcokedRequestBo.setCity(FAKE_CITY);
        mcokedRequestBo.setCountryCode(FAKE_COUNTRY_CODE);
        mcokedRequestBo.setTemperatureType(FAKE_TEMPERATURE_TYPE);

        mockedWeatherDbDataStore.getCurrentDayInfo(mcokedRequestBo);
        verify(mockedWeatherDbDataStore).getCurrentDayInfoFromDB(mcokedRequestBo);
    }

    @Test
    public void testGetForcastWeatherInfoFromDb() {
        WeatherRequestBo mcokedRequestBo = new WeatherRequestBo();
        mcokedRequestBo.setAppId(FAKE_APP_ID);
        mcokedRequestBo.setCity(FAKE_CITY);
        mcokedRequestBo.setCountryCode(FAKE_COUNTRY_CODE);
        mcokedRequestBo.setTemperatureType(FAKE_TEMPERATURE_TYPE);

        mockedWeatherDbDataStore.getForcastWeatherInfo(mcokedRequestBo);
        verify(mockedWeatherDbDataStore).getForcastWeatherFromDB(mcokedRequestBo);
    }
}
