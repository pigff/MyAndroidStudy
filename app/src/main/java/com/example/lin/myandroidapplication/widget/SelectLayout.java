package com.example.lin.myandroidapplication.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lin.myandroidapplication.R;

import java.util.List;

/**
 * Created by Administrator on 2017/4/22.
 */

public class SelectLayout extends LinearLayout {

    int defColor = 0xffffffff;
    int defBackColor = 0xffffffff;
    private int tabTextSize;
    private int selectColor;
    private int unSelectColor;
    private int underlineColor;
    private int backgroudColor;
    private LinearLayout mLinearLayout;
    private int currentPosition = -1;

    public SelectLayout(Context context) {
        super(context);
    }

    public SelectLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SelectLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);

        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.SelectLayout);
        unSelectColor = a.getColor(R.styleable.SelectLayout_unselectColor, defColor);
        selectColor = a.getColor(R.styleable.SelectLayout_selectColor, defColor);
        underlineColor = a.getColor(R.styleable.SelectLayout_underlineColor, defColor);
        backgroudColor = a.getColor(R.styleable.SelectLayout_backgroudColor, defBackColor);
        tabTextSize = a.getDimensionPixelSize(R.styleable.SelectLayout_tabTextSize, (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));

        a.recycle();
        mLinearLayout = new LinearLayout(getContext());
        mLinearLayout.setGravity(Gravity.CENTER);
        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLinearLayout.setBackgroundColor(backgroudColor);
        mLinearLayout.setLayoutParams(params);
        mLinearLayout.setOrientation(HORIZONTAL);
        addView(mLinearLayout, 0);

        View underLine = new View(getContext());
        underLine.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dpTpPx(0.5f)));
        underLine.setBackgroundColor(underlineColor);
        addView(underLine, 1);
    }

    public void addTab(List<String> text) {
        for (int i = 0; i < text.size(); i++) {
            TextView tab = new TextView(getContext());
            tab.setSingleLine();
            tab.setEllipsize(TextUtils.TruncateAt.END);
            tab.setGravity(Gravity.CENTER);
            tab.setTextSize(TypedValue.COMPLEX_UNIT_PX, tabTextSize);
            tab.setLayoutParams(new LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1.0f));
            tab.setText(text.get(i));
            tab.setTextColor(unSelectColor);
            tab.setPadding(dpTpPx(5), dpTpPx(12), dpTpPx(5), dpTpPx(12));
            tab.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View view) {
                    switchTab(view);
                }
            });
            mLinearLayout.addView(tab);
            if (i < text.size() - 1) {
                View view = new View(getContext());
                LayoutParams params = new LayoutParams(dpTpPx(0.5f), dpTpPx(15.0f));
                view.setLayoutParams(params);
                view.setBackgroundColor(underlineColor);
                mLinearLayout.addView(view);
            }
        }
    }

    private void switchTab(View view) {
        for (int i = 0; i < mLinearLayout.getChildCount(); i += 2) {
            if (mLinearLayout.getChildAt(i) == view) {
                if (currentPosition != i) {
                    if (currentPosition == -1) {
                        ((TextView) mLinearLayout.getChildAt(i)).setTextColor(selectColor);
                    } else {
                        ((TextView) mLinearLayout.getChildAt(currentPosition)).setTextColor(unSelectColor);
                        ((TextView) mLinearLayout.getChildAt(i)).setTextColor(selectColor);
                    }
                    currentPosition = i;
                    if (mSelectClickListener != null) {
                        mSelectClickListener.click(currentPosition / 2);
                    }
                }
            }
        }
    }

    public int dpTpPx(float value) {
        DisplayMetrics dm = getResources().getDisplayMetrics();
        return (int) (TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, dm) + 0.5);
    }


    public interface SelectClickListener {
        void click(int position);
    }

    public void setItemClick(SelectClickListener selectClickListener) {
        mSelectClickListener = selectClickListener;
    }

    private SelectClickListener mSelectClickListener;
}
