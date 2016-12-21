package com.example.lin.myandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AnimStudyActivity extends AppCompatActivity implements View.OnClickListener{

    private Animation mAnimation;
    private ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anim_study);
        bindView();
    }

    private void bindView() {
        Button button1 = (Button) findViewById(R.id.anim_btn_01);
        Button button2 = (Button) findViewById(R.id.anim_btn_02);
        Button button3 = (Button) findViewById(R.id.anim_btn_03);
        Button button4 = (Button) findViewById(R.id.anim_btn_04);
        Button button5 = (Button) findViewById(R.id.anim_btn_05);
        mImageView = (ImageView) findViewById(R.id.anim_test_img);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.anim_btn_01:
                mAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
                mImageView.startAnimation(mAnimation);
                break;
            case R.id.anim_btn_02:
                mAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_rotate);
                mImageView.startAnimation(mAnimation);
                break;
            case R.id.anim_btn_03:
                mAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_scale);
                mImageView.startAnimation(mAnimation);
                break;
            case R.id.anim_btn_04:
                mAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_translate);
                mImageView.startAnimation(mAnimation);
                break;
            case R.id.anim_btn_05:
                mAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_set);
                mImageView.startAnimation(mAnimation);
                break;
            default:
                break;
        }
    }
}
