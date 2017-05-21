package com.example.lin.myandroidapplication.ui.casual;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ViewSwitcher;

import com.example.lin.myandroidapplication.R;

public class ViewSwitcherActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 1
     */
    private Button mSwitcherBtn01;
    /**
     * 2
     */
    private Button mSwitcherBtn02;
    private ViewSwitcher mSwitcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_switcher);
        initView();
    }

    private void initView() {
        mSwitcherBtn01 = (Button) findViewById(R.id.switcher_btn_01);
        mSwitcherBtn01.setOnClickListener(this);
        mSwitcherBtn02 = (Button) findViewById(R.id.switcher_btn_02);
        mSwitcherBtn02.setOnClickListener(this);
        mSwitcher = (ViewSwitcher) findViewById(R.id.viewswitcher);
        Animation inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        mSwitcher.setInAnimation(inAnimation);
        mSwitcher.setOutAnimation(outAnimation);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.switcher_btn_01:
                mSwitcher.setDisplayedChild(1);
                break;
            case R.id.switcher_btn_02:
                mSwitcher.setDisplayedChild(0);
                break;
        }
    }
}
