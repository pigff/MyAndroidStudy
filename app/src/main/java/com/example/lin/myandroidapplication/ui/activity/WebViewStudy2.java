package com.example.lin.myandroidapplication.ui.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.widget.MyWebView;

/**
 * Created by lin on 2016/11/16.
 */
public class WebViewStudy2 extends Activity implements View.OnClickListener {

    private MyWebView mWebView;
    private TextView mTitle;
    private long exitTime = 0;
    private LinearLayout mParent;
    private LinearLayout mParent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web2_layout);

        findView();
    }

    private void findView() {
        Button button1 = (Button) findViewById(R.id.back);
        button1.setOnClickListener(this);
        Button button2 = (Button) findViewById(R.id.refresh);
        button2.setOnClickListener(this);
        Button button3 = (Button) findViewById(R.id.top_btn);
        button3.setOnClickListener(this);
        mParent2 = (LinearLayout) findViewById(R.id.web_btn_group);
        mTitle = (TextView) findViewById(R.id.title_text);
        mParent = (LinearLayout) findViewById(R.id.web2_group);
        mWebView = new MyWebView(getApplicationContext());
        mWebView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        mParent.addView(mWebView);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("http://www.baidu.com/");
        mWebView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                mTitle.setText(title);
            }
        });

        mWebView.setOnScrollChangeCallback(new MyWebView.OnScrollChangeCallback() {
            @Override
            public void onScroll(int dx, int dy) {
                if (dy > 0) {
                    mParent2.setVisibility(View.GONE);
                } else {
                    mParent2.setVisibility(View.VISIBLE);
                }
            }
        });
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.refresh:
                mWebView.reload();
                break;
            case R.id.top_btn:
                mWebView.setScrollY(0);
                mParent2.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            if ((System.currentTimeMillis() - exitTime) > 2000) {
                Toast.makeText(this, R.string.log_out_notice, Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
            }
        }
    }
}
