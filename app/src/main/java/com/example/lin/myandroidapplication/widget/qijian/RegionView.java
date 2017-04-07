package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by greedy on 2017/4/7.
 * Region方法
 * 构造：
 * Region()
 * Region(Region region)        // 拷贝一个region的范围
 * Region(Rect r)       //创建一个矩形区域
 * Region(int left, int top, int right, int bottom)  // - 0 - 明显
 * setEmpty()  //置空
 * set(Region region)
 * set(int left, int top, int right, int bottom)
 * setPath(Path path, Region clip)      根据路径的区域与某区域的交集，构造出新区域
 */

public class RegionView extends View {

    private Region mRegion;
    private Paint mPaint;
    private Region mRegion1;
    private Rect mRect;
    private Rect mRect1;
    private Paint mFillPaint;

    public RegionView(Context context) {
        this(context, null);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RegionView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);
//        mRegion = new Region(10, 10, 100, 100);
//        Path ovalPath = new Path();
//        RectF rect = new RectF(50, 50, 200, 500);
//        ovalPath.addOval(rect, Path.Direction.CCW);
//        //setPath时，传入一个比椭圆区域小的矩形区域，让其取交集
//        mRegion1 = new Region();
//        mRegion1.setPath(ovalPath, new Region(50, 50, 200, 200));
        mRect = new Rect(100, 100, 400, 200);
        mRect1 = new Rect(200, 0, 300, 300);

        mRegion = new Region(mRect);
        mRegion1 = new Region(mRect1);
//        mRegion.op(mRegion1, Region.Op.INTERSECT);
//        mRegion.op(mRegion1, Region.Op.DIFFERENCE);
//        mRegion.op(mRegion1, Region.Op.REPLACE);
//        mRegion.op(mRegion1, Region.Op.REVERSE_DIFFERENCE);
//        mRegion.op(mRegion1, Region.Op.UNION);
        mRegion.op(mRegion1, Region.Op.XOR);
        mFillPaint = new Paint();
        mFillPaint.setColor(Color.GREEN);
        mFillPaint.setStyle(Paint.Style.FILL);
    }

    /**
     * Region Op值
     * DIFFERENCE       最终区域为region1 与 region2不同的区域
     * INTERSECT        最终区域为region1 与 region2相交的区域
     * UNION            最终区域为region1 与 region2组合一起的区域
     * XOR              最终区域为region1 与 region2相交之外的区域
     * REVERSE_DIFFERENCE   最终区域为region2 与 region1不同的区域
     * REPLACE              最终区域为region2的区域
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
//        drawRegion(canvas, mRegion, mPaint);
//        drawRegion(canvas, mRegion1, mPaint);
        canvas.drawRect(mRect, mPaint);
        canvas.drawRect(mRect1, mPaint);
        drawRegion(canvas, mRegion, mFillPaint);
    }

    private void drawRegion(Canvas canvas, Region region, Paint paint) {
        RegionIterator iterator = new RegionIterator(region);
        Rect r = new Rect();
        while (iterator.next(r)) {
            canvas.drawRect(r, paint);
        }
    }
}
