package com.example.lin.myandroidapplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by lin on 2016/11/17.
 */
public class TurnSaveStudy extends Activity{

    public static final String COUNT = "count";
    private TextView mTextView;
    private int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turn_layout);
        if (savedInstanceState != null) {
            mCount = savedInstanceState.getInt(COUNT, 0);
        }
        mTextView = (TextView) findViewById(R.id.show_count);
        mTextView.setText(String.valueOf(mCount));
    }

    public void add(View view) {
        mCount++;
        mTextView.setText(String.valueOf(mCount));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(COUNT, mCount);
        super.onSaveInstanceState(outState);
    }
}
