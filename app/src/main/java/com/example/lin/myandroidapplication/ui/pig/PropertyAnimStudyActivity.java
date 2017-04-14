package com.example.lin.myandroidapplication.ui.pig;

import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import com.example.lin.myandroidapplication.R;

/**
 * android动画中，总共有两种类型的动画 View Animation(视图动画)和Property Animation(属性动画)
 * 其中View Animation包括Tween Animation(补间动画) 和 Frame Animation(逐帧动画)
 * Property Animation包括ValueAnimator 和 ObjectAnimation
 * 直观上，它们有如下三点不同：
 * 1.引入时间不同:View Animation是API Level 1 就引入的。Property Animation是API Level 11 引入的，
 * 即Android3.0才开始有Property Animation相关的API.
 * 2.所在包名不同：View Animation在包android.view.animation中。而Property Animation API在包android.animation中。
 * 3.动画类的命名不同：View Animation中动画类取名豆角XXXXAnimation，而在Property Animator中动画类取名则叫XXXXAnimator
 */
public class PropertyAnimStudyActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 常用的方法总结:
     * //设置动画时长，单位是毫秒
     * 1.ValueAnimator setDuration(long duration)
     * //获取ValueAnimator在运动时，当前运动点的值
     * Object getAnimatedValue(); 通过getAnimatedValue()的值类型与初始设置动画时的值类型相同。
     * //开始动画
     * void start()
     * //设置循环次数，设置为INFINITE表示无限循环
     * void setRepeatCount(int value)
     * //设置循环模式， value的取值有RESTART、REVERSE
     * void setRepeatMode(int value)
     * //取消动画
     * void cancle()
     *
     */

    /**
     * 在ValueAnimator中共有两个监听器:
     * 1. 监听动画变化时的实时值
     * public static interface AnimatorUpdateListener {
     *     void onAnimationUpdate(ValueAnimator animation)
     * }
     * 2.监听动画变化时四个状态
     * public static interface AnimatorListener {
     *     void AnimationStart(Animator animation)
     *     ...
     *     ...
     *     ...
     * }
     */

    /**
     * 移除动画监听器
     * //移除AnimatorUpdateListener
     * void removeUpdateListener(AnimatorUpdateListener listener)
     * void removeAllUpdateListeners();
     * //移除AnimatorListener
     * void removeListener(AnimatorListener listener)
     * void removeAllListeners();
     */

    /**
     * 其他一些函数
     * //延时多久时间开始，单位是毫秒
     * public void setStartDelay(long startDelay)
     * //完全克隆一个ValueAnimator实例，包括它所有的设置以及所有对监听器代码的处理
     * public ValueAnimator clone()
     */

    private ImageView mImageView;
    private ObjectAnimator mAnimator;
    /**
     * value_scale
     */
    private Button mValueAnimBtn01;
    /**
     * value_alpha
     */
    private Button mValueAnimBtn02;
    /**
     * value_translate
     */
    private Button mValueAnimBtn03;
    /**
     * value_rotate
     */
    private Button mValueAnimBtn04;
    /**
     * value_set
     */
    private Button mValueAnimBtn05;
    private ValueAnimator mValueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_anim_study);
        initView();
        bindView();
    }

    private void bindView() {
        Button scaleBtn = (Button) findViewById(R.id.obj_anim_btn_01);
        Button alphaBtn = (Button) findViewById(R.id.obj_anim_btn_02);
        Button translateBtn = (Button) findViewById(R.id.obj_anim_btn_03);
        Button rotateBtn = (Button) findViewById(R.id.obj_anim_btn_04);
        Button setBtn = (Button) findViewById(R.id.obj_anim_btn_05);
        mImageView = (ImageView) findViewById(R.id.obj_anim_test_img);

        scaleBtn.setOnClickListener(this);
        alphaBtn.setOnClickListener(this);
        translateBtn.setOnClickListener(this);
        rotateBtn.setOnClickListener(this);
        setBtn.setOnClickListener(this);
    }

    /**
     * 通过ofxxx系列方法获得ValueAnimator(ObjectAnimator是ValueAnimator子类)
     * 其中ValueAnimator还需要调用addUpdateListener监听数值的变化，并将这些变化的数值作用于对应的View上
     * 传什么进去 通过 getAnimatedValue(方法就获得什么)
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.obj_anim_btn_01:
                mAnimator = ObjectAnimator.ofFloat(mImageView, "scaleY", 0f, 300f, 1f);
                mAnimator.setDuration(5000);
                mAnimator.start();
                break;
            case R.id.obj_anim_btn_02:
                mAnimator = ObjectAnimator.ofFloat(mImageView, "alpha", 0f, 1f, 0f);
                mAnimator.setDuration(6000);
                mAnimator.start();
                break;
            case R.id.obj_anim_btn_03:
                mAnimator = ObjectAnimator.ofFloat(mImageView, "translationX", 0f, 300f, 0f);
                mAnimator.setDuration(6000);
                mAnimator.start();
                break;
            case R.id.obj_anim_btn_04:
                mAnimator = ObjectAnimator.ofFloat(mImageView, "rotation", 0f, 360f);
                mAnimator.setDuration(6000);
                mAnimator.start();
                break;
            case R.id.obj_anim_btn_05:
                ObjectAnimator moveIn = ObjectAnimator.ofFloat(mImageView, "translationX", -500f, 0f);
                ObjectAnimator rotate = ObjectAnimator.ofFloat(mImageView, "rotation", 0f, 360f);
                ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(mImageView, "alpha", 1f, 0f, 1f);
                AnimatorSet set = new AnimatorSet();
                set.play(rotate).with(fadeInOut).after(moveIn);
                set.setDuration(6000);
                set.start();
                break;
            case R.id.value_anim_btn_01:
                mValueAnimator = ValueAnimator.ofInt(0, 100, -100, 0);
                mValueAnimator.setDuration(4000);
                mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValueInt = (int) animation.getAnimatedValue();
                        mImageView.layout(curValueInt, curValueInt,
                                curValueInt + mImageView.getWidth(), curValueInt + mImageView.getHeight());
                    }
                });
                mValueAnimator.start();
                break;
            case R.id.value_anim_btn_02:
                mValueAnimator = ValueAnimator.ofInt(400, 600, 200, 400);
                mValueAnimator.setDuration(10000);
                mValueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValueInt = (int) animation.getAnimatedValue();
                        mImageView.layout(curValueInt, curValueInt,
                                curValueInt + mImageView.getWidth(), curValueInt + mImageView.getHeight());
                    }
                });
                mValueAnimator.setInterpolator(new BounceInterpolator());
                mValueAnimator.start();
                break;
            case R.id.value_anim_btn_03:
                PropertyValuesHolder rotationHolder = PropertyValuesHolder.ofFloat("rotation", 0, 60f, 0, -60f, 0);
                PropertyValuesHolder translateHolder = PropertyValuesHolder.ofFloat("translationX", 200, -200, 200, -200);
                mAnimator = ObjectAnimator.ofPropertyValuesHolder(mImageView, rotationHolder, translateHolder);
                mAnimator.setInterpolator(new AccelerateInterpolator());
                mAnimator.setDuration(10000);
                mAnimator.start();
                break;
            case R.id.value_anim_btn_04:
                PropertyValuesHolder holder = getHolder();
                mAnimator = ObjectAnimator.ofPropertyValuesHolder(mImageView, holder);
                mAnimator.setDuration(10000);
                mAnimator.start();
                break;
            case R.id.value_anim_btn_05:
                break;
            default:
                break;
        }
    }

    private void initView() {
        mValueAnimBtn01 = (Button) findViewById(R.id.value_anim_btn_01);
        mValueAnimBtn01.setOnClickListener(this);
        mValueAnimBtn02 = (Button) findViewById(R.id.value_anim_btn_02);
        mValueAnimBtn02.setOnClickListener(this);
        mValueAnimBtn03 = (Button) findViewById(R.id.value_anim_btn_03);
        mValueAnimBtn03.setOnClickListener(this);
        mValueAnimBtn04 = (Button) findViewById(R.id.value_anim_btn_04);
        mValueAnimBtn04.setOnClickListener(this);
        mValueAnimBtn05 = (Button) findViewById(R.id.value_anim_btn_05);
        mValueAnimBtn05.setOnClickListener(this);
    }

    private PropertyValuesHolder getHolder() {
        Keyframe keyframe = Keyframe.ofFloat(0f, 0);
        Keyframe keyframe1 = Keyframe.ofFloat(0.25f, -20f);
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f, 0);
        Keyframe keyframe3 = Keyframe.ofFloat(0.75f, 20f);
        Keyframe keyframe4 = Keyframe.ofFloat(1, 0);
        return PropertyValuesHolder.ofKeyframe("rotation", keyframe, keyframe1,
                keyframe2, keyframe3, keyframe4);
    }
}
