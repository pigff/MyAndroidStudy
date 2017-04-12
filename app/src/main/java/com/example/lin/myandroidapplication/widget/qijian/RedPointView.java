package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.AnimationDrawable;
import android.support.annotation.AttrRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 2017/4/11.
 */

public class RedPointView extends FrameLayout {

    private PointF mStartPoint, mCurPoint;
    private static final float DEFAULT_RADIUS = 50;
    private float mRadius = DEFAULT_RADIUS;
    private Paint mPaint;
    private Path mPath;
    private boolean mTouch;

    private TextView mTipTextView;
    private ImageView mExploredImageView;
    private boolean mIsAnimStatr;

    public RedPointView(@NonNull Context context) {
        this(context, null);
    }

    public RedPointView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RedPointView(@NonNull Context context, @Nullable AttributeSet attrs, @AttrRes int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.saveLayer(0, 0, getWidth(), getHeight(), mPaint, Canvas.ALL_SAVE_FLAG);
        if (!mTouch || mIsAnimStatr) {
            mTipTextView.setX(mStartPoint.x - mTipTextView.getWidth() / 2);
            mTipTextView.setY(mStartPoint.y - mTipTextView.getHeight() / 2);
        } else {
            calculatePath();
            canvas.drawCircle(mStartPoint.x, mStartPoint.y, mRadius, mPaint);
            canvas.drawCircle(mCurPoint.x, mCurPoint.y, mRadius, mPaint);
            canvas.drawPath(mPath, mPaint);
            mTipTextView.setX(mCurPoint.x - mTipTextView.getWidth() / 2);
            mTipTextView.setY(mCurPoint.y - mTipTextView.getHeight() / 2);
        }
        canvas.restore();
        //作用是画出子控件
        super.dispatchDraw(canvas);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //判断触摸点是否在TipImageView中
                Rect rect = new Rect();
                int[] location = new int[2];
                //功能时获取当前控件所在屏幕的位置，传进去一个location的数组，
                //在执行之后会把left，top赋值给location[0]和location[1]
                mTipTextView.getLocationOnScreen(location);
                rect.left = location[0];
                rect.top = location[1];
                rect.right = mTipTextView.getWidth() + location[0];
                rect.bottom = mTipTextView.getHeight() + location[1];
                if (rect.contains((int) event.getRawX(), (int) event.getRawY())) {
                    mTouch = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                mTouch = false;
                break;
        }
        mCurPoint.set(event.getX(), event.getY());
        postInvalidate();
        return true;
    }

    private void init() {
        mStartPoint = new PointF(100, 100);
        mCurPoint = new PointF();
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPath = new Path();

        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        mTipTextView = new TextView(getContext());
        mTipTextView.setLayoutParams(params);
        mTipTextView.setPadding(10, 10, 10, 10);
        mTipTextView.setBackgroundResource(R.drawable.tv_bg);
        mTipTextView.setTextColor(Color.GREEN);
        mTipTextView.setText("99+");

        mExploredImageView = new ImageView(getContext());
        mExploredImageView.setLayoutParams(params);
        mExploredImageView.setImageResource(R.drawable.explore);
        mExploredImageView.setVisibility(INVISIBLE);
        addView(mExploredImageView);
        addView(mTipTextView);
    }

    private void calculatePath() {
        float x = mCurPoint.x;
        float y = mCurPoint.y;
        float startX = mStartPoint.x;
        float startY = mStartPoint.y;
        // 根据角度算出四边形的四个点
        float dx = x - startX;
        float dy = y - startY;
        double a = Math.atan(dy / dx);
        float offsetX = (float) (mRadius * Math.sin(a));
        float offsetY = (float) (mRadius * Math.cos(a));

        float distance = (float) Math.sqrt(Math.pow(y - startY, 2) + Math.pow(x - startX, 2));
        mRadius = DEFAULT_RADIUS - distance / 15;
        if (mRadius < 9) {
//            mRadius = 9;
            mIsAnimStatr = true;
            mExploredImageView.setX(mCurPoint.x - mTipTextView.getWidth() / 2);
            mExploredImageView.setY(mCurPoint.y - mTipTextView.getHeight() / 2);
            mExploredImageView.setVisibility(VISIBLE);
            ((AnimationDrawable) mExploredImageView.getDrawable()).start();
            mTipTextView.setVisibility(GONE);
        }
        float x1 = startX + offsetX;
        float y1 = startY - offsetY;

        float x2 = x + offsetX;
        float y2 = y - offsetY;

        float x3 = x - offsetX;
        float y3 = y + offsetY;

        float x4 = startX - offsetX;
        float y4 = startY + offsetY;

        float anchorX = (startX + x) / 2;
        float anchorY = (startY + y) / 2;
        mPath.reset();
        mPath.moveTo(x1, y1);
        mPath.quadTo(anchorX, anchorY, x2, y2);
        mPath.lineTo(x3, y3);
        mPath.quadTo(anchorX, anchorY, x4, y4);
        mPath.lineTo(x1, y1);
    }
}
