package com.example.lin.myandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wang.avi.AVLoadingIndicatorView;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);
        initView();
    }

    private void initView() {
        AVLoadingIndicatorView avi1 = (AVLoadingIndicatorView) findViewById(R.id.avi1);
        avi1.show();
        AVLoadingIndicatorView avi2 = (AVLoadingIndicatorView) findViewById(R.id.avi2);
        avi2.show();
        AVLoadingIndicatorView avi3 = (AVLoadingIndicatorView) findViewById(R.id.avi3);
        avi3.show();
        AVLoadingIndicatorView avi4 = (AVLoadingIndicatorView) findViewById(R.id.avi4);
        avi4.show();
    }
}
