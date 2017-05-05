package com.example.lin.myandroidapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewConfiguration;

import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 2017/5/5.
 */

public class NewSelectLayout extends View {

    int defColor = 0xffffffff;
    int defBackColor = 0xffffffff;
    private int tabTextSize;
    private int selectColor;
    private int unSelectColor;
    private int underlineColor;
    private int backgroudColor;
    private int currentPosition = -1;
    private int mTouchSlop;
    private boolean mInTapRegion;
    private String[] mTexts;
    private Rect[] mTextBounds;
    private Rect[] mCacheBounds;
    private int mSingleChildHeight = 0;
    private int mSingleChildWidth = 0;
    private Paint mPaint;

    private Paint.FontMetrics mCachedFM;

    public NewSelectLayout(Context context) {
        super(context);
    }

    public NewSelectLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NewSelectLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SelectLayout);
        String textArray = a.getString(R.styleable.SelectLayout_texts);
        if (textArray != null) {
            mTexts = textArray.split("\\|");
            for (String s : mTexts) {
                Log.d("SelectLayout", s);
            }
        }
        unSelectColor = a.getColor(R.styleable.SelectLayout_unselectColor, defColor);
        selectColor = a.getColor(R.styleable.SelectLayout_selectColor, defColor);
        underlineColor = a.getColor(R.styleable.SelectLayout_underlineColor, defColor);
        backgroudColor = a.getColor(R.styleable.SelectLayout_backgroudColor, defBackColor);
        tabTextSize = a.getDimensionPixelSize(R.styleable.SelectLayout_tabTextSize, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));

        a.recycle();
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(tabTextSize);
        mCachedFM = mPaint.getFontMetrics();

        ViewConfiguration config = ViewConfiguration.get(context);
        int touchSlop = config.getScaledTouchSlop();
        mTouchSlop = touchSlop * touchSlop;
        mInTapRegion = false;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);

        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width = 0;
        int height = 0;

        if (mTexts != null && mTexts.length > 0) {
            if (mCacheBounds == null || mCacheBounds.length != mTexts.length) {
                mCacheBounds = new Rect[mTexts.length];
            }
            if (mTextBounds == null || mTextBounds.length != mTexts.length) {
                mTextBounds = new Rect[mTexts.length];
            }

            for (int i = 0; i < mTexts.length; i++) {
                String text = mTexts[i];

                if (text != null) {
                    if (mTextBounds[i] == null) {
                        mTextBounds[i] = new Rect();
                    }
                }
                mPaint.getTextBounds(text, 0, text.length(), mTextBounds[i]);
                if (mSingleChildWidth <= mTextBounds[i].width()) {
                    mSingleChildWidth = mTextBounds[i].width();
                }
                if (mSingleChildHeight <= mTextBounds[i].height()) {
                    mSingleChildHeight = mTextBounds[i].height();
                }
            }

            switch (widthMode) {
                case MeasureSpec.AT_MOST:
                    if (widthSize <= mSingleChildWidth * mTexts.length) {
                        mSingleChildWidth = widthSize / mTexts.length;
                        width = widthSize;
                    } else {
                        width = mSingleChildWidth * mTexts.length;
                    }
                    break;
                case MeasureSpec.EXACTLY:
                    width = widthSize;
                    break;
                case MeasureSpec.UNSPECIFIED:
                default:
                    width = mSingleChildWidth * mTexts.length;
                    break;
            }

            switch (heightMode) {
                case MeasureSpec.AT_MOST:
                    height = heightSize <= mSingleChildHeight ? heightSize : mSingleChildHeight;
                    break;
                case MeasureSpec.EXACTLY:
                    height = heightSize;
                    break;
                case MeasureSpec.UNSPECIFIED:
                default:
                    height = mSingleChildHeight;
                    break;
            }

            if (mSingleChildWidth != width / mTexts.length) {
                mSingleChildWidth = width / mTexts.length;
            }
            mSingleChildHeight = height;
            for (int i = 0; i < mTexts.length; i++) {
                if (mCacheBounds[i] == null) {
                    mCacheBounds[i] = new Rect();
                }
                mCacheBounds[i].left = i * mSingleChildWidth;
                mCacheBounds[i].top = 0;

                mCacheBounds[i].right = mCacheBounds[i].left + mSingleChildWidth;
                mCacheBounds[i].bottom = mCacheBounds[i].top + mSingleChildHeight;
            }
        } else {
            width = widthMode == MeasureSpec.UNSPECIFIED ? 0 : widthSize;
            height = heightMode == MeasureSpec.UNSPECIFIED ? 0 : heightSize;
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mTexts != null && mTexts.length > 0) {
            for (int i = 0; i < mTexts.length; i++) {
                float baseline = mCacheBounds[i].top + ((mSingleChildHeight - mCachedFM.ascent + mCachedFM.descent) / 2) - mCachedFM.descent;
                canvas.drawText(mTexts[i], mCacheBounds[i].left + (mSingleChildWidth - mTextBounds[i].width()) / 2, baseline, mPaint);
            }
        }
    }
}
