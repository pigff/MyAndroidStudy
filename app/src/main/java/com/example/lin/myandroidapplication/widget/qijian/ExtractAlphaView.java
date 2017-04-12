package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 2017/4/12.
 */

public class ExtractAlphaView extends View {

    private Bitmap mBitmap;
    private Bitmap mAlphaBmp;
    private Paint mPaint;
    private Rect mRect;
    private Rect mRect1;
    private BlurMaskFilter mBlurMaskFilter;
    private Rect mRect2;
    private Rect mRect3;

    public ExtractAlphaView(Context context) {
        this(context, null);
    }

    public ExtractAlphaView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ExtractAlphaView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.blog12);
        mAlphaBmp = mBitmap.extractAlpha();
        int width = 200;
        int height = width * mAlphaBmp.getHeight() / mAlphaBmp.getWidth();
        mRect = new Rect(0, 0, width, height);
        mRect1 = new Rect(0, height, width, height * 2);
        mRect2 = new Rect(10, 10, width, height);
        mRect3 = new Rect(10, height + 10, width, 2 * height );
        mBlurMaskFilter = new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制阴影
        mPaint.setMaskFilter(mBlurMaskFilter);
        mPaint.setColor(Color.RED);
        canvas.drawBitmap(mAlphaBmp, null, mRect2, mPaint);
        mPaint.setColor(Color.GREEN);
        canvas.drawBitmap(mAlphaBmp, null, mRect3, mPaint);

        //绘制原图像
        mPaint.setMaskFilter(null);
        canvas.drawBitmap(mBitmap, null, mRect, mPaint);
        canvas.drawBitmap(mBitmap, null, mRect1, mPaint);
    }
}
