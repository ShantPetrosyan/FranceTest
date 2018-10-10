
package com.shant.test.data.repository.datasource;

import android.content.Context;

import com.shant.test.data.net.WeatherApi;
import com.shant.test.data.vo.mapper.CurWeatherVoMapper;
import com.shant.test.data.vo.mapper.ForcastVoMapper;
import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.robolectric.RuntimeEnvironment;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CloudWeatherDataStoreTest {

    private static final int FAKE_USER_ID = 765;
    private static final String FAKE_APP_ID = "fake_id";
    private static final String FAKE_CITY = "fake_city";
    private static final String FAKE_COUNTRY_CODE = "fake_country_code";
    private static final String FAKE_TEMPERATURE_TYPE = "fake_temp_Type";

    private CloudWeatherDataStore cloudWeatherDataStore;

    @Mock
    private WeatherApi mockRestApi;

    @Mock
    CurWeatherVoMapper mockedCurWeatherVoMapper;
    @Mock
    ForcastVoMapper mockedForcastVoMapper;

    @Before
    public void setUp() {
        cloudWeatherDataStore = new CloudWeatherDataStore(mockedCurWeatherVoMapper,
                mockedForcastVoMapper, RuntimeEnvironment.application);
    }

    @Test
    public void testGetCurrentDayInfoFromApi() {
        WeatherRequestBo mcokedRequestBo = new WeatherRequestBo();
        mcokedRequestBo.setAppId(FAKE_APP_ID);
        mcokedRequestBo.setCity(FAKE_CITY);
        mcokedRequestBo.setCountryCode(FAKE_COUNTRY_CODE);
        mcokedRequestBo.setTemperatureType(FAKE_TEMPERATURE_TYPE);

        cloudWeatherDataStore.getCurrentDayInfo(mcokedRequestBo);
        verify(mockRestApi).getCurrentDayData(FAKE_CITY + "," + FAKE_COUNTRY_CODE,
                FAKE_TEMPERATURE_TYPE, FAKE_APP_ID);
    }

    @Test
    public void testGetForcastWeatherInfoFromApi() {
        WeatherRequestBo mcokedRequestBo = new WeatherRequestBo();
        mcokedRequestBo.setAppId(FAKE_APP_ID);
        mcokedRequestBo.setCity(FAKE_CITY);
        mcokedRequestBo.setCountryCode(FAKE_COUNTRY_CODE);
        mcokedRequestBo.setTemperatureType(FAKE_TEMPERATURE_TYPE);

        cloudWeatherDataStore.getForcastWeatherInfo(mcokedRequestBo);
        verify(mockRestApi).getForcastData(FAKE_CITY + "," + FAKE_COUNTRY_CODE,
                FAKE_TEMPERATURE_TYPE, FAKE_APP_ID);
    }
}
