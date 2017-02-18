package com.example.lin.myandroidapplication.ui.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lin.myandroidapplication.R;

public class PropertyAnimStudyActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mImageView;
    private ObjectAnimator mAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim_study);
        bindView();
    }

    private void bindView() {
        Button scaleBtn = (Button) findViewById(R.id.obj_anim_btn_01);
        Button alphaBtn = (Button) findViewById(R.id.obj_anim_btn_02);
        Button translateBtn = (Button) findViewById(R.id.obj_anim_btn_03);
        Button rotateBtn = (Button) findViewById(R.id.obj_anim_btn_04);
        Button setBtn = (Button) findViewById(R.id.obj_anim_btn_05);
        mImageView = (ImageView) findViewById(R.id.obj_anim_test_img);

        scaleBtn.setOnClickListener(this);
        alphaBtn.setOnClickListener(this);
        translateBtn.setOnClickListener(this);
        rotateBtn.setOnClickListener(this);
        setBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.obj_anim_btn_01:
                mAnimator = ObjectAnimator.ofFloat(mImageView, "scaleY", 0f, 300f, 1f);
                mAnimator.setDuration(5000);
                mAnimator.start();
                break;
            case R.id.obj_anim_btn_02:
                mAnimator = ObjectAnimator.ofFloat(mImageView, "alpha", 0f, 1f, 0f);
                mAnimator.setDuration(6000);
                mAnimator.start();
                break;
            case R.id.obj_anim_btn_03:
                mAnimator = ObjectAnimator.ofFloat(mImageView, "translationX", 0f, 300f, 0f);
                mAnimator.setDuration(6000);
                mAnimator.start();
                break;
            case R.id.obj_anim_btn_04:
                mAnimator = ObjectAnimator.ofFloat(mImageView, "rotation", 0f, 360f);
                mAnimator.setDuration(6000);
                mAnimator.start();
                break;
            case R.id.obj_anim_btn_05:
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(mImageView, "translationX", -500f, 0f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(mImageView, "rotation", 0f, 360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(mImageView, "alpha", 1f, 0f, 1f);
                AnimatorSet set = new AnimatorSet();
                set.play(rotate).with(fadeInOut).after(moveIn);
                set.setDuration(6000);
                set.start();
                break;
            default:
                break;
        }
    }
}
