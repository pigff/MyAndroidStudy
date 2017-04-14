package com.example.lin.myandroidapplication.evaluator;

import android.view.animation.Interpolator;

/**
 * Created by greedy on 2017/4/14.
 */

public class MyInterpolator implements Interpolator {


    /**
     * 参数input：input参数是一个float类型，它取值范围是0到1，表示当前动画的进度，取0表示动画刚开始，
     * 取1表示动画结束，取0.5时表示动画中间的位置，其他类推。
     * 返回值：表示当前实际想要显示的进度。取值可以超过1也可以小于0，超过1表示已经超过目标值，小于0表示小于开始位置
     *
     * input参数与任何设定的值都没有关系，只与实践有关，随着实践的增长，动画的进度也自然的增加，input参数就代表了动画的进度。
     * 而返回值则表示动画的当前数值进度
     * @param input
     * @return
     */
    @Override
    public float getInterpolation(float input) {
        return 0;
    }
}
