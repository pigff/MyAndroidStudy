package com.example.lin.myandroidapplication.widget.aigeWidget.fourth;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.util.AppUtils;

/**
 * Created by greedy on 17/3/18.
 */

public class ShaderView extends View {

    private static final int RECT_SIZE = 300;

    private Paint mPaint;
    private Paint mLinePaint;
    private int left, top, right, bottom;  //  矩形左上右下坐标

    public ShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initRes();
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        //获取位图
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.img_pic);

        //设置着色器
//        mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
//        mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
//        mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
//        mPaint.setShader(new LinearGradient(left, top, right, bottom, Color.RED, Color.YELLOW, Shader.TileMode.REPEAT));
//        mPaint.setShader(new LinearGradient(left, top, right, bottom,
//                new int[]{Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE},
//                new float[]{0, 0.1F, 0.5F, 0.7F, 0.8F},
//                Shader.TileMode.MIRROR));
        mPaint.setShader(new LinearGradient(left, top, right, bottom,
                new int[]{Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE},
                null, Shader.TileMode.MIRROR));
//        mPaint.setShader(new LinearGradient(left, top, right - RECT_SIZE, bottom - RECT_SIZE, Color.RED, Color.YELLOW, Shader.TileMode.REPEAT));
        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setColor(Color.RED);
    }

    private void initRes() {
        int width = AppUtils.getScreenWidthM();
        int height = AppUtils.getScreenHeightM();
        Log.d("ShaderView", "width:" + width);
        Log.d("ShaderView", "height:" + height);

        left = width / 2 - RECT_SIZE;
        top = height / 2 - RECT_SIZE;
        right = width / 2 + RECT_SIZE;
        bottom = height / 2 + RECT_SIZE;

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d("ShaderView", "canvas.getHeight():" + canvas.getHeight());

        Log.d("ShaderView", "canvas.getWidth():" + canvas.getWidth());
        canvas.drawRect(left, top, right, bottom, mPaint);
    }
}
