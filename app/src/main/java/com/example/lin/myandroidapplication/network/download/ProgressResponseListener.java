package com.example.lin.myandroidapplication.network.download;

/**
 * Created by lin on 2017/3/3.
 */

public interface ProgressResponseListener {

    void onResponseProgress(long bytesRead, long contentLength, boolean done);

}
