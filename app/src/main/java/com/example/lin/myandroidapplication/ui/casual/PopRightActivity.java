package com.example.lin.myandroidapplication.ui.casual;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.DrawerPopWindow;

import java.util.ArrayList;
import java.util.List;

public class PopRightActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_right);
        final List<String> strings = new ArrayList<>();
        strings.add("安全隐患");
        strings.add("安全隐患1");
        strings.add("安全隐患2");
        strings.add("安全隐患3");
        strings.add("安全隐患4");
        strings.add("安全隐患5");
        strings.add("安全隐患6");
        final Button button = (Button) findViewById(R.id.show_pop_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DrawerPopWindow window = new DrawerPopWindow(PopRightActivity.this,  strings);
                window.showPoppupWindow(button);
            }
        });
    }
}
