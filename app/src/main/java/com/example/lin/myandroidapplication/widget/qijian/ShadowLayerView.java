package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.lin.myandroidapplication.R;

/**
 * Created by greedy on 2017/4/12.
 * setShadowLayer函数能够实现
 * 定制阴影模糊程度
 * 定制阴影偏移距离
 * 清除阴影和显示阴影
 * setShadowLayer(float radius, float dx, float dy, int color)
 * float radius:意识是模糊半径,radius越大越模糊，越小越清晰，但是如果radius设置为0，则阴影消失不见。
 * float dx: 阴影的横向偏移距离，正值向右偏移，负值向左偏移
 * float dy: 阴影的纵向偏移距离，正值向下偏移，负值向上偏移
 * int color: 绘制阴影的画笔颜色，即阴影的颜色(对图片阴影无效,图片的阴影是对图片对图片的边缘进行模糊，作为阴影的)
 *
 * 除了设置radius为0， 也可以使用paint.clearShadowLayer来清除阴影
 *
 * TextView及其派生类使用ShadowLayer添加阴影效果
 * xml属性：
 * android:shadowRidus
 * android:shadowDx
 * android:shadowDy
 * android:shadowColor
 */

public class ShadowLayerView extends View {

    private Paint mPaint;
    private Bitmap mBitmap;
    private Rect mRect;

    public ShadowLayerView(Context context) {
        this(context, null);
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ShadowLayerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint = new Paint();
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        mPaint.setColor(Color.GREEN);
        mPaint.setTextSize(25);
        mPaint.setShadowLayer(1, 10, 10, Color.GRAY);
        mRect = new Rect(200, 300, 200 + mBitmap.getWidth(), 300 + mBitmap.getHeight());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("嘻嘻嘻嘻", 100, 100, mPaint);
        canvas.drawCircle(200, 200, 50, mPaint);
        canvas.drawBitmap(mBitmap, null, mRect, mPaint);
    }
}
