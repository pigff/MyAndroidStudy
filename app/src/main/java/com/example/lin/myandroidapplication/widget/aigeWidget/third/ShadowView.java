package com.example.lin.myandroidapplication.widget.aigeWidget.third;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.util.AppUtils;

/**
 * Created by greedy on 17/3/16.
 */

public class ShadowView extends View {

    private static final int RECT_SIZE = 200;
    private Paint mPaint;

    private int left, top, right, bottom;

    public ShadowView(Context context) {
        this(context, null);
    }

    public ShadowView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        initPaint();
        initRes();
    }

    private void initRes() {
        left = AppUtils.getScreenWidthM() / 2 - RECT_SIZE / 2;
        top = AppUtils.getScreenHeightM() / 2 - RECT_SIZE / 2;
        right = AppUtils.getScreenWidthM() / 2 + RECT_SIZE / 2;
        bottom = AppUtils.getScreenHeightM() / 2 + RECT_SIZE / 2;

    }

    private void initPaint() {
        //实例化画笔
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setShadowLayer(10, 3, 3, Color.DKGRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制位图
        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
