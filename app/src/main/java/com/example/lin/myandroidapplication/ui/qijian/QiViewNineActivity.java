package com.example.lin.myandroidapplication.ui.qijian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.qijian.AvatarViewDemo;
import com.example.lin.myandroidapplication.widget.qijian.BitmapShadowView;
import com.example.lin.myandroidapplication.widget.qijian.BlurMaskView;
import com.example.lin.myandroidapplication.widget.qijian.ExtractAlphaView;
import com.example.lin.myandroidapplication.widget.qijian.ShadowLayerView;
import com.example.lin.myandroidapplication.widget.qijian.TelescopeView;

public class QiViewNineActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtnQi01;
    private Button mBtnQi02;
    private Button mBtnQi03;
    private ShadowLayerView mShadowlayer;
    private BlurMaskView mBlurmask;
    private ExtractAlphaView mExtractalpha;
    private Button mBtnQi04;
    private Button mBtnQi05;
    private Button mBtnQi06;
    private BitmapShadowView mBitmapshadower;
    private TelescopeView mTelescope;
    private AvatarViewDemo mAvatarviewdemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qi_view_nine);
        initView();
    }

    private void initView() {
        mBtnQi01 = (Button) findViewById(R.id.btn_qi_01);
        mBtnQi01.setOnClickListener(this);
        mBtnQi02 = (Button) findViewById(R.id.btn_qi_02);
        mBtnQi02.setOnClickListener(this);
        mBtnQi03 = (Button) findViewById(R.id.btn_qi_03);
        mBtnQi03.setOnClickListener(this);
        mShadowlayer = (ShadowLayerView) findViewById(R.id.shadowlayer);
        mBlurmask = (BlurMaskView) findViewById(R.id.blurmask);
        mExtractalpha = (ExtractAlphaView) findViewById(R.id.extractalpha);
        mBtnQi04 = (Button) findViewById(R.id.btn_qi_04);
        mBtnQi04.setOnClickListener(this);
        mBtnQi05 = (Button) findViewById(R.id.btn_qi_05);
        mBtnQi05.setOnClickListener(this);
        mBtnQi06 = (Button) findViewById(R.id.btn_qi_06);
        mBtnQi06.setOnClickListener(this);
        mBitmapshadower = (BitmapShadowView) findViewById(R.id.bitmapshadower);
        mTelescope = (TelescopeView) findViewById(R.id.telescope);
        mAvatarviewdemo = (AvatarViewDemo) findViewById(R.id.avatarviewdemo);
    }

    @Override
    public void onClick(View v) {
        hideAllViews();
        switch (v.getId()) {
            case R.id.btn_qi_01:
                mShadowlayer.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_qi_02:
                mBlurmask.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_qi_03:
                mExtractalpha.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_qi_04:
                mBitmapshadower.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_qi_05:
                mTelescope.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_qi_06:
                mAvatarviewdemo.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void hideAllViews() {
        mShadowlayer.setVisibility(View.GONE);
        mBlurmask.setVisibility(View.GONE);
        mExtractalpha.setVisibility(View.GONE);
        mBitmapshadower.setVisibility(View.GONE);
        mTelescope.setVisibility(View.GONE);
        mAvatarviewdemo.setVisibility(View.GONE);
    }
}
