package com.example.lin.myandroidapplication.widget;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.BounceInterpolator;

import com.example.lin.myandroidapplication.data.Point;
import com.example.lin.myandroidapplication.evaluator.ColorEvaluator;
import com.example.lin.myandroidapplication.evaluator.PointEvaluator;

/**
 * Created by lin on 2016/12/21.
 */
public class MyAnimView extends View {
    public static final int RADIUS = 50;

    private Point mCurrentPoint;
    private Paint mPaint;
    private int mColor;

    public MyAnimView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (mCurrentPoint == null) {
            mCurrentPoint = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void drawCircle(Canvas canvas) {
        float x = mCurrentPoint.getX();
        float y = mCurrentPoint.getY();
        canvas.drawCircle(x, y, RADIUS, mPaint);
    }


    /**
     * ObjectAnimator ofxxx(Object target, String propertyName, float...values);
     * 第一个参数用于指定这个动画要操作的是哪个控件
     * 第二个参数用于指定这个动画要操作这个控件的哪个属性
     * 第三个参数是可变参数，这个就跟ValueAnimator中的可变长参数的意义一样了，就是指这个属性值是从哪变到哪。
     * ------
     * 要使用ObjectAnimator来构造动画，要操作的控件中，必须存在对应的属性的set方法
     * setter方法的命名必须以驼峰法来命名，即set后每个单词首字母大写，其余字母小写，即类似于
     * setPropertyName所对应的属性为propertyName
     * ------
     * 注意事项：
     * 1.拼接set函数的方法：上面我们也说了是首先是强制将属性的第一个字母大写，然后与set拼接，就是对应set函数的名字。
     * 注意，只是强制将属性的第一个字母大写，后面的部分是保持不变的。反过来，如果我们的函数名命名为setScalePointX(float x)
     * 那我们在写属性时候可以写成"scalePointX"或者"ScalePointX"都是可以的，即第一个字母大小写可以随意，但是后面的部分必须
     * 与set方法后面的大小写保持一致。
     * 2.如何确定函数的参数类型：上面我们知道了如何找到对应的函数名，那对应的参数方法的参数类型如何确定呢？我们在讲ValueAnimator的
     * 时候说过，动画过程中产生的数字值与构造时传入的值类型是一样的。由于ObjectAnimator与valueAnimator在插值器和Evaluator这两步
     * 是一样的，所以ObjectAnimator的动画中产生的数值类型也是与构造时的类型一样的。(如果没找到对应的 则系统会报一个错误(不是异常不会闪退))
     * -----
     * 当且仅当动画只有一个过渡值的时候，系统才会调用对应属性的get函数来得到动画的初始值。
     */
    public void startAnimation() {
        Point startPoint = new Point(getWidth() / 2, RADIUS);
        Point endPoint = new Point(getWidth() / 2, getHeight() - RADIUS);
//        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
//        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                mCurrentPoint = (Point) animation.getAnimatedValue();
//                invalidate();
//            }
//        });
//        ObjectAnimator animator1 = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), Color.WHITE, Color.BLACK);
//        AnimatorSet set = new AnimatorSet();
//        set.play(animator).with(animator1);
//        set.setInterpolator(new BounceInterpolator());
//        set.setDuration(5000);
//        set.start();

        PropertyValuesHolder pointHolder = PropertyValuesHolder.
                ofObject("point", new PointEvaluator(), startPoint, endPoint);
        PropertyValuesHolder colorHolder = PropertyValuesHolder.
                ofObject("color", new ColorEvaluator(), Color.WHITE, Color.BLACK);
        AnimatorSet set2 = new AnimatorSet();
        set2.play(ObjectAnimator.ofPropertyValuesHolder(this, pointHolder))
                .with(ObjectAnimator.ofPropertyValuesHolder(this, colorHolder));
        set2.setInterpolator(new BounceInterpolator());
        set2.setDuration(5000);
        //为什么会无效呢
//        set2.setTarget(this);
        set2.start();
    }

    public int getColor() {
        return mColor;
    }

    public void setColor(int color) {
        mColor = color;
        mPaint.setColor(mColor);
        invalidate();
    }

    public void setPoint(Point point) {
        mCurrentPoint = point;
        invalidate();
    }
}
