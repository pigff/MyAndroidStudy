package com.example.lin.myandroidapplication;

import android.app.Application;

/**
 * Created by lin on 2017/2/18.
 */
public class App extends Application{

    public static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public static App getInstance() {
        return sInstance;
    }
}
