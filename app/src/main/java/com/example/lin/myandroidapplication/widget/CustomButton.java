package com.example.lin.myandroidapplication.widget;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.ImageButton;

import com.example.lin.myandroidapplication.R;

/**
 * Created by lin on 2016/10/26.
 */
public class CustomButton extends ImageButton {

    public static final int INVALLDATE_DURATION = 15;  //每次刷新的时间间隔
    public static  int DIFFUSE_GAP = 10;          //扩散半径增量
    private static int TAP_TIMEOUT;                     //判断点击和长按时间

    private int viewWidth, viewHeight;                  //控件宽高
    private int pointX, pointY;                         //控件原点坐标(左上角)
    private int maxRadio;                               //扩散的最大半径
    private int shaderRadio;                            //扩散的半径

    private Paint bottomPaint, colorPaint;                  //画笔:背景和水波纹
    private boolean isPushButton;                       //记录按钮是否被按下

    private int eventX, eventY;                     //触摸位置的X,Y坐标
    private long downTime = 0;                      //按下的时间


    public CustomButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        TAP_TIMEOUT = ViewConfiguration.getLongPressTimeout();
    }

    private void initPaint() {
        colorPaint = new Paint();
        bottomPaint = new Paint();
        colorPaint.setColor(getResources().getColor(R.color.white));
        bottomPaint.setColor(getResources().getColor(R.color.bottom_color));
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                if (downTime == 0) {
                    downTime = SystemClock.elapsedRealtime();
                }
                eventX = (int) event.getX();
                eventY = (int) event.getY();
                countMaxRadio();
                isPushButton = true;
                postInvalidateDelayed(INVALLDATE_DURATION);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                if (SystemClock.elapsedRealtime() - downTime < TAP_TIMEOUT) {
                    DIFFUSE_GAP = 30;
                    postInvalidate();
                } else {
                    clearData();
                }
                break;

        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (!isPushButton) {
            return;
        }
        canvas.drawRect(pointX, pointY, pointX + viewWidth, pointY + viewHeight, bottomPaint);
        canvas.save();
        canvas.clipRect(pointX, pointY, pointX + viewWidth, pointY + viewHeight);
        canvas.drawCircle(eventX, eventY, shaderRadio, colorPaint);
        canvas.restore();
        if (shaderRadio < maxRadio) {
            postInvalidateDelayed(INVALLDATE_DURATION, pointX, pointY,
                    pointX + viewWidth, pointY + viewHeight);
            shaderRadio += DIFFUSE_GAP;
        } else {
            clearData();
        }
    }

    private void countMaxRadio() {
        if (viewWidth < viewHeight) {
            if (eventX < viewWidth / 2) {
                maxRadio = viewWidth - eventX;
            } else {
                maxRadio = viewWidth / 2 + eventX;
            }
        } else {
            if (eventY < viewHeight / 2) {
                maxRadio = viewHeight - eventY;
            } else {
                maxRadio = viewHeight / 2 +eventY;
            }
        }
    }

    private void clearData() {
        downTime = 0;
        DIFFUSE_GAP = 10;
        isPushButton = false;
        shaderRadio = 0;
        postInvalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.viewWidth = w;
        this.viewHeight = h;
    }
}
