package com.example.lin.myandroidapplication.widget.qijian.anim;

/**
 * 记录属性动画(code-pig系列没讲的)
 * 代码部分记录在PropertyAnimStudyActivity里
 * ------
 */

public interface PropertyAnimInterface {
    /**
     * 1.PropertyValuesHolder这个类的意义就是，它其中保存了动画过程中所需要操作的属性和对应的值。
     * 我们通过ofFloat(Object target, String propertyName, float... values)构造的动画，
     * ofFloat()的内部实现其实就是将传进来的参数封装成PropertyValuesHolder实例来保存动画状态。
     * 在封装成PropertyValuesHolder实例之后，后期的各种操作也是以PropertyValuesHolder为主的。
     */

    /**
     * 2.PropertyValuesHolder之ofFloat()、ofInt()
     * public static PropertyValuesHolder ofFloat(String propertyName, float... values)
     * public static PropertyValuesHolder ofInt(String propertyName, int... values)
     *
     * propertyName:表示ObjectAnimator需要操作的属性名。
     * values:属性对应的参数，同样是可变参数们可以指定多个。
     *
     * 设置PropertyValuesHolder: public static ObjectAnimator ofPropertyValuesHolder(Object target,
     * PropertyValuesHolder... values)
     * target:指需要执行动画的控件
     * values:是一个可变参数，可以传进去多个PropertyValuesHolder实例，由于每个PropertyValuesHolder实例都会针对一个属性做动画，
     * 所以如果传进去多个PropertyValuesHolder实例，将会对控件的多个属性同时做动画操作
     */

    /**
     * 3.PropertyValuesHolder之ofObject()
     * public static PropertyValuesHolder ofObject(String propertyName, TypeEvaluator evaluator, Object... object)
     *
     * propertyName:ObjectAnimation动画操作的属性名
     * evaluator:Evaluator实例，Evaluator是将当前动画进度计算出当前值的类，可以使用系统自带的IntEvaluator、FloatEvaluator
     * 也可以自定义。
     * values:可变长参数
     */

    /**
     * 4.关键帧:一个关键帧必须包含两个元素，一个是时间点，一个是位置。关键帧表示ide是某个物体在哪个时间点应该在哪个位置上。
     * public static Keyframe ofFloat(float fraction, float value)
     * fraction:表示当前的显示进度，即从加速器中getInterpolation()函数的返回值
     * value:表示当前应该在的位置
     *
     * 关键帧使用:
     * public static PropertyValuesHolder ofKeyframe(String propertyName, Keyframe...values)
     * propertyName:动画所要操作的属性名
     * values:Keyframe的列表，PropertyValuesHolder会根据每个Keyframe的设定，定时将制定的值输出给动画
     *
     * ofFloat、ofInt
     * ofFloat(float fraction)
     * ofFloat(float fraction, float value)
     *
     * ofInt(float fraction)
     * ofInt(float fraction, float value)
     * 若只用一个参数的构造函数需要用setter方法设置
     *
     * 常用函数
     * //设置fraction参数，即keyframe所对应的进度
     * setFraction(float fraction)
     * //设置当前keyframe所对应的值
     * setValue(Object value)
     * //设置keyframe动作期间所对应的插值器
     * setInterpolator(TimeInterpolator interpolator)
     *
     * ofObject(float fraction, Objcet object)
     * 当使用ofObject来做动画的时候，都必须调用frameHolder.setEvaluator设置Evaluator
     *
     * 帧数量的结论：
     * 1.如果去掉第0帧，将以第一个关键帧作为起始位置
     * 2.如果去掉起始帧，将以最后一个关键帧作为结束位置
     * 3.使用Keyframe来构建动画，至少要有两个或两个以上的帧
     *
     * 借助keyframe，不需要使用Animatorset，也能实现多个动画同时播放。这也是Objectanimator中
     * 唯一一个能够实现多动画同时播放的方法，其他的都只能实现针对一个属性动画的操作。
     */

    /**
     * 5.PropertyValuesHolder之其他常用的函数。
     * //设置动画的Evaluator
     * setEvaluator(TypeEvaluator evaluator)
     * //用于设置ofFloat所对应的动画值列表
     * setFloatValues(float...values)
     * //用于设置ofInt所对应的动画值列表
     * setIntValues(int...values)
     * //用于设置ofKeyframe所对应的动画值列表
     * setKeyframes(..)
     * //用于设置ofObject。。。
     * setObjectValues(...)
     * //设置动画属性名
     * setPropertyName(String propertyName)
     */
}
