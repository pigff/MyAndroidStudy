package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lin.myandroidapplication.R;

import org.greenrobot.eventbus.EventBus;

public class TestEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_event);
        Button button = (Button) findViewById(R.id.add_event_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventBus.getDefault().post(1212);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public class TestBean {
        String name;

        public TestBean(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
