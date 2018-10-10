package com.shant.test.mytestapplication.navigation;

import com.shant.test.mytestapplication.di.qualifiers.PerActivity;

import android.content.Context;

import javax.inject.Inject;

/**
 * Class used to navigate through the application.
 */
@PerActivity
public class Navigator {

    private Context context;

    @Inject
    public Navigator(Context context) {
        this.context = context;
    }
}
