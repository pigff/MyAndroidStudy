package com.example.lin.myandroidapplication.ui.aige;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.aige.CircleView;

public class AigeViewOneActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aige_view_one);
        CircleView firstCustomView = (CircleView) findViewById(R.id.first_view);
        new Thread(firstCustomView).start();
    }
}
