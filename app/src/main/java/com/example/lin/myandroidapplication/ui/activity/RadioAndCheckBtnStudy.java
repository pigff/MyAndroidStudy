package com.example.lin.myandroidapplication.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;


/**
 * Created by lin on 2016/11/1.
 */
public class RadioAndCheckBtnStudy extends Activity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox mCheckBox;
    private CheckBox mCheckBox1;
    private CheckBox mCheckBox2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_layout);
        final RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radio_group);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton radioButton = (RadioButton) findViewById(checkedId);
                Toast.makeText(RadioAndCheckBtnStudy.this, "you click is " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });
        Button button = (Button) findViewById(R.id.btnPost);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) radioGroup.getChildAt(i);
                    if (radioButton.isChecked()) {
                        Toast.makeText(RadioAndCheckBtnStudy.this, "you click is " + radioButton.getText(), Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        // getChildCount 获取 RadioGroup里的数量 getChildAt 获取指定位置的RadioButton  isChecked 判断是否被选中
        mCheckBox = (CheckBox) findViewById(R.id.apple);
        mCheckBox1 = (CheckBox) findViewById(R.id.orange);
        mCheckBox2 = (CheckBox) findViewById(R.id.banana);
        mCheckBox.setOnCheckedChangeListener(this);
        mCheckBox1.setOnCheckedChangeListener(this);
        mCheckBox2.setOnCheckedChangeListener(this);
        Button button1 = (Button) findViewById(R.id.count);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuilder stringBuilder = new StringBuilder();
                if (mCheckBox.isChecked()) {
                    stringBuilder.append(mCheckBox.getText().toString() + " ");
                }
                if (mCheckBox1.isChecked()) {
                    stringBuilder.append(mCheckBox1.getText().toString() + " ");
                }
                if (mCheckBox2.isChecked()) {
                    stringBuilder.append(mCheckBox2.getText().toString() + " ");
                }
                Toast.makeText(RadioAndCheckBtnStudy.this, "count:" + stringBuilder, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.isChecked()) {
            Toast.makeText(this, "you choose is" + buttonView.getText(), Toast.LENGTH_SHORT).show();
        }
    }


}
