package com.example.lin.myandroidapplication.widget.aigeWidget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.util.AppUtils;

/**
 * Created by greedy on 17/3/13.
 * ColorMatrixColorFilter 圆形
 */

public class ColorMatrixView extends View {

    private Paint mPaint;

    private int radius;

    public ColorMatrixView(Context context) {
        super(context, null);
    }

    public ColorMatrixView(Context context, AttributeSet attrs) {
        super(context, attrs);
        radius = 200;
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true); //抗锯齿
        /**
         * 设置画笔样式为描边，
         *
         * 画笔样式分三种：
         * 1、Paint.Style.Stroke:描边
         * 2、Paint.Style.FILL_AND_STROKE:描边并填充
         * 3、Paint.Style.FILL:填充
         */

        mPaint.setStyle(Paint.Style.FILL);

        //设置画笔颜色为浅灰色
        mPaint.setColor(Color.argb(255, 255, 128, 103));

        //生成色彩矩阵
        ColorMatrixColorFilter matrixColorFilter = new ColorMatrixColorFilter(new float[] {
                0.5f,0,0,0,0,
                0,0.5f,0,0,0,
                0,0,0.5f,0,0,
                0,0,0,1,0
        });
        mPaint.setColorFilter(matrixColorFilter);
        /**
         * 设置描边的粗细，单位:像素px
         * 注意:当setStrokeWidth(0)的时候描边的宽度并不为0而是占一个像素
         */
        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(AppUtils.getScreenWidth() / 2, AppUtils.getScreenHeight() / 2, radius, mPaint);
    }
}
