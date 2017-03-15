package com.example.lin.myandroidapplication.base;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by greedy on 17/3/15.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseFunIml {



    protected void openActivity(Class<?> clazz) {
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }



}
