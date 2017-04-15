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

    /**
     * 6.AnimatorSet -- playSequentially, playTogether
     * playSequentially表示所有动画依次播放。就是激活一个动画之后，动画之后的操作就是动画自己来负责了，这个动画结束后。
     * 再激活下一个动画。如果上一个动画没有结束，那下一个动画就永远也不会激活。
     * playTogether 表示所有动画一起开始。即只是同一个时间点上的一起开始，对于开始后，各个动画怎么操作就是他们自己的事了，
     * 至于各个动画结不结束也是他们自己的事。
     *
     */

    /**
     * 7.自由设置动画顺序 -- AnimatorSet.Builder
     * 一些相关函数:
     * //和前面动画一起执行
     * with(Animator anim)
     * //执行先执行这个动画再执行前面动画
     * after(animator anim)
     * //执行前面的动画后才执行该动画
     * before(Animator anim)
     * 延迟n毫秒之后执行动画
     * after(long delay)
     *
     * 以play中的当前所播放的动画为基准
     *
     * AnimatorSet设置的区别
     * //设置单次动画时长
     * setDuration(long duration)
     * //设置加速器
     * setInterpolator(TimeInterpolator interpolator)
     * //设置ObjectAnimator动画目标控件
     * setTarget(Object target)
     *
     * 区别就是:在AnimatorSet中设置以后，会覆盖单个OvjectAnimator中的设置；即如果AnimatorSet中没有设置，那么
     * 就以ObjectAnimator中的设置为准。如果AnimatorSet中设置以后，ObjectAnimator中的设置就会无效。
     */

    /**
     * 8.联合动画中的xml实现
     * <animator/> 对应ValueAnimator
     * <objectAnimator/> 对应ObjectAnimator
     * <set/> 对应AnimatorSet
     *
     * <animator/>字段:
     * duration="int" 每次动画播放的时长
     * valueFrom="float|int|color" 初始动画值；取值范围为float，int，color
     * valueTo="float|int|color"动画结束之，取值范围xxx
     * startOffset="int" 动画激活延时；对应代码中的startDelay(long delay)函数
     * repeatCount="int" 动画重复次数
     * repeatMode="repeat|reverse" 动画重复模式，取值为repeat和reverse；repeat表示正序，reverse表示倒序
     * valueType="intType|floatType" 表示参数类型，与valueFrom、valueTo相对应。如果valueTo、valueFrom
     * 为color类型的值，那么不需要设置这个参数。
     * interpolator=["@android:interpolator/xxx"] 设置加速器
     * 在定义一个xml后，我们需要将其加载到程序中，使用的方法如下
     * ValueAnimator valueAnimator = (ValueAnimator)AnimatorInflater.loadAnimator(context, R.animator.xx)
     * valueAnimator.start();
     *
     * <objectAnimator/>字段:
     * propertyName="string" 对应属性名，即ObjectAnimator所需要操作的属性名
     * duration:xxx
     * valueFrom:xxx
     * valueTo:xxx
     * startOffset:xxx
     * repeatCount:xxx
     * repeatMode:xxx
     * valueType:xxx
     * interpolator:xxx
     * 使用同上:
     * xxx
     * animator.setTarget(view)
     * xxx
     *
     * <set/>字段:
     * ordering="together|sequentially" 表示动画开始顺序。together表示同时开始动画，sequentially表示逐个开始动画
     * 使用：
     * AnimatorSet set = (AnimatorSet) AnimatorInflater.laodAnimator(context, R.animator.xxxx)
     * set.setTarget(view)
     * set.start();
     */
}
