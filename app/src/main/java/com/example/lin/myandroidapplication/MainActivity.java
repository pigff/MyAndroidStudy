package com.example.lin.myandroidapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    private void init() {
        Button button = (Button) findViewById(R.id.btn_01);
        button.setOnClickListener(this);

        Button button3 = (Button) findViewById(R.id.btn_03);
        button3.setOnClickListener(this);

        Button button2 = (Button) findViewById(R.id.btn_02);
        button2.setOnClickListener(this);

        Button button4 = (Button) findViewById(R.id.btn_04);
        button4.setOnClickListener(this);

        Button button5 = (Button) findViewById(R.id.btn_05);
        button5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_01:
                Intent intent2Text = new Intent(this, TextViewStudy.class);
                startActivity(intent2Text);
                break;
            case R.id.btn_02:
                Intent intent2Btn = new Intent(this, ButtonStudy.class);
                startActivity(intent2Btn);
                break;
            case R.id.btn_03:
                Intent intent2Edit = new Intent(this, EditTextStudy.class);
                startActivity(intent2Edit);
                break;
            case R.id.btn_04:
                Intent intent2Img = new Intent(this, ImageViewStudy.class);
                startActivity(intent2Img);
                break;
            case R.id.btn_05:
                Intent intent2Radio = new Intent(this, RadioAndCheckBtnStudy.class);
                startActivity(intent2Radio);
                break;
            default:
                break;
        }
    }
}
