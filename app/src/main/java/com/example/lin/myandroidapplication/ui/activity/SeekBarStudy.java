package com.example.lin.myandroidapplication.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;

/**
 * Created by lin on 2016/11/1.
 */
public class SeekBarStudy extends Activity{

    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar_layout);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar_01);
        mTextView = (TextView) findViewById(R.id.show_progress);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextView.setText("当前进度是:" + progress + "。" + "fromUser:" + fromUser);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SeekBarStudy.this, "碰触滑块", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SeekBarStudy.this, "离开滑块", Toast.LENGTH_SHORT).show();
            }
        });

        RatingBar ratingBar = (RatingBar) findViewById(R.id.rating_01);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(SeekBarStudy.this, String.valueOf(rating) + "fromUser:" + fromUser, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
