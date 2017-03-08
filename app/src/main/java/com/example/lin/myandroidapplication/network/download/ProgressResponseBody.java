package com.example.lin.myandroidapplication.network.download;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

/**
 * Created by lin on 2017/3/3.
 * 包装的相应体，处理进度
 */

public class ProgressResponseBody extends ResponseBody {
    //实际的待包装相应体
    private final ResponseBody mResponseBody;
    //进度回调的接口
    private final ProgressResponseListener mProgressResponseListener;
    //包装完成的BufferedSource
    private BufferedSource mBufferedSource;

    public ProgressResponseBody(ResponseBody responseBody, ProgressResponseListener progressResponseListener) {
        mResponseBody = responseBody;
        mProgressResponseListener = progressResponseListener;
    }


    @Override
    public MediaType contentType() {
        return mResponseBody.contentType();
    }

    @Override
    public long contentLength() {
        return mResponseBody.contentLength();
    }

    @Override
    public BufferedSource source() {
        if (mBufferedSource == null) {
            mBufferedSource = Okio.buffer(getSource(mResponseBody.source()));
        }
        return mBufferedSource;
    }

    /**
     * 读取，回调进度接口
     */
    private Source getSource(Source source) {
        return new ForwardingSource(source) {
            long totalBytesRead = 0L;
            @Override
            public long read(Buffer sink, long byteCount) throws IOException {
                long bytesRead = super.read(sink, byteCount);
                totalBytesRead += bytesRead != -1 ? bytesRead : 0;
                mProgressResponseListener.onResponseProgress(totalBytesRead, mResponseBody.contentLength(), bytesRead == 1);
                return bytesRead;
            }
        };
    }
}
