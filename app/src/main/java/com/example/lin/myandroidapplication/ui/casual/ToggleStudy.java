package com.example.lin.myandroidapplication.ui.casual;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.lin.myandroidapplication.R;

/**
 * Created by lin on 2016/11/1.
 */
public class ToggleStudy extends Activity implements CompoundButton.OnCheckedChangeListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activiy_toggle_layout);
        Switch switchBtn = (Switch) findViewById(R.id.switchBtn);
        ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggleBtn);
        switchBtn.setOnCheckedChangeListener(this);
        toggleButton.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.switchBtn:
                if (buttonView.isChecked()) {
                    Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.toggleBtn:
                if (buttonView.isChecked()) {
                    Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "no", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
