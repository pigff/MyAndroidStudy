package com.example.lin.myandroidapplication.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Point;
import android.net.Uri;
import android.os.Environment;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.example.lin.myandroidapplication.App;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by lin on 2017/2/22.
 */
public class AppUtils {


    public static String getCacheDir() {
        if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) || !Environment.isExternalStorageRemovable()) {
            File cacheFile = App.getInstance().getExternalCacheDir();
            if (null != cacheFile) {
                return cacheFile.getPath();
            }
        }
        return App.getInstance().getCacheDir().getPath();
    }



    public static String getGankDate(String date) {
        int index = date.indexOf("T");
        return date.substring(0, index);
    }

    public static Point getScreenPoint() {
        WindowManager wm = (WindowManager) App.getInstance()
                .getSystemService(Context.WINDOW_SERVICE);
        Point point = new Point();
        wm.getDefaultDisplay().getSize(point);

        return point;
    }

    private static DisplayMetrics getScreenMetrics() {
        WindowManager wm = (WindowManager) App.getInstance().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    public static int getScreenWidthM(){
        return getScreenMetrics().widthPixels;
    }

    public static int getScreenHeightM() {
        return getScreenMetrics().heightPixels;
    }

    public static int getScreenWidth() {
        return getScreenPoint().x;
    }

    public static int getScreenHeight() {
        return getScreenPoint().y;
    }

    public static String getZhiData(int page) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1 - page);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", Locale.CHINA);
        Date date = calendar.getTime();
        return simpleDateFormat.format(date);
    }


    public static String getAppName() {
        String appName = null;
        PackageManager packageManager = null;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = App.getInstance().getPackageManager();
            applicationInfo = packageManager.getApplicationInfo(App.getInstance().getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            applicationInfo = null;
        }
        appName = (String) packageManager.getApplicationLabel(applicationInfo);
        return TextUtils.isEmpty(appName) ? "" : appName;
    }



    public static void shareImage(Context context, Uri uri, String title) {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.setType("image/jpeg");
        context.startActivity(Intent.createChooser(shareIntent, title));
    }

    public static void test() {


    }
}
