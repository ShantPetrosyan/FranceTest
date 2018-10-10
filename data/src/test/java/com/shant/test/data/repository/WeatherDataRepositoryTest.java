package com.shant.test.data.repository;

import com.shant.test.data.entity.currentweather.CurrentWeatherMainEntity;
import com.shant.test.data.entity.forcastweather.ForcastWeatherMainEntity;
import com.shant.test.data.entity.mapper.CurWeatherEntitiesDataMapper;
import com.shant.test.data.entity.mapper.ForcastEntityDataMapper;
import com.shant.test.data.repository.datasource.WeatherDataStore;
import com.shant.test.data.repository.datasource.WeatherDataStoreFactory;
import com.shant.test.domain.bean.boundary.request.WeatherRequestBo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import io.reactivex.Observable;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class WeatherDataRepositoryTest {

    private WeatherDataRepository weatherDataRepository;

    @Mock
    private WeatherDataStoreFactory mockWeatherDataStoreFactory;
    @Mock
    private CurWeatherEntitiesDataMapper mockCurWeatherEntityDataMapper;
    @Mock
    private ForcastEntityDataMapper mockForcastEntityDataMapper;

    @Mock
    private WeatherDataStore weatherDataStore;
    @Mock
    private WeatherRequestBo requestBo;
    @Mock
    private CurrentWeatherMainEntity mockCurrentWeatherEntity;
    @Mock
    private ForcastWeatherMainEntity mockForcastWeatherEntity;

    @Before
    public void setUp() {
        weatherDataRepository = new WeatherDataRepository(mockWeatherDataStoreFactory,
                mockCurWeatherEntityDataMapper, mockForcastEntityDataMapper);
        given(mockWeatherDataStoreFactory.create(anyBoolean())).willReturn(weatherDataStore);
        given(mockWeatherDataStoreFactory.createCloudDataStore()).willReturn(weatherDataStore);
    }

    @Test
    public void testGetCurrentDayInfoCloudHappyCase() {
        requestBo.setLoadFromDB(false);
        given(weatherDataStore.getCurrentDayInfo(requestBo)).willReturn(Observable.just(mockCurrentWeatherEntity));

        weatherDataRepository.getCurrentDayData(requestBo);

        verify(mockWeatherDataStoreFactory).createCloudDataStore();
        verify(weatherDataStore).getCurrentDayInfo(requestBo);
    }

    @Test
    public void testGetCurrentDayInfoDBHappyCase() {
        requestBo.setLoadFromDB(true);
        given(weatherDataStore.getCurrentDayInfo(requestBo)).willReturn(Observable.just(mockCurrentWeatherEntity));

        weatherDataRepository.getCurrentDayData(requestBo);

        verify(mockWeatherDataStoreFactory).createLocalDataStore();
        verify(weatherDataStore).getCurrentDayInfo(requestBo);
    }

    @Test
    public void testGetForcastWeatherInfoCloudHappyCase() {
        requestBo.setLoadFromDB(false);
        given(weatherDataStore.getForcastWeatherInfo(requestBo)).willReturn(Observable.just(mockForcastWeatherEntity));

        weatherDataRepository.getForcastWeatherData(requestBo);

        verify(mockWeatherDataStoreFactory).createCloudDataStore();
        verify(weatherDataStore).getForcastWeatherInfo(requestBo);
    }

    @Test
    public void testGetForcastWeatherInfoDBHappyCase() {
        requestBo.setLoadFromDB(true);
        given(weatherDataStore.getForcastWeatherInfo(requestBo)).willReturn(Observable.just(mockForcastWeatherEntity));

        weatherDataRepository.getForcastWeatherData(requestBo);

        verify(mockWeatherDataStoreFactory).createLocalDataStore();
        verify(weatherDataStore).getForcastWeatherInfo(requestBo);
    }
}
