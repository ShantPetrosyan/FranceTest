package com.shant.test.data.repository.datasource;

import com.shant.test.data.ApplicationTestCase;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.RuntimeEnvironment;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class WeatherDataStoreFactoryTest extends ApplicationTestCase {

    private static final boolean FAKE_IS_OFFLINE_FALSE = false;
    private static final boolean FAKE_IS_OFFLINE_TRUE = true;

    private WeatherDataStoreFactory weatherDataStoreFactory;

    @Before
    public void setUp() {
        weatherDataStoreFactory = new WeatherDataStoreFactory(RuntimeEnvironment.application);
    }

    @Test
    public void testCreateLocalDataStore() {
    /*given(mockUserCache.isCached(FAKE_USER_ID)).willReturn(true);
    given(mockUserCache.isExpired()).willReturn(false);

    UserDataStore userDataStore = weatherDataStoreFactory.create(FAKE_USER_ID);

    assertThat(userDataStore, is(notNullValue()));
    assertThat(userDataStore, is(instanceOf(DiskUserDataStore.class)));

    verify(mockUserCache).isCached(FAKE_USER_ID);
    verify(mockUserCache).isExpired();*/
        WeatherDataStore weatherDataStore = weatherDataStoreFactory.create(FAKE_IS_OFFLINE_TRUE);

        assertThat(weatherDataStore, is(notNullValue()));
        assertThat(weatherDataStore, is(instanceOf(WeatherDbDataStore.class)));
    }

    @Test
    public void testCreateCloudDataStore() {
        WeatherDataStore weatherDataStore = weatherDataStoreFactory.create(FAKE_IS_OFFLINE_FALSE);

        assertThat(weatherDataStore, is(notNullValue()));
        assertThat(weatherDataStore, is(instanceOf(CloudWeatherDataStore.class)));
    }
}
