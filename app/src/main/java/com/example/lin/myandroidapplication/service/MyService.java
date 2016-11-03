package com.example.lin.myandroidapplication.service;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.lin.myandroidapplication.receiver.MyReceiver;

/**
 * Created by lin on 2016/11/3.
 */
public class MyService extends Service {

    private static final String TAG = "MyService";

    private int count;

    private boolean quit;

    private MyBinder mBinder = new MyBinder();
    public class MyBinder extends Binder {

        public int getCount() {
            return count;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate() called with: " + "create!");

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand() called with: " + "intent = [" + intent + "], flags = [" + flags + "], startId = [" + startId + "]");
//        new Thread() {
//            public void run() {
//                while (!quit) {
//                    try {
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    count++;
//                }
//            }
//        }.start();
        count++;
        Log.d(TAG, "count:" + count);
        AlarmManager manager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHour = 2 * 1000;
        long triggerAtTime = anHour;
        Intent i = new Intent(this, MyReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, i, 0);
        manager.set(AlarmManager.ELAPSED_REALTIME, triggerAtTime, pendingIntent);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d(TAG, "onUnbind() called with: " + "intent = [" + intent + "]");
        return true;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind() called with: " + "intent = [" + intent + "]");
        return mBinder;
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "onDestroy() called with: " + "destroy!");
        super.onDestroy();
        Intent intent = new Intent(this, MyReceiver.class);
        intent.putExtra("stop", 10);
        sendBroadcast(intent);
        quit = true;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind() called with: " + "intent = [" + intent + "]");
    }
}
