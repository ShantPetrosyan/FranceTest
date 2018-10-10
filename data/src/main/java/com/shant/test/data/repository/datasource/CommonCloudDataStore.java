package com.shant.test.data.repository.datasource;

import com.shant.test.data.net.BuildTypeApiConstants;

import android.content.Context;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class CommonCloudDataStore {

    private static final String TAG = "CloudDataStore";

    protected Context context;

    public CommonCloudDataStore(Context context) {
        this.context = context;
    }

    protected Retrofit buildRetrofit() {
        OkHttpClient httpClient;

        // Loggin
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        // add interceptors

        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //if (LogConstants.RETROFIT_LOG) {
        //builder.addInterceptor(logging);
        //}
        builder.networkInterceptors().add(chain -> {
            Request.Builder builder1 = chain.request().newBuilder();
            Map<String, String> headers = getHeaders();
            if (headers != null) {
                Set<String> keys = headers.keySet();
                for (String key : keys) {
                    String value = headers.get(key);
                    if (value != null) {
                        builder1.addHeader(key, value);
                    }
                }
            }

            Request request = builder1.build();
            return chain.proceed(request);
        });
        httpClient = builder.followRedirects(false)
                .followSslRedirects(false)
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();

        return new Retrofit.Builder()
                .baseUrl(BuildTypeApiConstants.ENDPOINT)
                .client(httpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    protected abstract Map<String, String> getHeaders();
}
