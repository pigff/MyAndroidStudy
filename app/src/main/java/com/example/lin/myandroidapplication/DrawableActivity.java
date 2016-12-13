package com.example.lin.myandroidapplication;

import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.RotateDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class DrawableActivity extends AppCompatActivity {

    private ClipDrawable mClipDrawable;
    private RotateDrawable mRotateDrawable;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 10:
                    if (mClipDrawable.getLevel() < 10000) {
                        mClipDrawable.setLevel(mClipDrawable.getLevel() + 200);
                    }
                    break;
                case 20:
                    if (mRotateDrawable.getLevel() < 10000) {
                        mRotateDrawable.setLevel(mRotateDrawable.getLevel() + 500);
                    }
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable);
        ImageView imageView = (ImageView) findViewById(R.id.clib_01);
        mClipDrawable = (ClipDrawable) imageView.getDrawable();
        ImageView imageView1 = (ImageView) findViewById(R.id.rotate_01);
        mRotateDrawable = (RotateDrawable) imageView1.getDrawable();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                mHandler.sendEmptyMessage(10);
                mHandler.sendEmptyMessage(20);
            }
        },0, 1000);


    }
}
