package com.shant.test.mytestapplication.view.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.shant.test.mytestapplication.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(() -> {
            startActivity(new Intent(SplashActivity.this, WeatherMainActivity.class));
            finish();
        }, 2000);
    }
}
