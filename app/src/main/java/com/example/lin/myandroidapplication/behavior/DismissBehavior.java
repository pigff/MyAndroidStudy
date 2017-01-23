package com.example.lin.myandroidapplication.behavior;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Created by lin on 2016/12/29.
 */
public class DismissBehavior extends CoordinatorLayout.Behavior<LinearLayout> {

    private float mStartY;
    private float mChildY;

    public DismissBehavior(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, LinearLayout child, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, LinearLayout child, View dependency) {
        if (mStartY == 0) {
            mStartY = dependency.getY();
            mChildY =  child.getY();
        } else {
            float offestY = mStartY - dependency.getY();
            child.setY(mChildY +  offestY);
        }
        return true;
    }
}
