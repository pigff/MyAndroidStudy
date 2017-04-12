package com.example.lin.myandroidapplication.widget.qijian;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by greedy on 2017/4/12.
 * LinearGradient(float x0, float y0, float x1, float y1, int color0, int color1, TileMode tile)
 * (x0, y0)就是起始渐变点坐标，(x1, y1)就是结束渐变点的坐标
 * color0,起始颜色, color1终止颜色
 * LinearGradient(float x0, float y0, float x1, float y1, int colors[], float positions[], TileMode tile)
 * (x0, y0)就是起始渐变点坐标, (x1, y1)就是结束渐变点坐标
 * colors[]用于指定渐变的颜色值数组，同样，颜色值必须使用0xAARRGGBB形式的16进制表示。 表示透明度的AA一定不能少
 * positions[]与渐变的颜色相对应，取值是0-1的float类型，表示在每一个颜色在整条渐变线中的百分比位置
 * colors和positions的个数一定要相等
 */

public class ShimmerTextView extends AppCompatTextView {

    private Paint mPaint;
    private int mDx;
    private LinearGradient mLinearGradient;

    public ShimmerTextView(Context context) {
        this(context, null);
    }

    public ShimmerTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShimmerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = getPaint();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        ValueAnimator animator = ValueAnimator.ofInt(0, 2 * getMeasuredWidth());
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(2000);
        animator.start();

        mLinearGradient = new LinearGradient(-getMeasuredWidth(), 0, 0, 0, new int[]{
                getCurrentTextColor(), 0xff00ff00, getCurrentTextColor()
        }, new float[]{0, 0.5f, 1}, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Matrix matrix = new Matrix();
        matrix.setTranslate(mDx, 0);
        mLinearGradient.setLocalMatrix(matrix);
        mPaint.setShader(mLinearGradient);
        super.onDraw(canvas);
    }
}
