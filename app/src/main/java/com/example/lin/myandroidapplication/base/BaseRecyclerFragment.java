package com.example.lin.myandroidapplication.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 17/3/15.
 */

public abstract class BaseRecyclerFragment<T> extends BaseFragment {

    protected BaseQuickAdapter<T, BaseViewHolder> mAdapter;
    protected RecyclerView mRecyclerView;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getData();
    }

    @Override
    protected View getFragmentView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_custom_recycler, container, false);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initAdapter() {
        mAdapter = getRecyclerAdapter();
    }

    @Override
    public void initView() {
        mRecyclerView = (RecyclerView) mView.findViewById(R.id.rv_custom_fragment);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void initListener() {

    }

    protected abstract BaseQuickAdapter<T, BaseViewHolder> getRecyclerAdapter();
    protected abstract void getData();
}
