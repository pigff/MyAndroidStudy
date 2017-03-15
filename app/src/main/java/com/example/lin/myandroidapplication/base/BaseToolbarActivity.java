package com.example.lin.myandroidapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.Toolbar;

import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 17/3/15.
 */

public abstract class BaseToolbarActivity extends BaseActivity {

    protected AppBarLayout mAppBarLayout;
    protected Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(provideView());
        mAppBarLayout = (AppBarLayout) findViewById(R.id.custom_appbar);
        mToolbar = (Toolbar) findViewById(R.id.custom_toolbar);
        if (mAppBarLayout == null || mToolbar == null) {
            throw new IllegalStateException("The subclass of ToolbarActivity must contain a toolbar.");
        }
        init();
    }

    private void init() {
        initData();
        initAdapter();
        initView();
        initListener();
    }

    protected abstract int provideView();

}
