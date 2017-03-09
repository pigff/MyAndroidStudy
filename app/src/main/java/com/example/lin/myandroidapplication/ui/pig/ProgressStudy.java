package com.example.lin.myandroidapplication.ui.pig;

import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.lin.myandroidapplication.R;

/**
 * Created by lin on 2016/11/1.
 */
public class ProgressStudy extends Activity{

    private AnimationDrawable mAnimationDrawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress_layout);
        ImageView imageView = (ImageView) findViewById(R.id.load_img);
        mAnimationDrawable = (AnimationDrawable) imageView.getDrawable();
        imageView.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mAnimationDrawable != null) {
                    mAnimationDrawable.start();
                }
            }
        }, 100);
    }
}
