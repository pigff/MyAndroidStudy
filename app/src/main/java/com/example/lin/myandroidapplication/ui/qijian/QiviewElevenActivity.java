package com.example.lin.myandroidapplication.ui.qijian;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.lin.myandroidapplication.R;

/**
 * sin(double d) 求对应弧度的正弦值
 * cos(double d) 求对应弧度的余弦值
 * tan(double d) 求对应弧度的正切值
 * <p>
 * 两种方法求得弧度值：
 * Math.PI 不仅表示圆周率π 也代表180度角所对应的弧度值
 * Math.sin(Math.PI/2) 就表示90度的正弦值
 * <p>
 * toRadians(double angdeg) 根据读书得到弧度值的函数
 */
public class QiviewElevenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mMenu;
    private Button mItem1;
    private Button mItem2;
    private Button mItem3;
    private Button mItem4;
    private Button mItem5;

    private boolean mIsMenuOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qiview_eleven);
        initView();
    }

    private void initView() {
        mMenu = (Button) findViewById(R.id.menu);
        mMenu.setOnClickListener(this);
        mItem1 = (Button) findViewById(R.id.item1);
        mItem1.setOnClickListener(this);
        mItem2 = (Button) findViewById(R.id.item2);
        mItem2.setOnClickListener(this);
        mItem3 = (Button) findViewById(R.id.item3);
        mItem3.setOnClickListener(this);
        mItem4 = (Button) findViewById(R.id.item4);
        mItem4.setOnClickListener(this);
        mItem5 = (Button) findViewById(R.id.item5);
        mItem5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.menu:
                if (!mIsMenuOpen) {
                    mIsMenuOpen = true;
                    doAnimateOpen(mItem1, 0, 5, 300);
                    doAnimateOpen(mItem2, 1, 5, 300);
                    doAnimateOpen(mItem3, 2, 5, 300);
                    doAnimateOpen(mItem4, 3, 5, 300);
                    doAnimateOpen(mItem5, 4, 5, 300);
                } else {
                    mIsMenuOpen = false;
                    doAnimateColse(mItem1, 0, 5, 300);
                    doAnimateColse(mItem2, 1, 5, 300);
                    doAnimateColse(mItem3, 2, 5, 300);
                    doAnimateColse(mItem4, 3, 5, 300);
                    doAnimateColse(mItem5, 4, 5, 300);
                }
                break;
            case R.id.item1:
                Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item2:
                Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item3:
                Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item4:
                Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.item5:
                Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void doAnimateOpen(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.toRadians(90) / (total - 1) * index;
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));

        AnimatorSet set = new AnimatorSet();
        set.playTogether(ObjectAnimator.ofFloat(view, "translationX", 0, translationX)
                , ObjectAnimator.ofFloat(view, "translationY", 0, translationY)
                , ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f)
                , ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f)
                , ObjectAnimator.ofFloat(view, "alpha", 0f, 1));

        set.setDuration(500).start();
    }

    private void doAnimateColse(View view, int index, int total, int radius) {
        if (view.getVisibility() != View.VISIBLE) {
            view.setVisibility(View.VISIBLE);
        }
        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int) (radius * Math.sin(degree));
        int translationY = -(int) (radius * Math.cos(degree));
        AnimatorSet set = new AnimatorSet();
        //缩放 为0的时候 展开动画失效了。。
        set.playTogether(ObjectAnimator.ofFloat(view, "translationX", translationX, 0)
                , ObjectAnimator.ofFloat(view, "translationY", translationY, 0)
                , ObjectAnimator.ofFloat(view, "scaleX", 1f, 0.1f)
                , ObjectAnimator.ofFloat(view, "scaleY", 1f, 0.1f)
                , ObjectAnimator.ofFloat(view, "alpha", 1f, 0f));
        set.setDuration(500).start();
    }
}
