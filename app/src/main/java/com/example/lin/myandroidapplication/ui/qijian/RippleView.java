package com.example.lin.myandroidapplication.ui.qijian;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;

/**
 * Created by greedy on 2017/4/12.
 * RadialGradient(float centerX, float centerY, float radius, int centerColor, int edgeColor, Shader.TileMode tileMode)
 * RadialGradient(float centerX, float centerY, float radius, int[] colors, float[] stops, Shader.TileMode tileMode)
 * colors与stops的数量必须保持一致，否则直接crash
 * centerX: 渐变中心点x坐标
 * centerY: 渐变中心点y坐标
 * radius: 渐变半径
 * centerColor: 渐变的起始颜色，即渐变中心点的颜色，取值类型必须是八位的0xAARRGGBB色值。透明底Alpha值不能省略，不然
 * 不会显示出颜色。
 * edgeColor: 渐变结束时的颜色，即渐变圆边缘的颜色，同样,取值类型必须是八位的0xAARRGGBB色值。
 * TileMode: 用于当控件区域大于指定渐变区域时，空白区域的颜色填充方式。
 */

public class RippleView extends AppCompatButton {

    private Paint mPaint;
    private float mX, mY;
    private int DEFAULT_RADIUS = 50;
    private int mCurRadius = 0;
    private RadialGradient mGradient;
    private ObjectAnimator mAnimator;

    public RippleView(Context context) {
        this(context, null);
    }

    public RippleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RippleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = getPaint();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mX != event.getX() || mY != event.getY()) {
            mX = event.getX();
            mY = event.getY();
            setRadius(DEFAULT_RADIUS);
        }
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            return true;
        }
        if (event.getAction() == MotionEvent.ACTION_UP) {
            if (mAnimator != null && mAnimator.isRunning()) {
                mAnimator.cancel();
            }
            if (mAnimator == null) {
                mAnimator = ObjectAnimator.ofInt(this, "radius", DEFAULT_RADIUS, getWidth());
            }
            mAnimator.setDuration(5000);
            mAnimator.setInterpolator(new AccelerateInterpolator());
            mAnimator.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {

                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    setRadius(0);
                }

                @Override
                public void onAnimationCancel(Animator animation) {

                }

                @Override
                public void onAnimationRepeat(Animator animation) {

                }
            });
            mAnimator.start();
        }
        return super.onTouchEvent(event);
    }

    public void setRadius(int radius) {
        mCurRadius = radius;
        if (mCurRadius > 0) {
            mGradient = new RadialGradient(mX, mY, mCurRadius, 0x00FFFFFF, 0xFF58FAAC, Shader.TileMode.CLAMP);
            mPaint.setShader(mGradient);
        }
        postInvalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mX, mY, mCurRadius, mPaint);
    }
}
