package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by greedy on 2017/4/6.
 */

public class FlowLayout extends ViewGroup {

    private static final String TAG = "FlowLayout";

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FlowLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Log.d(TAG, "onDraw: onDraw");
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        Log.d(TAG, "dispatchDraw: dispatchDraw");
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "onMeasure: onMeasure");
        int wideMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int wideSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int lineWidth = 0; // 记录每一行的宽度
        int lineHeight = 0; // 记录每一行的高度
        int height = 0; //记录整个FlowLayout所占的高度
        int width = 0; // 记录整个FlowLayout所占宽度

        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            // 在调用child.getMeasuredWidth()、child.getMeasuredHeight()之前，一定要调用measureChild(child, widthMeasureSpec, heightMeasureSpec)
            measureChild(child, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            if (lineWidth + childWidth > wideSize) {
                //需要换行
                width = Math.max(lineWidth, childWidth);
                height += lineHeight;
                //因为由于盛不下当前控件，而将此控件调到下一行，所以讲此控件的高度和宽度初始化给lineHeight、lineWidth
                lineHeight = childHeight;
                lineWidth = childWidth;
            } else {
                //否则累加值lineWidth，lineHeight取最大高度
                lineHeight = Math.max(lineHeight, childHeight);
                lineWidth += childWidth;
            }

            if (i == count - 1) {
                height += lineHeight;
                width = Math.max(width, lineWidth);
            }
        }
        setMeasuredDimension((wideMode == MeasureSpec.EXACTLY) ? wideSize : width,
                (heightMode == MeasureSpec.EXACTLY) ? heightSize : height);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        Log.d(TAG, "onLayout: onLayout");
        int count = getChildCount();
        int lineWidth = 0; // 累加当前行的行宽
        int lineHeight = 0; // 当前行的行高
        int top = 0, left = 0;  // 当前坐标的top坐标和left坐标

        for (int i = 0; i < count; i++) {
            View child = getChildAt(i);
            MarginLayoutParams lp = (MarginLayoutParams) child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + lp.leftMargin + lp.rightMargin;
            int childHeight = child.getMeasuredHeight() + lp.topMargin + lp.bottomMargin;
            if (childWidth + lineWidth > getMeasuredWidth()) {
                //如果换行
                top += lineHeight;
                left = 0;
                lineHeight = childHeight;
                lineWidth = childWidth;
            } else {
                lineHeight = Math.max(lineHeight, childHeight);
                lineWidth += childWidth;
            }
            int lc = left + lp.leftMargin;
            int tc = top + lp.topMargin;
            int rc = lc + child.getMeasuredWidth();
            int bc = tc + child.getMeasuredHeight();
            child.layout(lc, tc, rc, bc);
            //将left置为下一子控件的起始点
            left += childWidth;
        }
    }
}
