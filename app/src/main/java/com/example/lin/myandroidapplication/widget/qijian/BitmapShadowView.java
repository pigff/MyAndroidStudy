package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.content.res.TypedArray;
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

public class BitmapShadowView extends View {

    private Paint mPaint;
    private Bitmap mBmp, mShadowBmp;
    private int mDx = 10, mDy = 10;
    private float mRadius = 0;
    private int mShadowColor;
    private int mBitmapId;
    private BlurMaskFilter mBlurMaskFilter;

    public BitmapShadowView(Context context) {
        this(context, null);
    }

    public BitmapShadowView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BitmapShadowView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        //提取属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.BitmapShadowView);
        int count = typedArray.getIndexCount();
        for (int i = 0; i < count; i++) {
            int index = typedArray.getIndex(i);
            switch (index) {
                case R.styleable.BitmapShadowView_shadowColor:
                    mShadowColor = typedArray.getColor(index, Color.RED);
                    break;
                case R.styleable.BitmapShadowView_shadowDx:
                    mDx = typedArray.getInt(index, 0);
                    break;
                case R.styleable.BitmapShadowView_shadowDy:
                    mDy = typedArray.getInt(index, 0);
                    break;
                case R.styleable.BitmapShadowView_shadowRadius:
                    mRadius = typedArray.getFloat(index, 0);
                    break;
                case R.styleable.BitmapShadowView_src:
                    mBitmapId = typedArray.getResourceId(index, -1);
                    if (mBitmapId == -1) {
                        try {
                            throw new Exception("BitmapShadowView需要定义Src属性，而且必须是图像");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        typedArray.recycle();

        mBmp = BitmapFactory.decodeResource(getResources(), mBitmapId);
        mPaint = new Paint();
        mShadowBmp = mBmp.extractAlpha();
        mBlurMaskFilter = new BlurMaskFilter(mRadius, BlurMaskFilter.Blur.NORMAL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() - mDx;
        int height = width * mBmp.getHeight() / mBmp.getWidth();
        //绘制阴影
        mPaint.setColor(mShadowColor);
        mPaint.setMaskFilter(mBlurMaskFilter);
        canvas.drawBitmap(mShadowBmp, null, new Rect(mDx, mDy, width, height), mPaint);

        //绘制原图像
        mPaint.setMaskFilter(null);
        canvas.drawBitmap(mBmp, null, new Rect(0,0, getWidth(), getHeight()), mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        int width = mBmp.getWidth();
        int height = mBmp.getHeight();
        setMeasuredDimension((measureWidthMode == MeasureSpec.EXACTLY) ? measureWidth : width,
                (measureHeightMode == MeasureSpec.EXACTLY) ? measureHeight : height);
    }
}
