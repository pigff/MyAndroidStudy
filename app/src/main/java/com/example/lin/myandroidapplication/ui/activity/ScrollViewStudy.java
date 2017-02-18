package com.example.lin.myandroidapplication.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.lin.myandroidapplication.R;

/**
 * Created by lin on 2016/11/1.
 */
public class ScrollViewStudy extends Activity implements View.OnClickListener{

    private ScrollView mScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_layout);
        mScrollView = (ScrollView) findViewById(R.id.scroll_01);
        TextView textView = (TextView) findViewById(R.id.text_01);
        Button button1 = (Button) findViewById(R.id.upBtn);
        Button button = (Button) findViewById(R.id.downBtn);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 101; i++) {
            stringBuilder.append("嘻嘻" + i + "\n");
        }
        textView.setText(stringBuilder);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.upBtn:
                mScrollView.fullScroll(ScrollView.FOCUS_UP);
                break;
            case R.id.downBtn:
                mScrollView.fullScroll(ScrollView.FOCUS_DOWN);
                break;
            default:
                break;
        }
    }
}
