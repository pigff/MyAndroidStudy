package com.example.lin.myandroidapplication.widget.qijian.anim;

/**
 * 记录动画相关
 */

public interface AnimationInterface {
    /**
     * 1.在代码中使用xml定义的动画
     * Animation animation = AnimationUtils.loadAnimation(this, R.anim.scale_anim); // 从xml文件中获取动画
     * view.startAnimation(animation);
     */

    /**
     * xml中的动画与java中的动画对比
     * scale ---- ScaleAnimation
     * alpha ---- AlphaAnimation
     * rotate ---- RotateAnimation
     * translate ---- TranslateAnimation
     * set ---- AnimationSet
     */

    /**
     * 3.ScaleAnimation
     * ScaleAnimation(Context context, AttributeSet attrs) 从XML文件加载动画，基本用不到
     * ScaleAnimation(float fromX, float toX, float fromY, float toY)
     * ScaleAnimation(float fromX, float toX, float fromY, float toY, float pivotX, float pivotY)
     * ScaleAnimation(float fromX, float toX, float fromY, float toY,
     * int pivotXType float pivotXValue, int pivotYType, float pivoYValue)
     * pivotXType/pivotYType 取值有三个，Animation.ABSOLUTE, Animation.RELATIVE_TO_SELF和Animation.RELATIVE_TO_PARENT
     */

    /**
     * 4.AlphaAnimation
     * AlphaAnimation(Context context, AttributeSet attrs) 从本地XML加载动画，基本不用
     * AlphaAnimation(float fromAlpha, float toAlpha)
     */

    /**
     * 5.RotateAnimation
     * RotateAnimation(Context context, AttributeSet attrs) 同上
     * RotateAnimation(float fromDegrees, float toDegrees)
     * RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY)
     * RotateAnimation(float fromDegrees, float toDegrees,
     * int pivotXType, float pivotXValue, int pivotYType, float pivotYValue)
     * pivotXType/pivotYType 值参考ScaleAnimation中所记录
     */

    /**
     * 6.TranslateAnimation
     * TranslateAnimation(Context context, AttributeSet attrs) 同上
     * TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
     * TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue,
     * int fromYType, float fromYValue, int toYType, float toYValue)
     * fromXType、fromYType、toXType、toYType 值参考ScaleAnimation中所记录
     */

    /**
     * 7.AnimationSet
     * AnimationSet(Context context, AttributeSet attrs) 同上
     * AnimationSet(boolean shareInterpolator) 取值为true或false，取true时，指在AnimationSet中定义一个插值器
     * 它下面的所有动画共同。如果设为false，则表示它下面的动画自己定义各自的插值器
     *
     * public void addAnimation(Animation a) 添加动画
     */

    /**
     * 8.代码中使用插值器
     * ScaleAnimation anim = new ScaleAnimation(xxxxxx);
     * anim.setInterpolator(new BounceInterpolator())  //设置插值器
     */

}
