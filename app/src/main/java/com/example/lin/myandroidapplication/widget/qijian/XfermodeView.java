package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by greedy on 2017/4/10.
 * 一些名词解释:
 * Sa 全称为Source alpha 表示源图的alpha通道
 * Sc 全称为Source color 表示源图的颜色
 * Da 全称为Destination alpha 表示目标图Alpha通道
 * Dc 全称为Destination color 表示目标图的颜色
 */

public class XfermodeView extends View {

    public XfermodeView(Context context) {
        super(context);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public XfermodeView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
