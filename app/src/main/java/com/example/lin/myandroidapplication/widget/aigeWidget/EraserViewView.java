package com.example.lin.myandroidapplication.widget.aigeWidget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.util.AppUtils;

/**
 * Created by greedy on 17/3/14.
 */

public class EraserViewView extends View {

    private static final int MIN_MOVE_DIS = 5; // 最小的移动距离：如果我们手指在屏幕上的移动距离小于此值则不会绘制。

    private Bitmap mFgBitmap, mBgBigmap;  // 前景橡皮擦的Bitmap和背景我们底图的Bitmap

    private Canvas mCanvas; // 绘制橡皮擦路径的画布
    private Paint mPaint; // 橡皮擦路径画笔
    private Path mPath; // 橡皮擦绘制路径

    private int mScreenW, mScreenH;  // 屏幕宽高
    private float preX, preY; // 记录上一个触摸事件的位置坐标

    public EraserViewView(Context context, AttributeSet attrs) {
        super(context, attrs);
        cal(context);

        init(context);
    }

    private void init(Context context) {
        // 实例化路径对象
        mPath = new Path();

        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);

        mPaint.setARGB(128, 255, 0, 0);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        mPaint.setStyle(Paint.Style.STROKE);
        //设置路径结合处样式
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        //设置笔触类型
        mPaint.setStrokeCap(Paint.Cap.ROUND);
        mPaint.setStrokeWidth(50);

        //生成前景图Bitmap
        mFgBitmap = Bitmap.createBitmap(mScreenW, mScreenH, Bitmap.Config.ARGB_8888);
        //将其注入画布
        mCanvas = new Canvas(mFgBitmap);
        //绘制画布背景为中性灰
        mCanvas.drawColor(0xFF808080);
        //获取背景底图Bitmap
        mBgBigmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.test_img);
        //缩放背景底图Bitmap至屏幕大小
        mBgBigmap = Bitmap.createScaledBitmap(mBgBigmap, mScreenW, mScreenH, true);
    }

    private void cal(Context context) {
        mScreenH = AppUtils.getScreenHeightM();
        mScreenW = AppUtils.getScreenWidthM();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(mBgBigmap, 0, 0, null);
        canvas.drawBitmap(mFgBitmap, 0, 0, null);
        mCanvas.drawPath(mPath, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mPath.reset();
                mPath.moveTo(x, y);
                preX = x;
                preY = y;
                break;
            case MotionEvent.ACTION_MOVE:
                float dx = Math.abs(x - preX);
                float dy = Math.abs(y - preY);
                if (dx >= MIN_MOVE_DIS || dy >= MIN_MOVE_DIS) {
                    mPath.quadTo(preX, preY, (x + preX) / 2, (y + preY) / 2);
                    preX = x;
                    preY = y;
                }
                break;
        }
        invalidate();
        return true;
    }
}
