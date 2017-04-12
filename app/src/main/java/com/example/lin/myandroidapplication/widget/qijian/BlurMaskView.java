package com.example.lin.myandroidapplication.widget.qijian;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by greedy on 2017/4/12.
 * setMaskFilter(MaskFilter maskfilter)
 * BlurMaskFilter(float raidus, Blur style)
 * float radiu:用来定义模糊半径，同样是高斯模糊算法。
 * Blur style:发光样式，有内发光、外发光、和内外发光、分别对应：Blur.INNER(内发光)、Blur.SOLID(外发光})
 * 、Blur.NORMAL(内外发光)、Blur.OUTER(仅发光部分可见， 比较特殊)
 */

public class BlurMaskView extends View {

    private Paint mPaint;

    public BlurMaskView(Context context) {
        this(context, null);
    }

    public BlurMaskView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BlurMaskView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        mPaint.setColor(Color.RED);
        mPaint.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200, 200, 100, mPaint);
    }
}
