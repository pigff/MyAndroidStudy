package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 2017/4/12.
 */

public class AvatarViewDemo extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private BitmapShader mBitmapShader;
    private Matrix mMatrix;

    public AvatarViewDemo(Context context) {
        this(context, null);
    }

    public AvatarViewDemo(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public AvatarViewDemo(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.avatar);
        mBitmapShader = new BitmapShader(mBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        mMatrix = new Matrix();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float scale = getWidth() / mBitmap.getWidth();
        mMatrix.setScale(scale, scale);
        mBitmapShader.setLocalMatrix(mMatrix);
        mPaint.setShader(mBitmapShader);
        float half = getWidth() / 2;
        canvas.drawCircle(half, half, getWidth() / 2, mPaint);
    }
}
