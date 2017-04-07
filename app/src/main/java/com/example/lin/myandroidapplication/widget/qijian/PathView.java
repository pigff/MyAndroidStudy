package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by greedy on 2017/4/7.
 * Path的相关方法
 * moveTo(float x1, float y1)直线的开始点，即将直线路径的绘制点定在(x1, y1)
 * lineTo(float x2, float y2)直线的结束点，又是下一次绘制直线路径的开始点， lineTo()可以一直用
 * close()如果连续花了几条直线，但没有形成闭环，调用close()会将路径首尾点连接起来，形成闭环
 */

public class PathView extends View {

    private Paint mPaint;
    private Path mPath;

    public PathView(Context context) {
        this(context, null);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPath = new Path();
    }

    /**
     * 矩形路径
     * addRect(RectF rect, Path.Direction dir)
     * 唯一不同的是增加了Path.Direction参数
     * Path.Direction.CCW 创建逆时针方向的矩形路径
     * Path.Direction.CW  创建顺时针方向的矩形路径
     * <p>
     * 圆角矩形路径
     * addRoundRect(RectF rect, float[] radii, Path.Direction dir)
     * addRoundRect(RectF rect, float rx, float ry, Path.Direction dir)
     * float[] radii 必须传入8个数值，分四组， 分别对应每个角所使用的椭圆的横轴半径和纵轴半径 (0-0 头皮发麻)左-上-右-下
     * 第二个构造函数:只能构建统一圆角的大小
     * float rx: 所产生的圆角的椭圆的横轴半径；
     * float ry: 所长生的圆角的拖延的纵轴半径
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        RectF rectF = new RectF(50, 50, 240, 200);
        RectF rectF1 = new RectF(290, 50, 480, 200);
//        mPath.moveTo(10, 10);  // 设定起始点
//        mPath.lineTo(10, 100);  // 第一条直线的终点， 也是第二条直线的起点
//        mPath.lineTo(300, 100); //画第二条直线
//        mPath.lineTo(500, 100); // 第三条直线
//        mPath.close();  //闭环
//        canvas.drawPath(mPath, mPaint);
//        String text = "风萧萧易水寒，壮士一去兮不复返";
//        mPaint.setTextSize(35);
//        mPath.addRect(rectF, Path.Direction.CW);
//        canvas.drawPath(mPath, mPaint);
//        mPaint.setColor(Color.GRAY);
//        canvas.drawTextOnPath(text, mPath, 0, 18, mPaint);

//        mPath.addRoundRect(rectF, 10, 15, Path.Direction.CCW);
//        float[] radii = {10, 15, 20, 25, 30, 35, 40, 45};
//        mPath.addRoundRect(rectF1, radii, Path.Direction.CCW);

        mPath.addCircle(100, 400, 100, Path.Direction.CCW);
        mPath.addOval(rectF, Path.Direction.CCW);
        mPath.addArc(rectF1, 0, 120);
        canvas.drawPath(mPath, mPaint);
    }
}
