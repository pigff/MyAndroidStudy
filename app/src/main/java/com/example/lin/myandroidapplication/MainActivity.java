package com.example.lin.myandroidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button button = (Button) findViewById(R.id.btn_01);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                Intent intent2Text = new Intent(this, TextViewStudy.class);
                startActivity(intent2Text);
                break;
            case R.id.btn_02:
                break;
            case R.id.btn_03:
                break;
            case R.id.btn_04:
                break;
            default:
                break;
        }
    }
}
