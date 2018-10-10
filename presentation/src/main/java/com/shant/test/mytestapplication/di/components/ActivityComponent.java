package com.shant.test.mytestapplication.di.components;

import android.app.Activity;

import com.shant.test.data.di.component.ApplicationComponent;
import com.shant.test.mytestapplication.di.modules.ActivityModule;
import com.shant.test.mytestapplication.di.qualifiers.PerActivity;
import com.shant.test.mytestapplication.view.activity.BaseActivity;

import dagger.Component;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 * <p>
 * Subtypes of ActivityComponent should be decorated with annotation:
 * {@link PerActivity}
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(BaseActivity baseActivity);

    //Exposed to sub-graphs.
    Activity activity();
}
