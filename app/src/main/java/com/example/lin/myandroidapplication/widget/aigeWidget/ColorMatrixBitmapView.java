package com.example.lin.myandroidapplication.widget.aigeWidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.util.AppUtils;

/**
 * Created by greedy on 17/3/13.
 * ColorMatrixColorFilter bitmap
 */

public class ColorMatrixBitmapView extends View {

    private Paint mPaint;

    private Bitmap mBitmap;

    private Context mContext;

    public ColorMatrixBitmapView(Context context) {
        super(context, null);
    }

    public ColorMatrixBitmapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initPaint();
        initRes();
    }

    private void initRes() {
        mBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.test_img);
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true); //抗锯齿
        /**
         * 设置画笔样式为描边，
         *
         * 画笔样式分三种：
         * 1、Paint.Style.Stroke:描边
         * 2、Paint.Style.FILL_AND_STROKE:描边并填充
         * 3、Paint.Style.FILL:填充
         */
//
//        mPaint.setStyle(Paint.Style.FILL);
//
//        //设置画笔颜色为浅灰色
//        mPaint.setColor(Color.argb(255, 255, 128, 103));
//
        //生成色彩矩阵
//        ColorMatrixColorFilter matrixColorFilter = new ColorMatrixColorFilter(new float[] {
//                0.5f,0,0,0,0,
//                0,0.5f,0,0,0,
//                0,0,0.5f,0,0,
//                0,0,0,1,0
//        });
//        ColorMatrixColorFilter matrixColorFilter = new ColorMatrixColorFilter(new float[] {
//                -1,0,0,1,1,
//                0,-1,0,1,1,
//                0,0,-1,1,1,
//                0,0,0,1,0
//        });
        ColorMatrixColorFilter matrixColorFilter = new ColorMatrixColorFilter(new float[]{
                1.5f, 1.5f, 1.5f, 0, -1,
                1.5f, 1.5f, 1.5f, 0, -1,
                1.5f, 1.5f, 1.5f, 0, -1,
                0, 0, 0, 1, 0
        });
        mPaint.setColorFilter(matrixColorFilter);
        /**
         * 设置描边的粗细，单位:像素px
         * 注意:当setStrokeWidth(0)的时候描边的宽度并不为0而是占一个像素
         */
//        mPaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBitmap, AppUtils.getScreenWidthM() / 2 - mBitmap.getWidth() / 2,
                AppUtils.getScreenHeightM() / 2 - mBitmap.getHeight() / 2, mPaint);
    }
}
