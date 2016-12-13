package com.example.lin.myandroidapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lin.myandroidapplication.view.MultiRecyclerActivity;

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

        Button button6 = (Button) findViewById(R.id.btn_06);
        button6.setOnClickListener(this);

        Button button7 = (Button) findViewById(R.id.btn_07);
        button7.setOnClickListener(this);

        Button button8 = (Button) findViewById(R.id.btn_08);
        button8.setOnClickListener(this);

        Button button9 = (Button) findViewById(R.id.btn_09);
        button9.setOnClickListener(this);

        Button button10 = (Button) findViewById(R.id.btn_10);
        button10.setOnClickListener(this);

        Button button11 = (Button) findViewById(R.id.btn_11);
        button11.setOnClickListener(this);

        Button button12 = (Button) findViewById(R.id.btn_12);
        button12.setOnClickListener(this);

        Button button13 = (Button) findViewById(R.id.btn_13);
        button13.setOnClickListener(this);

        Button button14 = (Button) findViewById(R.id.btn_14);
        button14.setOnClickListener(this);

        Button button15 = (Button) findViewById(R.id.btn_15);
        button15.setOnClickListener(this);

        Button button16 = (Button) findViewById(R.id.btn_16);
        button16.setOnClickListener(this);

        Button button17 = (Button) findViewById(R.id.btn_17);
        button17.setOnClickListener(this);

        Button button18 = (Button) findViewById(R.id.btn_18);
        button18.setOnClickListener(this);
        Button button19 = (Button) findViewById(R.id.btn_19);
        button19.setOnClickListener(this);
        Button button20 = (Button) findViewById(R.id.btn_20);
        button20.setOnClickListener(this);
        Button button21 = (Button) findViewById(R.id.btn_21);
        button21.setOnClickListener(this);
        Button button22 = (Button) findViewById(R.id.btn_22);
        button22.setOnClickListener(this);
        Button button23 = (Button) findViewById(R.id.btn_23);
        button23.setOnClickListener(this);
        Button button24 = (Button) findViewById(R.id.btn_24);
        button24.setOnClickListener(this);
        Button button25 = (Button) findViewById(R.id.btn_25);
        button25.setOnClickListener(this);
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
            case R.id.btn_06:
                Intent intent2Tog = new Intent(this, ToggleStudy.class);
                startActivity(intent2Tog);
                break;
            case R.id.btn_07:
                Intent intent2Pro = new Intent(this, ProgressStudy.class);
                startActivity(intent2Pro);
                break;
            case R.id.btn_08:
                Intent intent2Seek = new Intent(this, SeekBarStudy.class);
                startActivity(intent2Seek);
                break;
            case R.id.btn_09:
                Intent intent2Scroll = new Intent(this, ScrollViewStudy.class);
                startActivity(intent2Scroll);
                break;
            case R.id.btn_10:
                Intent intent2List = new Intent(this, ListViewStudy.class);
                startActivity(intent2List);
                break;
            case R.id.btn_11:
                Intent intent2Service = new Intent(this, ServiceStudy.class);
                startActivity(intent2Service);
                break;
            case R.id.btn_12:
                Intent intent2Spin = new Intent(this, SpinnerStudy.class);
                startActivity(intent2Spin);
                break;
            case R.id.btn_13:
                Intent intent2Dialog = new Intent(this, DialogStudy.class);
                startActivity(intent2Dialog);
                break;
            case R.id.btn_14:
                Intent intent2Pop = new Intent(this, PopWindowStudy.class);
                startActivity(intent2Pop);
                break;
            case R.id.btn_15:
                Intent intent2Web = new Intent(this, WebViewStudy.class);
                startActivity(intent2Web);
                break;
            case R.id.btn_16:
                Intent intent2Web2 = new Intent(this, WebViewStudy2.class);
                startActivity(intent2Web2);
                break;
            case R.id.btn_17:
                Intent intent2Web3 = new Intent(this, WebViewStudy3.class);
                startActivity(intent2Web3);
                break;
            case R.id.btn_18:
                Intent intent2Turn = new Intent(this, TurnSaveStudy.class);
                startActivity(intent2Turn);
                break;
            case R.id.btn_19:
                Intent intent2Loading = new Intent(this, LoadingActivity.class);
                startActivity(intent2Loading);
                break;
            case R.id.btn_20:
                Intent intent2Drawable = new Intent(this, DrawableActivity.class);
                startActivity(intent2Drawable);
                break;
            case R.id.btn_21:
                Intent intent2Tool = new Intent(this, ToolbarActivity.class);
                startActivity(intent2Tool);
                break;
            case R.id.btn_22:
                Intent intent2Rv = new Intent(this, MultiRecyclerActivity.class);
                startActivity(intent2Rv);
                break;
            case R.id.btn_23:
                Intent intent2Coo = new Intent(this, CoordinaLayoutActivity.class);
                startActivity(intent2Coo);
                break;
            case R.id.btn_24:
                Intent intent2Coo2 = new Intent(this, CoordinaLayout2Activity.class);
                startActivity(intent2Coo2);
                break;
            case R.id.btn_25:
                Intent intent2Cache = new Intent(this, LruCacheStudyActivity.class);
                startActivity(intent2Cache);
                break;
            default:
                break;
        }
    }
}
