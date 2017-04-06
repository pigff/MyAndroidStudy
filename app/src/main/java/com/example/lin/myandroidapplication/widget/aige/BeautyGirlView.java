package com.example.lin.myandroidapplication.widget.aige;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.R;
import com.example.lin.myandroidapplication.util.AppUtils;

/**
 * Created by greedy on 17/3/14.
 * <p>
 * DisIn
 * <p>
 * Disout
 */

public class BeautyGirlView extends View {

    private Paint mPaint;
    private Bitmap mBitmapDis, mBitmapSrc; // 位图
    private PorterDuffXfermode mPorterDuffXfermode; // 图形混合模式

    private int x, y; // 位图绘制时左上角的起点坐标
    private int mScreenW, mScreenH;

    public BeautyGirlView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
//        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.DST_OUT);
        mPorterDuffXfermode = new PorterDuffXfermode(PorterDuff.Mode.SCREEN);
        initPaint();
        initRes(context);
    }

    private void initRes(Context context) {
        // 获取位图
//        mBitmapSrc = BitmapFactory.decodeResource(context.getResources(), R.drawable.bg_classical_beauty_girl);
        mBitmapDis = BitmapFactory.decodeResource(context.getResources(), R.drawable.img_classical_beauty_girl);
        mScreenW = AppUtils.getScreenWidthM();
        mScreenH = AppUtils.getScreenHeightM();

        /**
         * 计算位图绘制时左上角的坐标使其位于屏幕中心
         * 屏幕坐标x轴向左偏移位图一半的宽度
         * 屏幕坐标y轴向上偏移位图一半的高度
         */
        x = mScreenW / 2 - mBitmapDis.getWidth() / 2;
        y = mScreenH / 2 - mBitmapDis.getHeight() / 2;
//        x = mScreenW / 2 - mBitmapSrc.getWidth() / 2;
//        y = mScreenH / 2 - mBitmapSrc.getHeight() / 2;
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        /**
         * 将绘制操作保存到新的图层(更官方的说法应该是离屏缓存)
         */
        int sc = canvas.saveLayer(0, 0, mScreenW, mScreenH, null, Canvas.ALL_SAVE_FLAG);
//        canvas.drawColor(0xFF8f66DA);
        canvas.drawColor(0xcc1c093e);
        //先绘制dis目标图
//        canvas.drawBitmap(mBitmapDis, x, y, mPaint);
        //设置混合模式
        mPaint.setXfermode(mPorterDuffXfermode);
        //设置src源图
        canvas.drawBitmap(mBitmapDis, x, y, mPaint);
        //还原混合模式
        mPaint.setXfermode(null);
        //还原画布
        canvas.restoreToCount(sc);
    }
}
