package com.example.lin.myandroidapplication.ui.aige;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.lin.myandroidapplication.R;

/**
 * set(Paint src)
 * 把另一个画笔的熟悉设置给这个画笔
 * setArgb(int a， int r， int g， int b)
 * 设置颜色 ARGB值
 * setAlpha(int a)
 * 设置透明度
 * setAntiAlias(boolean a)
 * 设置抗锯齿
 * setColor(int color)
 * 设置颜色(通过颜色的资源id)
 * setColorFilter(ColorFilter filter)
 * 设置颜色过滤 这个方法需要我们传入一个ColorFilter参数同样也会返回一个ColorFilter实例。
 * ColorFilter三个子类:
 * 1、ColorMatrixColorFilter : 色彩矩阵过滤
 * 2、LightingColorFilter : 光照颜色过滤
 * 3、PorterDuffColorFilter :
 *
 * PorterDuffXfermode
 */
public class AigeViewSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aige_view_second);
    }
}
