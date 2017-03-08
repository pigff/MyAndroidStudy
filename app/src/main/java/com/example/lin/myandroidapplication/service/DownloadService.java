package com.example.lin.myandroidapplication.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.example.lin.myandroidapplication.App;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.Download;
import com.example.lin.myandroidapplication.network.DownloadRequestManager;
import com.example.lin.myandroidapplication.network.download.ProgressResponseListener;
import com.example.lin.myandroidapplication.util.Constants;
import com.example.lin.myandroidapplication.util.FileUtils;
import com.example.lin.myandroidapplication.util.StringUtils;

import java.io.File;
import java.io.InputStream;

import rx.Subscriber;

/**
 * Created by lin on 2017/3/3.
 */

public class DownloadService extends IntentService {
    private static final String TAG = "DownloadService";

    private String apkUrl = "http://download.fir.im/v2/app/install/5818acbcca87a836f50014af?download_token=a01301d7f6f8f4957643c3fcfe5ba6ff";
    private NotificationManager mNotificationManager;
    private Notification.Builder mBuilder;
    private File mFile;


    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String data = intent.getStringExtra(Constants.DATA);
        Log.d(TAG, data);

        mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mBuilder = new Notification.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Downloading File")
                .setContentTitle("Download")
                .setAutoCancel(true);

        mNotificationManager.notify(0, mBuilder.build());
        download();
    }

    private void download() {
        ProgressResponseListener listener = new ProgressResponseListener() {
            @Override
            public void onResponseProgress(long bytesRead, long contentLength, boolean done) {
                int progress = (int) ((bytesRead * 100) / contentLength);
                Log.d(TAG, "progress:" + progress);
                Download download = new Download();
                download.setCurrentFileSize(bytesRead);
                download.setTotalFileSize(contentLength);
                download.setProgress(progress);
                sendNotification(download);
            }
        };

        mFile = new File(FileUtils.getDiskCacheDir(App.getInstance(), "file.apk"));
        if (mFile.exists()) {
            mFile.delete();
        }

        String baseUrl = StringUtils.getHostName(apkUrl);
        new DownloadRequestManager(baseUrl, listener).downloadApk(apkUrl, mFile, new Subscriber<InputStream>() {
            @Override
            public void onCompleted() {
                mNotificationManager.cancel(0);
                mBuilder = new Notification.Builder(DownloadService.this)
                        .setSmallIcon(R.drawable.ic_tur_icon)
                        .setContentText("Downloading File ok")
                        .setContentTitle("Download")
                        .setAutoCancel(true);

                mNotificationManager.notify(1, mBuilder.build());
                Toast.makeText(App.getInstance(), "下载完成", Toast.LENGTH_SHORT).show();
//                Toast.makeText(DownloadService.this, "completed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(InputStream inputStream) {

            }
        });
//        new DownloadAPI(baseUrl, listener).downloadAPK(apkUrl, mFile, new Subscriber<InputStream>() {
//            @Override
//            public void onCompleted() {
//                Log.d(TAG, "completed");
//            }
//
//            @Override
//            public void onError(Throwable e) {
//
//            }
//
//            @Override
//            public void onNext(InputStream o) {
//
//            }
//        });
    }

    private void sendNotification(Download download) {
        if (download.getProgress() == 100) {

        } else {
            mBuilder.setProgress(100, download.getProgress(), false)
                    .setContentText(StringUtils.getDataSize(download.getCurrentFileSize()) + "/"
                            + StringUtils.getDataSize(download.getTotalFileSize()));
            mNotificationManager.notify(0, mBuilder.build());
        }

    }


}
