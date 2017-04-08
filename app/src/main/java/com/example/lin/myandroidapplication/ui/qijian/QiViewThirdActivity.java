package com.example.lin.myandroidapplication.ui.qijian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.qijian.TouchDrawView;

public class QiViewThirdActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * Button
     */
    private Button mButton;
    private TouchDrawView mTouchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qi_view_third);
        initView();
    }

    private void initView() {
        mButton = (Button) findViewById(R.id.touch_button);
        mButton.setOnClickListener(this);
        mTouchView = (TouchDrawView) findViewById(R.id.touch_view);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.touch_button:
                mTouchView.reset();
                break;
        }
    }
}
