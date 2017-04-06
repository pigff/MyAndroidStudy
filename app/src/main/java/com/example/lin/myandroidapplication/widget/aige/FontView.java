package com.example.lin.myandroidapplication.widget.aige;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by greedy on 17/3/16.
 * Paint的方法
 * ascent()  返回ascent值
 * descent() 同上
 * breakText(...) 这个方法让我们设置一个最大宽度不超过这个宽度的范围内返回实际测量值否则停止测量
 * getFontMetrics()系列 .. 自己
 *
 * getFontSpacing() 返回字符行间距
 * setUnderlineText(boolean underlineText) 设置下划线
 * setTypeface(Typeface typeface) 设置字体类型
 * 使用自己的字体 : textPaint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.NORMAL));
 * create(String familyName, int style) 和 create(Typeface family, int style)
 * Typeface typeface = Typeface.createFromAsset(context.getAssets(), "yourname.ttf");
 * textPaint.setTypeface(typeface);
 * createFromAsset(AssetManager mgr, String path)、createFromFile(String path)、createFromFile(File path)
 * setTextSkewX(float skewX) 这个方法设置水平方向上的倾斜，官方推崇-0.25可以得到比较好的倾斜文本效果，值为负则右倾为正则左倾
 * setTextScaleX(float scaleX) 将文本沿X轴水平缩放。大于1放大小于1缩小
 * setTextLocale(Locale locale) 设置地理位置...
 * setTextAlign(Paint.Align align) 设置文本的对其方式，有三种CENTER、LEFT和RIGHT
 * setSubpixelText(boolean subpixelText)设置是否打开文本的亚像素显示。  一种图形色彩优化技术
 * setStrikeThruText(boolean strikeThruText) 文本删除线
 * setLinearText(boolean linearText) 设置是否打开线性文本标识-- 在Android中文本的绘制是需要使用一个bitmap作为
 * 单位字符的缓存，既然是缓存必定要使用一定的空间，我们可以通过这个方法(传入true)告诉Android我们不需要这样的缓存
 * setFakeBoldText(boolean fakeBoldText) 设置文本仿粗体
 * setDither(boolean dither) 用来设置在绘制图像的时候抗抖动。
 *
 *
 */

public class FontView extends View {

    private static final String TAG = "FontView";

    private static final String TEXT = "ap爱哥ξτβбпшㄎㄊěǔぬも┰┠№＠↓";
    private Paint mPaint, mLinePaint;    //文本的画笔和中心线的画笔
    private Paint.FontMetrics mFontMetrics; // 文本测量对象

    private int mBaseX, mBaseY;

    public FontView(Context context) {
        this(context, null);
    }

    public FontView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    private void initPaint() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(40);
        mPaint.setColor(Color.BLACK);

        mLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mLinePaint.setStyle(Paint.Style.STROKE);
        mLinePaint.setStrokeWidth(1);
        mLinePaint.setColor(Color.RED);

        mFontMetrics = mPaint.getFontMetrics();

        Log.d(TAG, "mFontMetrics.ascent:" + mFontMetrics.ascent);
        Log.d(TAG, "mFontMetrics.top:" + mFontMetrics.top);
        Log.d(TAG, "mFontMetrics.leading:" + mFontMetrics.leading);
        Log.d(TAG, "mFontMetrics.descent:" + mFontMetrics.descent);
        Log.d(TAG, "mFontMetrics.bottom:" + mFontMetrics.bottom);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //计算Baseline绘制的起点X轴坐标
        mBaseX = (int) (canvas.getWidth() / 2 - mPaint.measureText(TEXT) / 2);
        //计算Baseline绘制的Y坐标
        mBaseY = canvas.getHeight() / 2;
//        mBaseY = (int) (canvas.getHeight() / 2 - (mPaint.descent() + mPaint.ascent() / 2));
        canvas.drawText(TEXT, mBaseX, mBaseY, mPaint);
        //为了便于理解我们在画布中心绘制一条中线
        canvas.drawLine(0, canvas.getHeight() / 2, canvas.getWidth(), canvas.getHeight() / 2, mLinePaint);
    }
}
