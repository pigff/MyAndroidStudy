package com.example.lin.myandroidapplication.ui.casual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.SelectLayout;

import java.util.ArrayList;
import java.util.List;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        SelectLayout layout = (SelectLayout) findViewById(R.id.selectlayout);
        List<String> strings = new ArrayList<>();
        strings.add("第1个");
        strings.add("第2个");
        strings.add("第3个");
        strings.add("第4个");
        layout.addTab(strings);
        layout.setItemClick(new SelectLayout.SelectClickListener() {
            @Override
            public void click(int position) {
                Toast.makeText(CustomViewActivity.this, "haha" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
