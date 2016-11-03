package com.example.lin.myandroidapplication.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.lin.myandroidapplication.service.MyService;

/**
 * Created by lin on 2016/11/3.
 */
public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, MyService.class);
        if (intent.getIntExtra("stop", -1) == 10) {
            context.stopService(intent1);
        } else {
            context.startService(intent1);
        }

    }
}
