package com.example.lin.myandroidapplication.widget.yang;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;

import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 17/3/27.
 */

public class CustomVolumControlBar extends View {

    private int mFirstColor;
    private int mSecondColor;
    private int mCircleWidth;
    private Paint mPaint;

    //中间进度
    private int mCurrentCount = 3;
    //中间的图片
    private Bitmap mBitmap;
    //每个块块间的间隙
    private int mSplitSize;
    //个数
    private int mCount;

    private Rect mRect;

    private int mYDown, mYUp;  // 触碰按下、抬起时的y轴坐标


    public CustomVolumControlBar(Context context) {
        this(context, null);
    }

    public CustomVolumControlBar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomVolumControlBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomVolumControlBar, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomVolumControlBar_volunmBaseColor:
                    mFirstColor = a.getColor(attr, Color.GREEN);
                    break;
                case R.styleable.CustomVolumControlBar_volunmOverColor:
                    mSecondColor = a.getColor(attr, Color.CYAN);
                    break;
                case R.styleable.CustomVolumControlBar_bg:
                    mBitmap = BitmapFactory.decodeResource(getResources(), a.getResourceId(attr, 0));
                    break;
                case R.styleable.CustomVolumControlBar_dotCount:
                    mCount = a.getInt(attr, 12);
                    break;
                case R.styleable.CustomVolumControlBar_splitSize:
                    mSplitSize = a.getInt(attr, 20);
                    break;
                case R.styleable.CustomVolumControlBar_volumCircleWidth:
                    mCircleWidth = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
                    break;
                default:
                    break;
            }
        }
        a.recycle();
        init();
    }

    private void init() {
        mPaint = new Paint();
        mRect = new Rect();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(mCircleWidth);
        mPaint.setStrokeCap(Paint.Cap.ROUND);   // 定义线段断电形状为圆头
        mPaint.setStyle(Paint.Style.STROKE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int centre = getWidth() / 2;  // 获取圆心的x坐标
        int radius = centre - mCircleWidth / 2; // 半径

        /**
         * 画外侧的线块
         */
        drawOval(canvas, centre, radius);

        /**
         * 计算内切正方形的位置
         */
        int relRadius = radius - mCircleWidth / 2; // 获取内圆的半径
        /**
         * 内切正方形距离最上方
         */
        mRect.left = (int) ((relRadius - Math.sqrt(2) * 1.0f / 2 * relRadius));
        mRect.top = (int) ((relRadius - Math.sqrt(2) * 1.0f / 2 * relRadius));
        mRect.right = (int) (mRect.left + Math.sqrt(2) * relRadius);
        mRect.top = (int) (mRect.top + Math.sqrt(2) * relRadius);

        /**
         * 如果图片比较小，那么根据图片的尺寸放置到正中心
         */
        if (mBitmap.getWidth() < Math.sqrt(2) * relRadius) {
            mRect.left = centre - mBitmap.getWidth() / 2;
            mRect.top = centre - mBitmap.getHeight() / 2;
            mRect.right = centre + mBitmap.getWidth() / 2;
            mRect.bottom = centre + mBitmap.getHeight() / 2;
        }


        /**
         *  //TODO  大图 显示不出来  感觉算错了
         */
        canvas.drawBitmap(mBitmap, null, mRect, mPaint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                mYDown = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
                mYUp = (int) event.getY();
                if (mYUp > mYDown) {
                    down();
                } else {
                    up();
                }
                break;
            default:
                break;
        }
        return true;
    }

    /**
     * 根据参数画出每个小块
     *
     * @param canvas
     * @param centre
     * @param radius
     */
    private void drawOval(Canvas canvas, int centre, int radius) {

        /**
         * 根据需要画的个数以及间隙计算每个块之间所占的比例 * 360
         */
        float itemSize = (360 * 1.0f - mCount * mSplitSize) / mCount;
        //用于定义圆弧的形状和大小的界限
        RectF oval = new RectF(centre - radius, centre - radius, centre + radius, centre + radius);
        mPaint.setColor(mFirstColor);
        for (int i = 0; i < mCount; i++) {
            canvas.drawArc(oval, i * (itemSize + mSplitSize), itemSize, false, mPaint); // 根据进度画圆弧
        }
        mPaint.setColor(mSecondColor);
        for (int i = 0; i < mCurrentCount; i++) {
            canvas.drawArc(oval, i * (itemSize + mSplitSize), itemSize, false, mPaint);
        }

    }

    public void up() {
        if (mCurrentCount == mCount) {
            return;
        }
        mCurrentCount++;
        postInvalidate();
    }

    public void down() {
        if (mCurrentCount == 0) {
            return;
        }
        mCurrentCount--;
        postInvalidate();
    }


}
