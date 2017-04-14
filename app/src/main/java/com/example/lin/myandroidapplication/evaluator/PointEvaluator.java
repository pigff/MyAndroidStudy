package com.example.lin.myandroidapplication.evaluator;

import android.animation.TypeEvaluator;

import com.example.lin.myandroidapplication.data.Point;

/**
 * Created by lin on 2016/12/21.
 * Evaluator其实就是一个转换器，他能把小数进度转换成对应的数值位置
 */
public class PointEvaluator implements TypeEvaluator {
    @Override
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        Point startPoint = (Point) startValue;
        Point endPoint = (Point) endValue;
        float x = startPoint.getX() + fraction * (endPoint.getX() - startPoint.getX());
        float y = startPoint.getY() + fraction * (endPoint.getY() - startPoint.getY());
        Point point = new Point(x, y);
        return point;
    }
}
