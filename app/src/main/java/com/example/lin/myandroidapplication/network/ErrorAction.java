package com.example.lin.myandroidapplication.network;

import rx.functions.Action1;

/**
 * Created by lin on 2017/2/22.
 */
public abstract class ErrorAction implements Action1<Throwable> {
    @Override
    public void call(Throwable throwable) {
        error(throwable);
    }

    public abstract void error(Throwable throwable);
}
