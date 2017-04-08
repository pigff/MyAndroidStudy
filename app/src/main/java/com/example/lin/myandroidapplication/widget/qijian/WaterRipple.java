package com.example.lin.myandroidapplication.widget.qijian;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created by greedy on 2017/4/8.
 * rQuadTo(float dx1, float dy1, float dx2, float y2)
 * dx1：控制点X坐标，表示相对上一个终点X坐标的位移坐标，可为负值，正值表示相加，负值表示相减
 * dy1：控制点Y坐标，表示相对上一个终点Y坐标的位移坐标， ----  同上 -----
 * dx2：终点X坐标， ----  同dx1 ----
 * dy2：终点Y坐标， ----  同dy1 ----
 */

public class WaterRipple extends View {

    private Path mPath;
    private Paint mPaint;
    private int mItemWaveLength;
    private int dx;

    public WaterRipple(Context context) {
        this(context, null);
    }

    public WaterRipple(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public WaterRipple(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
        mPath = new Path();
        mItemWaveLength = 400;
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPath.reset();
        int originY = 300;
        int halfWaveLen = mItemWaveLength / 2;
        //画正弦线
        mPath.moveTo(-mItemWaveLength + dx, originY);
        for (int i = -mItemWaveLength; i < getWidth() + mItemWaveLength; i += mItemWaveLength) {
            mPath.rQuadTo(halfWaveLen / 2, -100, halfWaveLen, 0);
            mPath.rQuadTo(halfWaveLen / 2, 100, halfWaveLen, 0);
        }
        //将正弦线下方的所有空间填充
        mPath.lineTo(getWidth(), getHeight());
        mPath.lineTo(0, getHeight());
        mPath.close();
        canvas.drawPath(mPath, mPaint);
    }

    public void startAnim() {
        ValueAnimator animator = ValueAnimator.ofInt(0, mItemWaveLength);
        animator.setDuration(2000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.start();
    }
}
