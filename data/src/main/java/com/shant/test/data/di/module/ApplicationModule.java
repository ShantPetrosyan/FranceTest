package com.shant.test.data.di.module;

import com.shant.test.data.AndroidApplication;
import com.shant.test.data.UIThread;
import com.shant.test.data.executor.JobExecutor;
import com.shant.test.data.repository.WeatherDataRepository;
import com.shant.test.domain.executor.PostExecutionThread;
import com.shant.test.domain.executor.ThreadExecutor;
import com.shant.test.domain.repository.WeatherRepository;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {

    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }

    @Provides
    @Singleton
    WeatherRepository provideRSSRepository(WeatherDataRepository weatherDataRepository) {
        return weatherDataRepository;
    }
}
