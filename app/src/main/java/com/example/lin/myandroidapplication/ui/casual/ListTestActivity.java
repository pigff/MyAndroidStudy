package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.LinkedListView;

public class ListTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_test);
        LinkedListView listView = (LinkedListView) findViewById(R.id.linked);
        listView.setCallBack(new LinkedListView.LinkedCallBack() {
            @Override
            public void clickCallBack() {
                Toast.makeText(ListTestActivity.this, "哈哈你点了我", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
