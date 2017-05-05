package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.SelectLayout;

public class CustomViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_view);
        SelectLayout layout = (SelectLayout) findViewById(R.id.selectlayout);
        layout.setItemClick(new SelectLayout.SelectClickListener() {
            @Override
            public void click(int position) {
                Toast.makeText(CustomViewActivity.this, "haha" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
