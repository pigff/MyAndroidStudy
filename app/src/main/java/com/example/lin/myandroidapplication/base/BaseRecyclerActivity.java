package com.example.lin.myandroidapplication.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.data.ActivityData;
import com.example.lin.myandroidapplication.ui.aige.AigeViewListActivity;

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
        mRecyclerView.addOnItemTouchListener(new OnItemChildClickListener() {
            @Override
            public void onSimpleItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                ActivityData item = (ActivityData) baseQuickAdapter.getItem(position);
                switch (view.getId()) {
                    case R.id.rv_card_title:
                        Intent intent = new Intent(BaseRecyclerActivity.this, item.getClassName());
                        startActivity(intent);
                        break;
                    case R.id.rv_card_des:
                        new AlertDialog.Builder(BaseRecyclerActivity.this)
                                .setTitle(item.getName())
                                .setView(getDialogView(item.getDescription()))
                                .show();
                        break;
                }
            }
        });
    }

    protected abstract BaseQuickAdapter<T, BaseViewHolder> getAdapter();
    protected abstract void getData();
    protected abstract String getToolbarTitle();
    protected abstract View getDialogView(String des);
}
