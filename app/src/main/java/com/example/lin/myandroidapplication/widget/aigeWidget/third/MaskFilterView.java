package com.example.lin.myandroidapplication.widget.aigeWidget.third;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.util.AppUtils;

/**
 * Created by greedy on 17/3/16.
 * 显示绘制一个实心的正方形然后是绘制一张图片(带阴影效果)
 */

public class MaskFilterView extends View {

//    private static final int RECT_SIZE = 400;
//    private Paint mPaint;
    private Paint shadowPaint; // 画笔
    private Context mContext;
    private Bitmap mSrcBitmap, mShadowBitmap; // 位图和阴影位图

    private int x, y; //位图绘制时左上角的起点坐标

//    private int left, top, right, bottom;

    public MaskFilterView(Context context) {
        this(context, null);
    }

    public MaskFilterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mContext = context;
        initPaint();
        initRes();
    }

    private void initRes() {
        /**
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         */
//        left = AppUtils.getScreenWidthM() / 2 - RECT_SIZE;
//        top = AppUtils.getScreenHeightM() / 2 - RECT_SIZE;
//        right = AppUtils.getScreenWidthM() / 2 + RECT_SIZE;
//        bottom = AppUtils.getScreenHeightM() / 2 + RECT_SIZE;
        //获取位图
        mSrcBitmap = BitmapFactory.decodeResource(mContext.getResources(), R.drawable.img_pic);
        //获取位图的Alpha通道图
        mShadowBitmap = mSrcBitmap.extractAlpha();

        /*
        计算位图绘制时左上角的坐标使其位于屏幕中心
         */
        x = AppUtils.getScreenWidthM() / 2 - mSrcBitmap.getWidth() / 2;
        y = AppUtils.getScreenHeightM() / 2 - mSrcBitmap.getHeight() / 2;
    }

    private void initPaint() {
//        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(0xFF603811);

        /*
        设置画笔遮罩滤镜
        style还有三种: 分别是
        NORMAL:会将整个图像模糊掉
        OUTER: 在Alpha边界产生一层阴影且会将原本的图像变透明
        INNER: 则会在图像内部产生模糊
         */
//        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));

        shadowPaint = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        shadowPaint.setColor(Color.DKGRAY);
        shadowPaint.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.NORMAL));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawColor(Color.GRAY);
//        canvas.drawRect(left, top, right, bottom, mPaint);
        //先绘制阴影
        canvas.drawBitmap(mShadowBitmap, x, y, shadowPaint);
        //再绘制位图
        canvas.drawBitmap(mSrcBitmap, x, y, null);
    }
}
