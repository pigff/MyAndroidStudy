package com.example.lin.myandroidapplication.ui.hongyang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.yangWidget.CustomProgressView;

public class YangViewThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yang_view_third);
        CustomProgressView view01 = (CustomProgressView) findViewById(R.id.view_yang_progress01);
        CustomProgressView view02 = (CustomProgressView) findViewById(R.id.view_yang_progress02);
        new Thread(view01).start();
        new Thread(view02).start();
    }
}
