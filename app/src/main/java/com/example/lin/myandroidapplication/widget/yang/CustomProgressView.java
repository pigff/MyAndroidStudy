package com.example.lin.myandroidapplication.widget.yang;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 17/3/25.
 */

public class CustomProgressView extends View implements Runnable{
    //第一圈的颜色
    private int mFirstColor;
    //第二圈的颜色
    private int mSecondColor;
    //圈的宽度
    private int mCircleWidth;
    //画笔
    private Paint mPaint;
    //当前进度
    private int mProgress;
    //速度
    private int mSpeed;
    //是否应该开始下一个
    private boolean isNext;
    private RectF mRectF;
    private int mCentre;
    private int mRadius;

    public CustomProgressView(Context context) {
        this(context, null);
    }

    public CustomProgressView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomProgressBar, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomProgressBar_firstColor:
                    mFirstColor = a.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.CustomProgressBar_secondColor:
                    mSecondColor = a.getColor(attr, Color.RED);
                    break;
                case R.styleable.CustomProgressBar_circleWidth:
                    mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.CustomProgressBar_speed:
                    mSpeed = a.getInt(attr, 20);  // 默认20
                    break;
            }
        }
        a.recycle();
        init();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (true) {
//                    mProgress++;
//                    if (mProgress == 360) {
//                        mProgress = 0;
//                        if (!isNext) {
//                            isNext = true;
//                        } else {
//                            isNext = false;
//                        }
//                    }
//                    postInvalidate();
//
//                    try {
//                        Thread.sleep(mSpeed);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }

    private void init() {
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 获取圆心的x坐标
        mCentre = getWidth() / 2;
        // 半径
        mRadius = mCentre - mCircleWidth / 2;
        mRectF = new RectF(mCentre - mRadius, mCentre - mRadius, mCentre + mRadius, mCentre + mRadius);
        mPaint.setStrokeWidth(mCircleWidth);  // 设置圆环的宽度
        mPaint.setAntiAlias(true);  // 消除锯齿
        mPaint.setStyle(Paint.Style.STROKE); // 设置空心
        if (!isNext) {
            mPaint.setColor(mFirstColor);   //设置圆环的颜色
            canvas.drawCircle(mCentre, mCentre, mRadius, mPaint); // 画出圆环
            mPaint.setColor(mSecondColor);  // 设置圆弧的颜色
            canvas.drawArc(mRectF, -90, mProgress, false, mPaint);  //根据进度画圆弧
        } else {
            mPaint.setColor(mFirstColor);
            canvas.drawCircle(mCentre, mCentre, mRadius, mPaint);
            mPaint.setColor(mSecondColor);
            canvas.drawArc(mRectF, -90, mProgress, false, mPaint);
        }

    }

    @Override
    public void run() {
        while (true) {
            mProgress++;
            if (mProgress == 360) {
                mProgress = 0;
                if (!isNext) {
                    isNext = true;
                } else {
                    isNext = false;
                }
            }
            postInvalidate();

            try {
                Thread.sleep(mSpeed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
