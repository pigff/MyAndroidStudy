package com.example.lin.myandroidapplication.data.net;

import java.io.Serializable;

/**
 * Created by lin on 2016/12/30.
 */
public class BaseBean<T> implements Serializable {

    protected String code;
    protected String msg;
    protected T t;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "t=" + t +
                ", msg='" + msg + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
