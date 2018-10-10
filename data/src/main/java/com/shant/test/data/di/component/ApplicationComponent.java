package com.shant.test.data.di.component;

import com.shant.test.data.di.module.ApplicationModule;
import com.shant.test.domain.executor.PostExecutionThread;
import com.shant.test.domain.executor.ThreadExecutor;
import com.shant.test.domain.repository.WeatherRepository;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;

/**
 * A component whose lifetime is the life of the application.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    //Exposed to sub-graphs.
    Context context();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    WeatherRepository rssRepository();
}
