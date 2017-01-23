package com.example.lin.myandroidapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class VFStudyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_filpper);
        ViewFlipper flipper = (ViewFlipper) findViewById(R.id.vf);
        View inflate = getLayoutInflater().inflate(R.layout.vf_tv_item, null, false);
        View inflate2 = getLayoutInflater().inflate(R.layout.vf_tv_item, null, false);
        TextView tv01 = (TextView) inflate.findViewById(R.id.vf_tv_01);
        tv01.setText("嘻嘻嘻嘻嘻这是第一行嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻");
        TextView tv02 = (TextView) inflate.findViewById(R.id.vf_tv_02);
        tv02.setText("嘻嘻嘻嘻嘻这是第二行嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻");
        flipper.addView(inflate);
        TextView tv03 = (TextView) inflate2.findViewById(R.id.vf_tv_01);
        TextView tv04 = (TextView) inflate2.findViewById(R.id.vf_tv_02);
        tv03.setText("嘻嘻嘻嘻嘻这是第三行嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻");
        tv04.setText("嘻嘻嘻嘻嘻这是第四行嘻嘻嘻嘻嘻嘻嘻嘻嘻嘻");
        flipper.addView(inflate2);
        flipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VFStudyActivity.this, "xixi", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
