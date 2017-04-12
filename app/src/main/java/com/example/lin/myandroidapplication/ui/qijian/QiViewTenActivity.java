package com.example.lin.myandroidapplication.ui.qijian;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.qijian.ShimmerTextView;

public class QiViewTenActivity extends AppCompatActivity {

    /**
     * 嘻嘻嘻嘻 大瓜皮
     */
    private ShimmerTextView mShimmertextview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qi_view_ten);
        initView();
    }

    private void initView() {
        mShimmertextview = (ShimmerTextView) findViewById(R.id.shimmertextview);
    }


}
