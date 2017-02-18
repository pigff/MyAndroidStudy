package com.example.lin.myandroidapplication.ui.activity;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lin.myandroidapplication.R;
import com.jakewharton.disklrucache.DiskLruCache;

import java.io.File;

public class LruCacheStudyActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEditText;
    private DiskLruCache mDiskLruCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lru_cache_study);
        initCache();
        initView();
    }

    private void initCache() {
//        try {
//            File cacheDir = getDiskCacheDir(this, "string");
//            if (!cacheDir.exists()) {
//                cacheDir.mkdirs();
//            }
//            mDiskLruCache = DiskLruCache.open(cacheDir, getAppVersion(this), 1, 10 * 1024 * 1024);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        File cacheDir = getDiskCacheDir(this);
        if (!cacheDir.exists()) {
            cacheDir.mkdirs();
        }

    }

    private void initView() {
        Button saveBtn = (Button) findViewById(R.id.save_btn);
        saveBtn.setOnClickListener(this);
        Button showBtn = (Button) findViewById(R.id.show_btn);
        showBtn.setOnClickListener(this);
        mEditText = (EditText) findViewById(R.id.content);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_btn:

                break;
            case R.id.show_btn:
                break;
            default:
                break;
        }
    }

    public File getDiskCacheDir(Context context) {
        String cachePath;
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
                || !Environment.isExternalStorageRemovable()) {
            cachePath = context.getExternalCacheDir().getPath();
        } else {
            cachePath = context.getCacheDir().getPath();
        }
        return new File(cachePath);
    }

    public int getAppVersion(Context context) {
        try {
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return info.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }
}
