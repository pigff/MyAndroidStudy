package com.example.lin.myandroidapplication.view;

import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;

/**
 * Created by lin on 2016/11/16.
 */
public class MyWebView extends WebView {

    public MyWebView(Context context) {
        super(context);
    }

    public MyWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyWebView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if (mOnScrollChangeCallback != null) {
            mOnScrollChangeCallback.onScroll(l - oldl, t - oldt);
        }
    }

    private OnScrollChangeCallback mOnScrollChangeCallback;
    public void setOnScrollChangeCallback(OnScrollChangeCallback callback) {
        this.mOnScrollChangeCallback = callback;
    }

    public interface OnScrollChangeCallback {
        public void onScroll(int dx, int dy);
    }
}
