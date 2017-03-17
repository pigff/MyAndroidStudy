package com.example.lin.myandroidapplication.realm;

import java.util.List;

import io.realm.RealmObject;

/**
 * Created by greedy on 17/3/17.
 */

public interface ResultCallBack<T extends RealmObject> extends CallBack{
    void execute(List<T> list);
    void success();
    void error();
}
