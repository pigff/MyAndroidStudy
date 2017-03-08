package com.example.lin.myandroidapplication.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.service.DownloadService;
import com.example.lin.myandroidapplication.util.Constants;

public class DownloadActivity extends AppCompatActivity {

    private Button mDownloadBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        mDownloadBtn = (Button) findViewById(R.id.btn_download);
        mDownloadBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2Download = new Intent(DownloadActivity.this, DownloadService.class);
                intent2Download.putExtra(Constants.DATA, "xixi");
                startService(intent2Download);
            }
        });
    }
}
