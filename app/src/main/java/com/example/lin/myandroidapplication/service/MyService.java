package com.example.lin.myandroidapplication.service;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.receiver.MyReceiver;

/**
 * Created by lin on 2016/11/3.
 */
public class MyService extends Service {

    private static final String TAG = "MyService";

    private int count;

    private boolean quit;

    private MyBinder mBinder = new MyBinder();
    private AlarmManager mManager;
    private PendingIntent mPendingIntent;

    public class MyBinder extends Binder {

        public int getCount() {
            return count;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Notification.Builder builder = new Notification.Builder(this);
        builder.setAutoCancel(true);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setTicker("前台服务");
        builder.setContentTitle("提示");
        builder.setContentText("loading");
        startForeground(1, builder.build());
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
        mManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        int anHour = 2 * 1000;
        long triggerAtTime = anHour;
        Intent i = new Intent(this, MyReceiver.class);
        mPendingIntent = PendingIntent.getBroadcast(this, 0, i, 0);
        mManager.set(AlarmManager.ELAPSED_REALTIME, triggerAtTime, mPendingIntent);
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
        mManager.cancel(mPendingIntent);
        quit = true;
    }

    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);
        Log.d(TAG, "onRebind() called with: " + "intent = [" + intent + "]");
    }
}
