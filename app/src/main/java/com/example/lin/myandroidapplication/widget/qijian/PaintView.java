package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by greedy on 2017/4/7.
 * Paint几个基本函数
 * setAntiAlias(boolean b)   抗锯齿功能
 * setColor(int color)   Color.RED  设置画笔的颜色
 * setStyle(int style)   Style.FILL   设置填充样式
 * setStrokeWidth(int width)        设置画笔宽度
 * setShadowLayer(float radius, float dx, float dy, int Color)
 * radius:阴影的倾斜度   dx:水平位移  dy:垂直位移
 * 设置阴影
 */

public class PaintView extends View {

    private Paint mPaint;

    public PaintView(Context context) {
        this(context, null);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
//        mPaint.setShadowLayer(10, 15, 15, Color.GREEN);
    }

    /**
     * 矩形工具类RectF与Rect
     * 这两个都是矩形辅助类  一个传float 一个传int  精度
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawCircle(190, 190, 140, mPaint);     //画一个圆   圆心x轴坐标 圆心y轴坐标  半径
//        canvas.drawLine(100, 100, 200, 200, mPaint);    //画一条直线  起始点坐标(x,y) 终点坐标(x,y)
//        float[] pts = {10, 10, 100, 100, 200, 200, 400, 400};
//        canvas.drawLines(pts, mPaint);      //画多条直线，原理同上 ，必须是偶数个， 奇数的话最后一个忽略
//        canvas.drawPoint(100, 100, mPaint);     //画一个点
//        float[] pts = {10, 10, 20, 20, 30, 30, 40, 40};
//        canvas.drawPoints(pts, mPaint);     //画多个点
//        float[] pts2 = {50, 50, 60, 60, 70, 70, 80, 80};
//        canvas.drawPoints(pts2, 2, 4, mPaint);      //略过2、3两点  。
        canvas.drawRect(10, 10, 100, 100, mPaint);
//        Rect rect = new Rect(230, 10, 320, 100);
        RectF rectF = new RectF(120, 10, 210, 100);
        RectF rectF2 = new RectF(230, 10, 320, 100);
        RectF rectF3 = new RectF(120, 130, 210, 220);
//        canvas.drawRect(rectF, mPaint);
//        canvas.drawRect(rect, mPaint);
//        canvas.drawRoundRect(rectF, 20, 10, mPaint); // RectF rect要画的矩形 float rx:生成圆角的椭圆的X轴半径  float ry:生成圆角的椭圆的Y轴半径
//        mPaint.setColor(Color.GREEN);
        canvas.drawOval(rectF, mPaint);
        canvas.drawRect(rectF2, mPaint);
        canvas.drawArc(rectF2, 0, 90, true, mPaint); // float startAngle 弧开始的角度  float sweepAngle 弧持续的角度 boolean useCenter 是否有弧的两边 false 只有一条弧
        mPaint.setColor(Color.BLACK);
        canvas.drawArc(rectF3, 0, 90, false, mPaint);
    }
}
