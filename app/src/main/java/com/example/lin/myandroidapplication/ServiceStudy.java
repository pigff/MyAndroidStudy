package com.example.lin.myandroidapplication;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.lin.myandroidapplication.service.MyService;

/**
 * Created by lin on 2016/11/3.
 */
public class ServiceStudy extends Activity implements View.OnClickListener {

    private static final String TAG = "ServiceStudy";
    private Intent mIntent;

    MyService.MyBinder mBinder;

    private ServiceConnection mServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.d(TAG, "onServiceConnected() called with: " + "name = [" + name + "], service = [" + service + "]");
            mBinder = (MyService.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.d(TAG, "onServiceDisconnected: 解除绑定");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_layout);
        Button startBtn = (Button) findViewById(R.id.start_btn);
        Button stopBtn = (Button) findViewById(R.id.stop_service);
        Button bindBtn = (Button) findViewById(R.id.bind_service);
        Button unbindBtn = (Button) findViewById(R.id.unbind_service);
        Button checkBtn = (Button) findViewById(R.id.check);
        Button intentBtn = (Button) findViewById(R.id.intent_service);
        intentBtn.setOnClickListener(this);
        checkBtn.setOnClickListener(this);
        startBtn.setOnClickListener(this);
        stopBtn.setOnClickListener(this);
        bindBtn.setOnClickListener(this);
        unbindBtn.setOnClickListener(this);
        mIntent = new Intent(this, MyService.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_btn:
                startService(mIntent);
                break;
            case R.id.stop_service:
                stopService(mIntent);
                break;
            case R.id.bind_service:
                bindService(mIntent, mServiceConnection, BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(mServiceConnection);
                break;
            case R.id.check:
                Log.d(TAG, "mBinder.getCount():" + mBinder.getCount());
                break;
            case R.id.intent_service:
                startService(mIntent);
                break;
            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        unbindService(mServiceConnection);
    }
}
