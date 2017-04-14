package com.example.lin.myandroidapplication.widget.qijian.anim;

/**
 * 记录插值器相关
 */

public interface InterpolatorInterface {

    /**
     * AccelerateDecelerateInterpolator 在动画开始的地方速率改变比较慢，在中间的时候加速
     * AccelerateInterpolator           在动画开始的地方速率改变比较慢， 然后开始加速(常用)
     * AnticipateInterpolator           在开始的时候向后然后向前甩
     * AnticipateOvershootInterpolator  开始的时候向后然后向前甩一定值后返回最后的值(常用)
     * BounceInterpolator               动画结束的时候弹起(常用)
     * CycleInterpolator                动画循环播放特定的次数，速率改变沿着正弦曲线
     * DecelerateInterpolator           在动画开始的地方快然后慢
     * LinearInterpolator               以常量速率改变(常用)  (感觉这个应该是个默认值)
     * OvershootInterpolator            向前甩一定值后在回到原来位置
     */
}
