package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by greedy on 2017/4/8.
 */

public class TouchDrawView extends View {

    private Path mPath;
    private Paint mPaint;
    private float mPreX, mPreY;

    public TouchDrawView(Context context) {
        this(context, null);
    }

    public TouchDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPath = new Path();
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(10);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            /**
             * return true表示当前控件已经消费了下按动作，之后的ACTION_MOVE、ACTION_UP动画也会继续传递到当前控件中
             * (mPreX, mPreY)是作为控制点
             * 使用quadTo实现的曲线比lineTo实现的曲线更顺滑
             */
            case MotionEvent.ACTION_DOWN:
                mPath.moveTo(event.getX(), event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                return true;
            /**
             * Invalidate()一定要在UI线程执行，POSTInvalidat()实际上是用handler给主线程发消息去刷新UI
             * quadTo(float x1, float y1, float x2, float y2)
             * 一个控制点 一个终点  终点即是下一个点的起始点
             */
            case MotionEvent.ACTION_MOVE:
//                mPath.lineTo(event.getX(), event.getY());
                float endX = (mPreX + event.getX()) / 2;
                float endY = (mPreY + event.getY()) / 2;
                mPath.quadTo(mPreX, mPreY, endX, endY);
                mPreX = event.getX();
                mPreY = event.getY();
                invalidate();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawPath(mPath, mPaint);
    }

    public void reset() {
        mPath.reset();
        invalidate();
    }
}
