package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.SumPathEffect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by greedy on 2017/4/7.
 * 进阶的有关Paint的方法
 * setStrokeCap(Paint.Cap cap) 设置线冒样式，
 * 取值有Cap.Round(圆形线冒)、Cap.SQUARE(方形线冒)、Paint.Cap.BUTT(无线冒)
 * setStrokeJoin(Paint.Join join) 设置线段连接处样式
 * 取值有Join.MITER(结合处为锐角)、Join.Round(结合处为圆弧)、Join.BEVEL(结合处为直线)
 * setStrokeMiter(float miter)
 * 设置画笔的倾斜度(作者说貌似没用)
 * setPathEffect(PathEffect effect) 设置路径样式
 * 取值分别是所有派生自PathEffect的子类(可以结合爱神的复习)
 */

public class PaintAdvancedView extends View {

    private Paint mPaint;
    private Path mPath;
    private Path mStampPath;

    public PaintAdvancedView(Context context) {
        this(context, null);
    }

    public PaintAdvancedView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintAdvancedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(80);
        mPaint.setAntiAlias(true);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);

        mPath = new Path();
        /**
         * 配合DiscretePathEffect、SumPathEffect、ComposePathEffect生成路径
         */
        setPath();
        // 配合印章效果的路径
        mStampPath = new Path();
    }

    private void setPath() {
        mPath.moveTo(0, 0);
        for (int i = 0; i < 40; i++) {
            mPath.lineTo(i * 35, (float) (Math.random() * 150));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        /**
         * 线冒部分
         */
//        mPaint.setStrokeCap(Paint.Cap.BUTT);
//        canvas.drawLine(100, 200, 400, 200, mPaint);
//        mPaint.setStrokeCap(Paint.Cap.SQUARE);
//        canvas.drawLine(100, 400, 400, 400, mPaint);
//        mPaint.setStrokeCap(Paint.Cap.ROUND);
//        canvas.drawLine(100, 600, 400, 600, mPaint);
//
//        mPaint.reset();
//        mPaint.setStrokeWidth(2);
//        mPaint.setColor(Color.GREEN);
//        canvas.drawLine(100, 50, 100, 750, mPaint);

        /**
         * 结合处
         */
//        mPath.moveTo(100, 100);
//        mPath.lineTo(450, 100);
//        mPath.lineTo(100, 300);
//        mPaint.setStrokeJoin(Paint.Join.MITER);
//        canvas.drawPath(mPath, mPaint);
//
//        mPath.moveTo(100, 400);
//        mPath.lineTo(450, 400);
//        mPath.lineTo(100, 650);
//        mPaint.setStrokeJoin(Paint.Join.BEVEL);
//        canvas.drawPath(mPath, mPaint);
//
//        mPath.moveTo(100, 700);
//        mPath.lineTo(450, 700);
//        mPath.lineTo(100, 900);
//        mPaint.setStrokeJoin(Paint.Join.ROUND);
//        canvas.drawPath(mPath, mPaint);
        /**
         * CornerPathEffect
         * 将原来Path生硬的直线拐角，变成圆形拐角
         */
//        mPath.moveTo(100, 600);
//        mPath.lineTo(400, 100);
//        mPath.lineTo(700, 900);
//        mPaint.setStrokeWidth(4);
//        canvas.drawPath(mPath, mPaint);
//        mPaint.setColor(Color.GREEN);
//        mPaint.setPathEffect(new CornerPathEffect(100));
//        canvas.drawPath(mPath, mPaint);
//
//        mPaint.setColor(Color.YELLOW);
//        mPaint.setPathEffect(new CornerPathEffect(200));
//        canvas.drawPath(mPath, mPaint);
        /**
         * DashPathEffect
         * 实现虚线段的效果
         * DashPathEffect(float intervals[], float phase)
         * intervals[] 表示组成虚线的各个线段的长度；整条虚线就是由intervals[]中这些基本线段循环组成的。
         * 长度必须大于等于2；因为必须有一个实线段和一个空线段来组成虚线
         * 个数必须为偶数，如果是基数，最后一个数组将被忽略。
         */
//        mPath.reset();
//        mPath.moveTo(200, 700);
//        mPath.lineTo(500, 200);
//        mPath.lineTo(800, 1000);
//        canvas.drawPath(mPath, mPaint);
//
//        mPaint.setColor(Color.RED);
//        mPaint.setPathEffect(new DashPathEffect(new float[]{20, 10, 100, 100}, 0));
//        canvas.translate(0, 100);
//        canvas.drawPath(mPath, mPaint);
//        mPaint.setColor(Color.GREEN);
//        mPaint.setPathEffect(new DashPathEffect(new float[]{20, 10, 50, 100}, 15));
//        canvas.translate(0, 100);
//        canvas.drawPath(mPath, mPaint);
        /**
         * DiscretePathEffect
         * 离散路径效果
         * DiscretePathEffect就是将原来的路径分隔成定长的线段，然后每条线段随机偏移一段位置。
         * DiscretePathEffect(float segmentLength, float deviation)
         * 第一个参数segmentlength：表示将原来的路径切成多长的线段
         * 第二个参数deviation: 表示被切成的每个小线段的可偏移距离。
         */
//        mPaint.setStrokeWidth(2);
//        canvas.drawPath(mPath, mPaint);
//        canvas.translate(0, 200);
//        mPaint.setPathEffect(new DiscretePathEffect(2, 5));
//        canvas.drawPath(mPath, mPaint);
//        canvas.translate(0, 200);
//        mPaint.setPathEffect(new DiscretePathEffect(6, 5));
//        canvas.drawPath(mPath, mPaint);
//        canvas.translate(0, 200);
//        mPaint.setPathEffect(new DiscretePathEffect(6, 15));
//        canvas.drawPath(mPath, mPaint);
        /**
         * PathDashPathEffect
         * 印章路径效果
         * PathDashPathEffect(Path shape, float advance, float phase, Style style)
         * Path shape:表示印章路径。
         * float advance:表示两个印章路径间的距离
         * float phase 路径绘制偏移距离
         * Style style 表示在遇到转角时，如何操作印章以使转角平滑过渡。
         * 取值有：Style.ROTATE: 表示通过旋转印章来过渡转角
         * STYLE.MORPH: 表示通过变形印章来过渡转角
         * STYLE.TRANSLATE: 表示通过位移来过渡转角
         */
//        mPaint.setStrokeWidth(4);
//        mStampPath.moveTo(0, 20);
//        mStampPath.lineTo(10, 0);
//        mStampPath.lineTo(20, 20);
//        mStampPath.close();
//        mStampPath.addCircle(0, 0, 3, Path.Direction.CCW);
//        canvas.drawPath(mPath, mPaint);
//        canvas.translate(0, 200);
//        mPaint.setPathEffect(new PathDashPathEffect(mStampPath, 35, 0, PathDashPathEffect.Style.TRANSLATE));
//        canvas.drawPath(mPath, mPaint);
        /**
         * ComposePathEffct与SumPathEffect
         * ComposePathEffect(PathEffect outerpe, PathEffect innerpe)
         * ComposePathEffect合并两个特效是有先后顺序的，它会先将第二个参数的PathEffect innerpe的特效作用
         * 于路径上，然后再在此加了特效的路径上作用于第二个特效
         * SumPathEffect是分别对原始路径分别作用于第一个特效和第二个特效。然后再将这两条路径合并，作为结果。
         */
        mPaint.setStrokeWidth(4);
        canvas.drawPath(mPath, mPaint);
        canvas.translate(0, 200);
        CornerPathEffect cornerPathEffect = new CornerPathEffect(100);
        mPaint.setPathEffect(cornerPathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.translate(0, 200);
        DashPathEffect dashPathEffect = new DashPathEffect(new float[]{2, 5, 10, 10}, 0);
        mPaint.setPathEffect(dashPathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.translate(0, 200);
        ComposePathEffect composePathEffect = new ComposePathEffect(cornerPathEffect, dashPathEffect);
        mPaint.setPathEffect(composePathEffect);
        canvas.drawPath(mPath, mPaint);
        canvas.translate(0, 200);
        SumPathEffect sumPathEffect = new SumPathEffect(cornerPathEffect, dashPathEffect);
        mPaint.setPathEffect(sumPathEffect);
        canvas.drawPath(mPath, mPaint);
    }

}
