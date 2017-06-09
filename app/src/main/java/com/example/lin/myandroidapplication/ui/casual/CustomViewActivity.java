package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.SelectLayout;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.test_frame);
        SelectLayout layout = (SelectLayout) findViewById(R.id.selectlayout);
        layout.setItemClick(new SelectLayout.SelectClickListener() {
            @Override
            public void click(int position) {
                Toast.makeText(CustomViewActivity.this, "haha" + position, Toast.LENGTH_SHORT).show();
            }
        });

        FrameLayout child = new FrameLayout(this);
        child.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        TextView textView = new TextView(this);
        textView.setText("哈哈哈这是测试");
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;
        textView.setLayoutParams(layoutParams);
        child.addView(textView);
        frameLayout.addView(child);
    }
}
