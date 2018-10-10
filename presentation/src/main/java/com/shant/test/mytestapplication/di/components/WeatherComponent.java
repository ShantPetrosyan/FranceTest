package com.shant.test.mytestapplication.di.components;

import com.shant.test.data.di.component.ApplicationComponent;
import com.shant.test.mytestapplication.di.qualifiers.PerActivity;
import com.shant.test.mytestapplication.di.modules.ActivityModule;
import com.shant.test.mytestapplication.di.modules.WeatherModule;
import com.shant.test.mytestapplication.utils.NetworkHelper;
import com.shant.test.mytestapplication.view.activity.WeatherMainActivity;
import com.shant.test.mytestapplication.view.fragment.WeatherListFragment;

import dagger.Component;

/**
 * A scope {@link PerActivity} component.
 * Injects RSS specific Fragments.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = {ActivityModule.class, WeatherModule.class})
public interface WeatherComponent extends ActivityComponent {

    void inject (WeatherMainActivity weatherMainActivity);

    void inject(WeatherListFragment weatherListFragment);

    void inject(NetworkHelper networkHelper);
}
