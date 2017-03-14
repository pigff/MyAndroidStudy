package com.example.lin.myandroidapplication;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by lin on 2017/2/18.
 */
public class App extends Application{

    public static App sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Realm.init(this);
        //默认Realm配置
        RealmConfiguration configuration = new RealmConfiguration.Builder().build();
        // 自定义Realm配置
//        RealmConfiguration configuration = new RealmConfiguration.Builder()
//                .name("myRealm.realm")
//                .deleteRealmIfMigrationNeeded()
//                .build();
        Realm.setDefaultConfiguration(configuration);
    }

    public static App getInstance() {
        return sInstance;
    }
}
