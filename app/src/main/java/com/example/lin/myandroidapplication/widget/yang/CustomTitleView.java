package com.example.lin.myandroidapplication.widget.yang;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.lin.myandroidapplication.R;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * Created by greedy on 17/3/23.
 */

public class CustomTitleView extends View {

    private String mTitleText;

    private int mTitleTextColor;

    private int mTitleTextSize;

    /**
     * 绘制时控制文本绘制的范围
     *
     * @param context
     */
    private Rect mBound;
    private Paint mPaint;

    public CustomTitleView(Context context) {
        this(context, null);
    }

    public CustomTitleView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        /**
         * 获取自定义样式属性
         */
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomTitleView, defStyleAttr, 0);
        int n = a.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = a.getIndex(i);
            switch (attr) {
                case R.styleable.CustomTitleView_titleText:
                    mTitleText = a.getString(attr);
                    break;
                case R.styleable.CustomTitleView_titleTextColor:
                    //默认颜色设置为黑色
                    mTitleTextColor = a.getColor(attr, Color.BLACK);
                    break;
                case R.styleable.CustomTitleView_titleTextSize:
                    //默认设置为16sp, TypeValue也可以把sp转化为px
                    mTitleTextSize = a.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
            }

        }

        a.recycle();
        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        mPaint.setTextSize(mTitleTextSize);
//        mPaint.setColor(mTitleTextColor);
        mBound = new Rect();
        mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mTitleText = randomText();
                postInvalidate();
            }
        });
    }

    /**
     * 系统帮我们测量的高度和宽度都是MATCH_PARENT，当我们设置明确的宽度和高度时，系统帮我们测量的结果就是我们设置的结果
     * 当我们设置为WRAP_CONTENT,或者MATCH_PARENT系统帮我们测量的结果就是MATCH_PARENT的长度。
     * <p>
     * 所以，当设置为WRAP_CONTENT时，我们需要自己进行测量，即重写onMesure方法：
     * 重写之前先了解MeasureSpec的specMode，一共三种类型:
     * EXACTLY:一般是设置了明确的值或者是MATCH_PARENT
     * AT_MOST:表示子布局限制在一个最大值内，一般为WRAP_CONTENT
     * UNSPECIFIED:表示子布局想要多大就多大，很少使用
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textWidth = mBound.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {
            mPaint.setTextSize(mTitleTextSize);
            mPaint.getTextBounds(mTitleText, 0, mTitleText.length(), mBound);
            float textHeight = mBound.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);
        mPaint.setColor(mTitleTextColor);
        canvas.drawText(mTitleText, getWidth() / 2 - mBound.width() / 2, getHeight() / 2 + mBound.height() / 2, mPaint);
    }

    private String randomText() {
        Random random = new Random();
        Set<Integer> set = new HashSet<>();
        while (set.size() < 4) {
            int randomInt = random.nextInt(10);
            set.add(randomInt);
        }
        StringBuffer sb = new StringBuffer();
        for (Integer i : set) {
            sb.append("" + i);
        }
        return sb.toString();
    }
}
