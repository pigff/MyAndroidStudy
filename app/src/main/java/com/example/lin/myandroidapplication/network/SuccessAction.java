package com.example.lin.myandroidapplication.network;

import com.example.lin.myandroidapplication.data.net.BaseBean;

import rx.functions.Action1;

/**
 * Created by lin on 2017/2/22.
 */
public abstract class SuccessAction<T extends BaseBean> implements Action1<T> {


    @Override
    public void call(T t) {
        t.getMsg();
        success(t);
    }

    public abstract void success(T t);
}
