package com.shant.test.mytestapplication.view.activity;

import com.shant.test.data.AndroidApplication;
import com.shant.test.data.di.component.ApplicationComponent;
import com.shant.test.mytestapplication.di.components.ActivityComponent;
import com.shant.test.mytestapplication.di.components.DaggerActivityComponent;
import com.shant.test.mytestapplication.di.modules.ActivityModule;
import com.shant.test.mytestapplication.navigation.Navigator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

/**
 * Base {@link AppCompatActivity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Inject
    Navigator navigator;
    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeInjector();
        activityComponent.inject(this);
    }

    private void initializeInjector() {
        this.activityComponent = DaggerActivityComponent.builder().applicationComponent(getApplicationComponent()).activityModule(
                getActivityModule()).build();
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment        The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment, String tag) {
        final FragmentTransaction fragmentTransaction =
                this.getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment).addToBackStack(tag);
        fragmentTransaction.commit();
    }

    /**
     * Get the ForcastMainEntity Application component for dependency injection.
     *
     * @return {@link ApplicationComponent}
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication) getApplication()).getApplicationComponent();
    }

    /**
     * Get an Activity module for dependency injection.
     *
     * @return {@link ActivityModule}
     */
    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
