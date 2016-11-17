package com.example.lin.myandroidapplication.util;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;

/**
 * Created by lin on 2016/11/16.
 */
public class MyObject {
    private Context mContext;

    public MyObject(Context context) {
        mContext = context;
    }

    public void showToast(String name) {
        Toast.makeText(mContext, name, Toast.LENGTH_SHORT).show();
    }

    public void showDialog() {
        new AlertDialog.Builder(mContext)
                .setTitle("联系人列表")
                .setIcon(R.drawable.ic_action_emo_cool)
                .setItems(new String[]{"第一个", "第二个", "第三个"}, null)
                .setPositiveButton("确定", null)
                .create().show();
    }
}
