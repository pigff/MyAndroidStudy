package com.example.lin.myandroidapplication.ui.qijian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.qijian.WaterRipple;

public class QiViewFourActivity extends AppCompatActivity {

    private WaterRipple mWaterRipple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qi_view_fourth);
        initView();
    }

    private void initView() {
        mWaterRipple = (WaterRipple) findViewById(R.id.waterRipple);
        mWaterRipple.startAnim();
    }
}
