package com.shant.test.data;

import android.app.Application;

import com.shant.test.data.di.component.ApplicationComponent;
import com.shant.test.data.di.module.ApplicationModule;
import com.shant.test.data.di.component.DaggerApplicationComponent;

/**
 * Android AndroidApplication Application
 */
public class AndroidApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        this.initializeLeakDetection();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }

    private void initializeLeakDetection() {
        if (BuildConfig.DEBUG) {
        }
    }
}
