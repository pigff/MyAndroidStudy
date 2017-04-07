package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by greedy on 2017/4/7.
 * Paint text 相关函数
 * setFakeBoldText(true);        //设置是否为粗体文字
 * setTextAlign(Paint.Align.CENTER); //设置文字对齐方式
 * setTextSize(12); 设置文字大小
 * setUnderlineText(true);       //设置下划线
 * setTextSkewX(-0.25f);        设置字体的水平倾斜度，普通斜体字是-0.25
 * setStrikeThruText(true);      //设置是否带有删除线效果
 * setTextScaleX(2)     只会讲水平方向拉伸，高度不会变
 *
 * drawText()第五篇与爱哥的类似
 */

public class PaintTextView extends View {

    private Paint mPaint;

    public PaintTextView(Context context) {
        this(context, null);
    }

    public PaintTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PaintTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setStrokeWidth(5);
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(80);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        String text = "Android自定义View学习";
//        mPaint.setStyle(Paint.Style.FILL);
//        canvas.drawText(text, 10, 100, mPaint);
//        mPaint.setStyle(Paint.Style.STROKE);
//        canvas.drawText(text, 10, 200, mPaint);
//        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
//        canvas.drawText(text, 10, 300, mPaint);
//        mPaint.setFakeBoldText(true);
//        mPaint.setUnderlineText(true);
//        mPaint.setStrikeThruText(true);
//        mPaint.setTextSkewX(-0.25f);
//        canvas.drawText(text, 10, 100, mPaint);
//        mPaint.setTextSkewX(0.25f);
//        canvas.drawText(text, 10, 200, mPaint);
        // 还有一个沿路径绘制文字。   看PathView  -
    }

}
