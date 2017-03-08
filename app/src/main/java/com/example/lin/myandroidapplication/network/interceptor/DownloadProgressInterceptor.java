package com.example.lin.myandroidapplication.network.interceptor;

import com.example.lin.myandroidapplication.network.download.ProgressResponseBody;
import com.example.lin.myandroidapplication.network.download.ProgressResponseListener;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Response;

/**
 * Created by lin on 2017/3/3.
 */

public class DownloadProgressInterceptor implements Interceptor {

    private ProgressResponseListener mDownloadListener;
    public DownloadProgressInterceptor(ProgressResponseListener downloadListener) {
        mDownloadListener = downloadListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());
        return response.newBuilder()
                .body(new ProgressResponseBody(response.body(), mDownloadListener))
                .build();
    }
}
