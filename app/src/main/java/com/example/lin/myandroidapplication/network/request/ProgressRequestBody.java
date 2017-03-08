package com.example.lin.myandroidapplication.network.request;

import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Sink;

/**
 * Created by lin on 2017/3/3.
 * 包装的请求体，处理进度
 */

public class ProgressRequestBody extends RequestBody {
    //实际的待包装请求体
    private final RequestBody mRequestBody;
    //进度回调接口
    private final ProgressRequestListener mProgressRequestListener;
    //包装完成的BufferdSink
    private BufferedSink mBufferedSink;


    public ProgressRequestBody(RequestBody requestBody, ProgressRequestListener progressRequestListener) {
        mRequestBody = requestBody;
        mProgressRequestListener = progressRequestListener;
    }

    @Override
    public MediaType contentType() {
        return mRequestBody.contentType();
    }

    @Override
    public long contentLength() throws IOException {
        return mRequestBody.contentLength();
    }

    @Override
    public void writeTo(BufferedSink sink) throws IOException {

    }

    private Sink getSink(Sink sink) {
        return new ForwardingSink(sink) {
            //当前写入字节数
            long bytesWritten = 0L;
            //总字节长度，避免多次调用contentLength()方法
            long contentLength = 0L;
            @Override
            public void write(Buffer source, long byteCount) throws IOException {
                super.write(source, byteCount);
                if (contentLength == 0) {
                    //获得contentLength的值，后续不再调用
                    contentLength = contentLength();
                }
                bytesWritten += byteCount;
                mProgressRequestListener.onRequestProgress(bytesWritten, contentLength, bytesWritten == contentLength);
            }
        };
    }
}
