package com.example.lin.myandroidapplication.widget.aigeWidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.util.AppUtils;
import com.example.lin.myandroidapplication.util.PorterDuffBO;

/**
 * Created by greedy on 17/3/14.
 */

public class PorterDuffXmodView extends View {

//    private static final PorterDuff.Mode MODE = PorterDuff.Mode.ADD;
    private static final PorterDuff.Mode MODE = PorterDuff.Mode.CLEAR;

    private static final int RECT_SIZE_SMALL = 400; // 左右上方示例渐变正方形的尺寸大小
    private static final int RECT_SIZE_BIG = 800; // 中间测试渐变正方形的尺寸大小

    private Paint mPaint;

    private PorterDuffBO mPorterDuffBO;     // PorterDuffView类的业务对象
    private PorterDuffXfermode mPorterDuffXfermode; // 图形混合模式

    private int mScreenW, mScreenH; // 屏幕尺寸
    private int s_l, s_t;   // 左上方正方形原点坐标
    private int d_l, d_t; // 右上方正方形原点坐标
    private int rectX, rectY; // 中间正方形的原点坐标

    public PorterDuffXmodView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        mPorterDuffBO = new PorterDuffBO();

        mPorterDuffXfermode = new PorterDuffXfermode(MODE);

        calu(context);
    }

    private void calu(Context context) {
        // 获取屏幕尺寸
        mScreenH = AppUtils.getScreenHeightM();
        mScreenW = AppUtils.getScreenWidthM();
        // 计算左上方正方形原点坐标
        s_l = 0;
        s_t = 0;
        // 计算右上方正方形原点坐标
        d_l = mScreenW - RECT_SIZE_SMALL;
        d_t = 0;

        rectX = mScreenW / 2 - RECT_SIZE_BIG / 2;
        rectY = RECT_SIZE_SMALL + (mScreenH - RECT_SIZE_SMALL) / 2 - RECT_SIZE_BIG / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.BLACK);
        //设置业务对象尺寸计算生成左右上方的渐变方形
        mPorterDuffBO.setSize(RECT_SIZE_SMALL);

        /**
         * 画出左右上方两个正方形
         * 其中左边的为src右边的dis
         */
        canvas.drawBitmap(mPorterDuffBO.initSrcBitmap(), s_l, s_t, mPaint);
        canvas.drawBitmap(mPorterDuffBO.initDisBitmap(), d_l, d_t, mPaint);

        /**
         * 将绘制操作保存到新的图层(更官方的说法应该是离屏缓存)我们将在1/3中学习到Canvas的全部用法这是就先follow me
         */

        int src = canvas.saveLayer(0,0,mScreenW, mScreenH, null, Canvas.ALL_SAVE_FLAG);

        //重新设置业务对象尺寸计算生成中间的渐变方形
        mPorterDuffBO.setSize(RECT_SIZE_BIG);

        //先绘制dis目标图
        canvas.drawBitmap(mPorterDuffBO.initDisBitmap(), rectX, rectY, mPaint);
        //设置混合模式
        mPaint.setXfermode(mPorterDuffXfermode);
        //再绘制src源图
        canvas.drawBitmap(mPorterDuffBO.initSrcBitmap(), rectX, rectY, mPaint);
        //还原模式
        mPaint.setXfermode(null);
        //还原画布
        canvas.restoreToCount(src);
    }
}
