package com.example.lin.myandroidapplication.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.example.lin.myandroidapplication.bean.Point;
import com.example.lin.myandroidapplication.evaluator.ColorEvaluator;
import com.example.lin.myandroidapplication.evaluator.PointEvaluator;

/**
 * Created by lin on 2016/12/21.
 */
public class MyAnimView extends View {
    public static final int RADIUS = 50;

    private Point mCurrentPoint;
    private Paint mPaint;
    private int mColor;

    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mCurrentPoint == null) {
            mCurrentPoint = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        float x = mCurrentPoint.getX();
        float y = mCurrentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }


    public void startAnimation() {
        Point startPoint = new Point(getWidth() / 2, RADIUS);
        Point endPoint = new Point(getWidth() / 2, getHeight() - RADIUS);
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurrentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        ObjectAnimator animator1 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), Color.WHITE, Color.BLACK);
        AnimatorSet set = new AnimatorSet();
        set.play(animator).with(animator1);
        set.setInterpolator(new BounceInterpolator());
        set.setDuration(5000);
        set.start();
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
        mPaint.setColor(mColor);
        invalidate();
    }
}
