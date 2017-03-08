package com.example.lin.myandroidapplication.network.request;

/**
 * Created by lin on 2017/3/3.
 */

public interface ProgressRequestListener {
    void onRequestProgress(long bytesWritten, long contentLength, boolean done);
}
