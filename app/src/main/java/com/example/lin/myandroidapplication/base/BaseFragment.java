package com.example.lin.myandroidapplication.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by greedy on 17/3/15.
 */

public abstract class BaseFragment extends Fragment implements BaseFunIml {

    protected View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = getFragmentView(inflater, container);
        init();
        return mView;
    }

    private void init() {
        initData();
        initAdapter();
        initView();
        initListener();
    }

    protected abstract View getFragmentView(LayoutInflater inflater, ViewGroup container);

    protected void openActivity(Class<?> clazz) {
        Intent intent = new Intent(getActivity(), clazz);
        startActivity(intent);
    }

    protected void showShorToast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_SHORT).show();
    }

    protected void showLongToast(String content) {
        Toast.makeText(getActivity(), content, Toast.LENGTH_LONG).show();
    }
}
