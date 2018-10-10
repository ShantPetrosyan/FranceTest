package com.shant.test.mytestapplication.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.shant.test.mytestapplication.R;

import javax.inject.Inject;

public class NetworkHelper {

    private Context context;

    @Inject
    public NetworkHelper(Context context) {
        this.context = context;
    }

    /**
     *  Checking is network available and connected or not
     * @return boolean value
     */
    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    /**
     *  Showing error message in case when there is no internet connection via {@link Snackbar}
     * @param view root view to show on it {@link Snackbar}
     * @param activity current activity
     */
    public static void showNoInternetSnakeBar(View view, final Activity activity) {
        Snackbar.make(view, activity.getResources().getString(R.string.no_connection), Snackbar.LENGTH_LONG)
                .setAction(activity.getResources().getString(R.string.settings),
                        view1 -> activity.startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS))).show();
    }
}
