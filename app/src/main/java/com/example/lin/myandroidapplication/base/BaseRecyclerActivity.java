package com.example.lin.myandroidapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 17/3/15.
 */

public abstract class BaseRecyclerActivity<T> extends BaseToolbarActivity {

    protected BaseQuickAdapter<T, BaseViewHolder> mAdapter;
    protected RecyclerView mRecyclerView;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
    }

    @Override
    protected int provideView() {
        return R.layout.activity_custom_recycler;
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAdapter() {
        mAdapter = getAdapter();
    }

    @Override
    public void initView() {
        mToolbar.setTitle(getToolbarTitle());

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_custom);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initListener() {

    }

    protected abstract BaseQuickAdapter<T, BaseViewHolder> getAdapter();
    protected abstract void getData();
    protected abstract String getToolbarTitle();
}
