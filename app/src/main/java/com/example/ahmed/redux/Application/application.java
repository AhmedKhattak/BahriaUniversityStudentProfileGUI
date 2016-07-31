package com.example.ahmed.redux.Application;

import android.app.Application;

import com.squareup.leakcanary.LeakCanary;

/**
 * Created by Khattak on 7/28/2016.
 */
public class application extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LeakCanary.install(this);
    }
}
