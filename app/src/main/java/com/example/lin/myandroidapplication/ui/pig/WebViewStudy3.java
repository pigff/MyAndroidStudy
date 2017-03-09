package com.example.lin.myandroidapplication.ui.pig;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.LinearLayout;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.util.MyObject;

/**
 * Created by lin on 2016/11/16.
 */
public class WebViewStudy3 extends Activity{

    private WebView mWebView;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web3_layout);
        mWebView = new WebView(getApplicationContext());
        mWebView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        LinearLayout parent = (LinearLayout) findViewById(R.id.web3_group);
        parent.addView(mWebView);
        mWebView.loadUrl("file:///android_asset/demo1.html");
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDefaultTextEncodingName("UTF-8");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mWebView.setWebChromeClient(new WebChromeClient());
        mWebView.addJavascriptInterface(new MyObject(WebViewStudy3.this), "myObj");
    }
}
