package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by greedy on 2017/4/7.
 */

public class CanvasView extends View {

    private Paint mPaint;
    private Rect mRect;

    public CanvasView(Context context) {
        this(context, null);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL);
        mRect = new Rect(0, 0, 400, 220);
    }

    @Override
    protected void onDraw(Canvas canvas) {
//        canvas.drawRect(mRect, mPaint);
////        canvas.translate(200, 200);     //位移
////        canvas.rotate(30);            //旋转
//        canvas.scale(0.5f, 1);          //缩放
////        canvas.skew(1.732f, 0);            //扭曲
////        canvas.clipPath()         //clip系列  -- 裁剪
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(mRect, mPaint);

        canvas.drawColor(Color.RED);
        //保存的画布大小为全屏幕大小
        canvas.save();
        canvas.clipRect(new Rect(100, 100, 800, 800));
        canvas.drawColor(Color.GREEN);
        //保存的画布大小为Rect(100, 100, 800, 800)
        canvas.save();
        canvas.clipRect(new Rect(200, 200, 700, 700));
        canvas.drawColor(Color.BLUE);
        canvas.save();
        canvas.clipRect(new Rect(300, 300, 600, 600));
        canvas.drawColor(Color.BLACK);
        canvas.save();

        canvas.clipRect(new Rect(400, 400, 500, 500));
        canvas.drawColor(Color.WHITE);
        //画布的保存模式  参考堆栈
    }
}
